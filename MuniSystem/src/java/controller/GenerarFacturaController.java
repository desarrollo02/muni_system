package controller;

import buil.FacturaDTOBuilder;
import buil.NombreTributoDTOListBuilder;
import dao.BaseCalculoDAO;
import dao.ComprobanteDAO;
import dao.MultaDAO;
import dao.TributoAnexoDAO;
import dao.TributoDAO;
import dto.FacturaDTO;
import dto.FacturaDetalleDTO;
import enumerados.TributoConRegistro;
import factura.BaseCalculo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.scene.chart.PieChart;
import javax.persistence.EntityManager;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;
import jpa.Tributo;
import jpa.TributoMulta;
import util.fabrica.Util;

public class GenerarFacturaController {
    
    private EntityManager em;
    private TributoDAO tributoDAO;
    private BaseCalculoDAO baseCalculoDAO;
    private ComprobanteDAO comprobanteDAO;
    private TributoAnexoDAO tributoAnexoDAO;
    private MultaDAO multaDAO;

    public GenerarFacturaController() {
        em = Util.getEm();
        tributoDAO = new  TributoDAO(em);
        baseCalculoDAO = new BaseCalculoDAO(em);
        comprobanteDAO = new ComprobanteDAO(em);
        tributoAnexoDAO = new TributoAnexoDAO(em);
        multaDAO = new MultaDAO(em);
    }
    
    public List<String> getNombreTributosAll(){
        List<Tributo> tributos = tributoDAO.getTributoConRegistroAll();
        return new NombreTributoDTOListBuilder().tributos(tributos).build();
    }
    
