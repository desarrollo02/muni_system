package controller;

import buil.TributoFacturableDTOBuilder;
import dao.BaseCalculoDAO;
import dao.ComprobanteDAO;
import dao.ContribuyenteDAO;
import dao.MultaDAO;
import dao.TributoAnexoDAO;
import dao.TributoDAO;
import dto.TributoFacturableDTO;
import enumerados.TributoConRegistro;
import factura.BaseCalculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.Contribuyente;
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
                                    .build());
            }
        }
        return tributosFacurables;
    }
}
