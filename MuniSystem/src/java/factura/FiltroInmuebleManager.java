/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.util.List;
import javax.persistence.Query;
import jpa.Inmueble;
import manager.BaseManager;

/**
 *
 * @author USUARIO
 */
public class FiltroInmuebleManager extends BaseManager{
    
    public List<Inmueble> filtrar(Integer rmc, String cedula, String ruc, Integer padron, String ctaCte, Integer nroFinca){
        
        String sql = "Select o from Inmueble o where 1=1";
        
        if(rmc != null && rmc > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :rmc"; 
        }
        
        if(cedula != null && !cedula.equals("")){
            sql = sql + " and o.idContribuyente.cedula = :cedula"; 
        }
        
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.idContribuyente.ruc = :ruc"; 
        }
        
        if(padron != null && padron > 0){
            sql = sql + " and o.padron = :padron"; 
        }
        
        if(ctaCte != null && !ctaCte.equals("")){
            sql = sql + " and o.ctaCte = :ctaCte"; 
        }
        
        if(nroFinca != null && nroFinca > 0){
            sql = sql + " and o.lote = :lote";
        }
        
        
        Query query = super.getEm().createQuery(sql);
        
        
        if(rmc != null && rmc > 0){
            query.setParameter("rmc", rmc);
        }
        
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
                
        if(padron != null && padron > 0){
            query.setParameter("padron", padron); 
        }
        
        if(ctaCte != null && !ctaCte.equals("")){
            query.setParameter("ctaCte", ctaCte); 
        }
        
        if(nroFinca != null && nroFinca > 0){
            query.setParameter("lote", nroFinca); 
        }
        return query.getResultList();
    }   
}