    public List<FacturaDTO> generarComprobantes(TributoConRegistro registro, Integer anio, String usuario){
        List<BaseCalculo> listaBase=null;
        Tributo tributo = tributoDAO.getTributoPorLugarDeRegistro(registro);
        em.getTransaction().begin();
            if(null != registro)switch (registro) {
            case INMOBILIARIO:
                listaBase = baseCalculoDAO.getBaseCalculoInmueble();
                break;
            case PATENTE:
                listaBase = baseCalculoDAO.getBaseCalculoPatenteComercial();
                break;
            case CEMENTERIO:
                listaBase = baseCalculoDAO.getBaseCalculoLoteCementerio();
                break;
            case VEHICULO:
                listaBase = baseCalculoDAO.getBaseCalculoHabilitacionVehiculo();
                break;
            case REGISTRO:
                listaBase = baseCalculoDAO.getBaseCalculoRegistroConducir();
                break;
            default:
                break;
            }
            List<FacturaDTO> facturasDTOs = new ArrayList<>();
            FacturaDTOBuilder factuaDTOBuilder;
            comprobanteDAO.elimianarComprobanteCab(anio, tributo);
            boolean pagado = false;
            for(BaseCalculo baseCalculo : listaBase){
                //preguntar si no esta pagado, si esta pagado usar continue
                pagado=comprobanteDAO.isPagado(anio, tributo, baseCalculo.getIdRef());
                if(pagado){
                    continue;
                }
                for(int i = 1; i <= tributo.getIdPeriodoCobro().getValor();i++){
                    factuaDTOBuilder = new FacturaDTOBuilder();
                    ComprobanteCabecera cabecera = new ComprobanteCabecera();
                    cabecera.setAnio(anio);
                    cabecera.setAnulado(Boolean.FALSE);
                    cabecera.setPagado(Boolean.FALSE);
                    cabecera.setFechaAlta(new Date());
                    cabecera.setUsuarioAlta(usuario);
                    cabecera.setPeriodo(i);
                    Calendar fecha = Calendar.getInstance();
                    fecha.set(Calendar.DAY_OF_MONTH, 1);
                    if(i==1){
                        fecha.set(anio, tributo.getPrimerVencimiento() -1, 1);
                    }else{
                        Integer mes = 12/tributo.getIdPeriodoCobro().getValor() + tributo.getPrimerVencimiento();
                        fecha.set(anio, mes -1, 1);
                    }    
                    cabecera.setVencimiento(fecha.getTime());
                    cabecera.setIdTributo(tributo);
                    cabecera.setId_ref(baseCalculo.getIdRef());
                    cabecera.setIdContribuyente(baseCalculo.getTitular());
                    cabecera.setTotalPagar(0.0);
                    comprobanteDAO.guardar(cabecera);
                    factuaDTOBuilder.caberera(cabecera);
                    factuaDTOBuilder.descripcionCalculo(baseCalculo.getDescripcionCalculo());
                    //Primero guardar el comprobante detalle del impuesto principal, con la multa
                    //y luego los anexos en un for
                    //Se debe calcular multa si hace falta
                    ComprobanteDetalle detalle = new ComprobanteDetalle();
                    detalle.setIdTributo(tributo);
                    detalle.setIdComprobanteCab(cabecera);
                    if(tributo.getIdUnidadMedida().getNombre().equals("Porcentaje del Valor")){
                        detalle.setMonto(baseCalculo.getValorBase() * tributo.getValor()/100);
                    }else{
                        detalle.setMonto(Double.parseDouble(tributo.getValor().toString()));
                    }
                    detalle.setEsMulta(Boolean.FALSE);
                    comprobanteDAO.guardar(detalle);
                    cabecera.setTotalPagar(cabecera.getTotalPagar() + detalle.getMonto());
                    factuaDTOBuilder.addDetalle(detalle);
                    Date hoy = new Date();
                    Integer diasAtraso = 0;
                    if(hoy.getTime() >  cabecera.getVencimiento().getTime()){
                        diasAtraso = multaDAO.getDiasAtraso(cabecera.getVencimiento(), hoy);
                    }
                    //se calcula solo el monto de la multa en otro detalle
                    if(diasAtraso > 0 && multaDAO.estaEnMora(tributo, diasAtraso)){
                        detalle = new ComprobanteDetalle();
                        detalle.setIdTributo(tributo);
                        detalle.setIdComprobanteCab(cabecera);
                        detalle.setEsMulta(Boolean.TRUE);
                        TributoMulta tributoMulta = multaDAO.getTributoMulta(tributo, diasAtraso);
                        if(tributoMulta.getIdUnidadMedida().getNombre().equals("Porcentaje del Valor")){
                            detalle.setMonto(baseCalculo.getValorBase() * tributo.getValor()/100 * tributoMulta.getValor()/100);
                        }else{
                            detalle.setMonto(Double.parseDouble(tributoMulta.getValor().toString()));
                        }
                        comprobanteDAO.guardar(detalle);
                        cabecera.setTotalPagar(cabecera.getTotalPagar() + detalle.getMonto());
                        factuaDTOBuilder.addDetalle(detalle);
                    }
                    //calculo de los tributos anexos
                    List<Tributo> tributosAnexos = tributoAnexoDAO.getAnexos(tributo);
                    for(Tributo tributoAnexo:tributosAnexos){
                        detalle = new ComprobanteDetalle();
                        detalle.setIdTributo(tributoAnexo);
                        detalle.setIdComprobanteCab(cabecera);
                        detalle.setEsMulta(Boolean.FALSE);
                        if(tributoAnexo.getIdUnidadMedida().getNombre().equals("Porcentaje del Valor")){
                            detalle.setMonto(baseCalculo.getValorBase() * tributoAnexo.getValor()/100 * tributoAnexo.getValor()/100);
                        }else{
                            detalle.setMonto(Double.parseDouble(tributoAnexo.getValor().toString()));
                        }
                        comprobanteDAO.guardar(detalle);
                        cabecera.setTotalPagar(cabecera.getTotalPagar() + detalle.getMonto());
                        factuaDTOBuilder.addDetalle(detalle);
                    }
                comprobanteDAO.actualizar(cabecera);
                facturasDTOs.add(factuaDTOBuilder.caberera(cabecera).build());
                }
            }
        em.getTransaction().commit();
        return facturasDTOs;
    }    
}
