/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.manager;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import jpa.ComprobanteCabecera;
import jpa.Contribuyente;
import manager.BaseManager;

/**
 *
 * @author USUARIO
 */
public class EstadoCuentaManager extends BaseManager{
    
    public List<ComprobanteCabecera> getComprobantes(Contribuyente contribuyente){
        Query query = getEm().createQuery("select o from ComprobanteCabecera o "
                + "where o.idImpuesto = :impuesto "
                + "and o.idContribuyente = :contribuyente "
                + "and o.anulado = :anulado");
        //query.setParameter("impuesto", impuesto);
        query.setParameter("contribuyente", contribuyente);
        query.setParameter("anulado", false);
        return query.getResultList();
    }
}
