package controller;

import buil.FacturaDTOBuilder;
import buil.TributoFacturableDTOBuilder;
import dao.BaseCalculoDAO;
import dao.ComprobanteDAO;
import dao.ContribuyenteDAO;
import dao.MultaDAO;
import dao.TributoAnexoDAO;
import dao.TributoDAO;
import dto.FacturaDTO;
import dto.TributoFacturableDTO;
import enumerados.TributoConRegistro;
import factura.BaseCalculo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;
import jpa.Contribuyente;
import jpa.Tributo;
import jpa.TributoMulta;
import util.fabrica.Util;

public class GenerarFactInvController {
    
    private EntityManager em;
    private TributoDAO tributoDAO;
    private BaseCalculoDAO baseCalculoDAO;
    private ComprobanteDAO comprobanteDAO;
    private TributoAnexoDAO tributoAnexoDAO;
    private MultaDAO multaDAO;
    private ContribuyenteDAO contribuyenteDAO;

    public GenerarFactInvController() {
        em = Util.getEm();
        tributoDAO = new  TributoDAO(em);
        baseCalculoDAO = new BaseCalculoDAO(em);
        comprobanteDAO = new ComprobanteDAO(em);
        tributoAnexoDAO = new TributoAnexoDAO(em);
        multaDAO = new MultaDAO(em);
        contribuyenteDAO = new ContribuyenteDAO(em);
    }
    
    public List<TributoFacturableDTO> getTributosFacturables(TributoConRegistro registro, 
            Integer idCondribuyente, String cedula, String ruc, String nombres,
            String apellidos){
        List<BaseCalculo> listaBase=null;
        Contribuyente contribuyente = contribuyenteDAO.getContribuyente(idCondribuyente, cedula, ruc, nombres, apellidos);
        List<TributoFacturableDTO> tributosFacurables = new ArrayList<>();
        if(contribuyente != null){
            if(null != registro)switch (registro) {
                case INMOBILIARIO:
                    listaBase = baseCalculoDAO.getBaseCalculoInmueble(contribuyente);
                    break;
                case PATENTE:
                    listaBase = baseCalculoDAO.getBaseCalculoPatenteComercial(contribuyente);
                    break;
                case CEMENTERIO:
                    listaBase = baseCalculoDAO.getBaseCalculoLoteCementerio(contribuyente);
                    break;
                case VEHICULO:
                    listaBase = baseCalculoDAO.getBaseCalculoHabilitacionVehiculo(contribuyente);
                    break;
                case REGISTRO:
                    listaBase = baseCalculoDAO.getBaseCalculoRegistroConducir(contribuyente);
                    break;
                default:
                    break;
            }
            for(BaseCalculo baseCalculo :listaBase){
                tributosFacurables.add(new TributoFacturableDTOBuilder()
                                    .baseCalculo(baseCalculo)
                                    .registro(registro)
                                    .contribuyente(baseCalculo.getTitular())
                                    .build());
            }
        }
        return tributosFacurables;
    }
    
    public List<FacturaDTO> generarComprobantes(
            TributoFacturableDTO tributoFacturaable,
            Integer anio, 
            String usuario)throws SQLException{
        List<BaseCalculo> listaBase=null;
        Contribuyente contribuyente = contribuyenteDAO.getContribuyente(tributoFacturaable.getIdContribuyente(), null, null, null, null);
        Tributo tributo = tributoDAO.getTributoPorLugarDeRegistro(tributoFacturaable.getLugarRegistro());
        em.getTransaction().begin();
            if(tributoFacturaable.getLugarRegistro().equals("INMOBILIARIO")){
                listaBase = baseCalculoDAO.getBaseCalculoInmueble(contribuyente);
            }else if(tributoFacturaable.getLugarRegistro().equals("PATENTE")){
                listaBase = baseCalculoDAO.getBaseCalculoPatenteComercial(contribuyente);
            }else if(tributoFacturaable.getLugarRegistro().equals("CEMENTERIO")){
                listaBase = baseCalculoDAO.getBaseCalculoLoteCementerio(contribuyente);
            }else if(tributoFacturaable.getLugarRegistro().equals("VEHICULO")){
                listaBase = baseCalculoDAO.getBaseCalculoHabilitacionVehiculo(contribuyente);
            }else if(tributoFacturaable.getLugarRegistro().equals("REGISTRO")){
                 listaBase = baseCalculoDAO.getBaseCalculoRegistroConducir(contribuyente);
            }
        
            List<FacturaDTO> facturasDTOs = new ArrayList<>();
            FacturaDTOBuilder factuaDTOBuilder;
            boolean pagado = false;
            for(BaseCalculo baseCalculo : listaBase){
                 //preguntar si no esta pagado, si esta pagado usar continue
                pagado=comprobanteDAO.isPagado(anio, tributo, baseCalculo.getIdRef());
                if(pagado){
                    continue;
                }else{
                    comprobanteDAO.elimianarComprobanteCab(anio, tributo, baseCalculo.getIdRef());
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
                    cabecera.setVencimiento(hoy);
                    comprobanteDAO.actualizar(cabecera);
                    facturasDTOs.add(factuaDTOBuilder.caberera(cabecera).build());
                }
            }
        em.getTransaction().commit();
        return facturasDTOs;
    }
    
    public void rollbackTransaccion(){
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }    
    }
}
