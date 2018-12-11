package controller;

import buil.ContribuyenteDTOListBuilder;
import dao.ContribuyenteDAO;
import dto.ContribuyenteDTO;
import enumerados.TributoConRegistro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.Contribuyente;
import util.fabrica.Util;

public class GenerarAvisosController {
    
    private EntityManager em;
    private ContribuyenteDAO contribuyenteDAO;

    public GenerarAvisosController() {
        em = Util.getEm();
        contribuyenteDAO = new ContribuyenteDAO(em);
    }
    
    public List<ContribuyenteDTO> getContribuyentes(TributoConRegistro tipo, 
                                        Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        List<Contribuyente> contribuyentes=new ArrayList<>();
        if(tipo == tipo.INMOBILIARIO){
            contribuyentes = contribuyenteDAO.getContribuyentesInmobiliario(idCondribuyente, cedula, ruc, nombres, apellidos);
        }else if(tipo == tipo.PATENTE){
            contribuyentes = contribuyenteDAO.getContribuyentesPantente(idCondribuyente, cedula, ruc, nombres, apellidos);
        }else if(tipo == tipo.CEMENTERIO){
            contribuyentes = contribuyenteDAO.getContribuyentesCementerio(idCondribuyente, cedula, ruc, nombres, apellidos);
        }else if(tipo == tipo.VEHICULO){
            contribuyentes = contribuyenteDAO.getContribuyentesHabilitacion(idCondribuyente, cedula, ruc, nombres, apellidos);
        }else if(tipo == tipo.REGISTRO){
            contribuyentes = contribuyenteDAO.getContribuyentesRegistro(idCondribuyente, cedula, ruc, nombres, apellidos);
        }
        return new ContribuyenteDTOListBuilder().contribuyentes(contribuyentes).build();
    }
}
