package controller;

import buil.IngresoDTOBuilder;
import dao.ComprobanteDAO;
import dao.TributoDAO;
import dto.IngresoDTO;
import enumerados.TributoConRegistro;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.Tributo;
import util.fabrica.Util;


public class IngresosController {
    
    private EntityManager em;
    private ComprobanteDAO comprobanteDAO;
    private TributoDAO tributoDAO;

    public IngresosController() {
        em = Util.getEm();
        comprobanteDAO = new ComprobanteDAO(em);
        tributoDAO = new TributoDAO(em);
    }
    
    public IngresoDTO getIngreso(Integer anio, TributoConRegistro tipo){
        Tributo tributo = tributoDAO.getTributoPorLugarDeRegistro(tipo);
        Double montoEstimado = comprobanteDAO.getMontoEstimado(tributo, anio);
        Double montoIngreso = comprobanteDAO.getMontoIngreso(tributo, anio);
        Double montoFaltante = montoEstimado -  montoIngreso;
        Double porcentajeFaltante = 0.0;
        if(montoEstimado > 0.0){
            porcentajeFaltante = montoFaltante/montoEstimado*100;
        }
         
        return new IngresoDTOBuilder()
                .anio(anio)
                .tributo(tributo)
                .montoEstimadio(montoEstimado)
                .montoIngreso(montoIngreso)
                .montoFaltante(montoFaltante)
                .porcentajeFaltante(porcentajeFaltante)
                .build();
    }
}
