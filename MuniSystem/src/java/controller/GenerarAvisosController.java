package controller;

import buil.ContribuyenteDTOListBuilder;
import dao.ContribuyenteDAO;
import dao.TributoDAO;
import dto.ContribuyenteDTO;
import enumerados.TributoConRegistro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.Contribuyente;
import jpa.Tributo;
import util.fabrica.Util;

public class GenerarAvisosController {
    
    private EntityManager em;
    private ContribuyenteDAO contribuyenteDAO;
    private TributoDAO tributoDAO;

    public GenerarAvisosController() {
        em = Util.getEm();
        contribuyenteDAO = new ContribuyenteDAO(em);
        tributoDAO = new TributoDAO(em);
    }
    
    public List<ContribuyenteDTO> getContribuyentes(TributoConRegistro tipo, 
                                        Integer anio){
        Tributo tributo = tributoDAO.getTributoPorLugarDeRegistro(tipo);
        List<Contribuyente> contribuyentes = contribuyenteDAO.getContribuyentes(tributo, anio);
        return new ContribuyenteDTOListBuilder().contribuyentes(contribuyentes).build();
    }
    
    public Integer getIdTributo(TributoConRegistro tipo){
        Tributo tributo = tributoDAO.getTributoPorLugarDeRegistro(tipo);
        return tributo.getIdTributo();
    }
}
