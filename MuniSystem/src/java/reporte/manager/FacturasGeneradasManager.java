package reporte.manager;

import java.util.List;
import javax.persistence.Query;
import jpa.ComprobanteCabecera;
import manager.BaseManager;

public class FacturasGeneradasManager extends BaseManager{
    
    public List<ComprobanteCabecera> getComprobante(Integer anio){
        String sql = "select o from ComprobanteCabecera o where o.anulado = :anulado";
        //if(impuesto != null){
            sql = sql + " and o.idImpuesto = :impuesto";
        //}
        
        if(anio != null && anio > 0){
            sql = sql + " and o.anio = :anio";
        }
        
        Query query = getEm().createQuery(sql);
        query.setParameter("anulado", false);
        
        /*if(impuesto != null){
            query.setParameter("impuesto", impuesto);
        }*/
        
        if(anio != null && anio > 0){
            query.setParameter("anio", anio);
        }
        
        return query.getResultList();
    }
}
