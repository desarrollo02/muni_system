package controller;

import buil.NombreTributoDTOListBuilder;
import dao.BaseCalculoDAO;
import dao.ComprobanteDAO;
import dao.TributoAnexoDAO;
import dao.TributoDAO;
import dto.FacturaDTO;
import enumerados.TributoConRegistro;
import factura.BaseCalculo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;
import jpa.Tributo;
import util.fabrica.Util;

public class GenerarFacturaController {
    
    private EntityManager em;
    private TributoDAO tributoDAO;
    private BaseCalculoDAO baseCalculoDAO;
    private ComprobanteDAO comprobanteDAO;
    private TributoAnexoDAO tributoAnexoDAO;

    public GenerarFacturaController() {
        em = Util.getEm();
        tributoDAO = new  TributoDAO(em);
        baseCalculoDAO = new BaseCalculoDAO(em);
        comprobanteDAO = new ComprobanteDAO(em);
        tributoAnexoDAO = new TributoAnexoDAO(em);
    }
    
    public List<String> getNombreTributosAll(){
        List<Tributo> tributos = tributoDAO.getTributoConRegistroAll();
        return new NombreTributoDTOListBuilder().tributos(tributos).build();
    }
    
    public List<FacturaDTO> generarComprobantes(TributoConRegistro registro, Integer anio, String usuario){
        List<BaseCalculo> listaBase=null;
        Tributo tributo = tributoDAO.getTributoPorLugarDeRegistro(registro);
        if(registro == TributoConRegistro.INMOBILIARIO){
            listaBase = baseCalculoDAO.getBaseCalculoInmueble();       
        }
        List<FacturaDTO> facturasDTOs = new ArrayList<>();
        for(BaseCalculo baseCalculo : listaBase){
            for(int i = 1; i < tributo.getIdPeriodoCobro().getValor();i++){
                ComprobanteCabecera cabecera = new ComprobanteCabecera();
                cabecera.setAnio(anio);
                cabecera.setAnulado(Boolean.FALSE);
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
                comprobanteDAO.guardar(cabecera);
                //Primero guardar el comprobante detalle del impuesto principal y luego los anexos en un for
                //Se debe calcular multa si hace falta
                ComprobanteDetalle detalle = new ComprobanteDetalle();
                detalle.setIdTributo(tributo);
                detalle.setIdComprobanteCab(cabecera);
                //detalle.setMonto(baseCalculo.getValorBase() * tributo.);//se calcula solo el monto la multa en otro detalle
            }
        }
        return facturasDTOs;
    }    
}
