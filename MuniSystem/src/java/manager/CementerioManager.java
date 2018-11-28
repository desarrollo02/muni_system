package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Cementerio;

public class CementerioManager extends BaseManager{
    
    public boolean existeNroPatente(Cementerio cementerio){
        Query query = getEm().createQuery("select o from Cementerio o where o.nroLote = :nroLote");
        query.setParameter("nroLote", cementerio.getNroLote());
        List<Cementerio> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdCementerio().equals(cementerio.getIdCementerio())){
            return false;
        }else{
            return true;
        }
    }
    
    public List<Cementerio> filtrar(Integer rmc, String cedula, Integer nroLote){
        
        String sql = "Select o from Cementerio o where 1=1";
        
        if(rmc != null && rmc > 0){
            sql = sql + " and o.idContribueyten.idContribuyente = :rmc"; 
        }
        
        if(cedula != null && !cedula.equals("0")){
            sql = sql + " and o.idContribuyente.cedula = :cedula"; 
        }
        
        if(nroLote != null && nroLote > 0){
            sql = sql + " and o.nroLote = :nroLote";
        }
        
        Query query = super.getEm().createQuery(sql);
        
        if(rmc != null && rmc > 0){
            query.setParameter("rmc", rmc);
        }
        
        if(cedula != null && !cedula.equals("0")){
            query.setParameter("cedula", cedula);
        }
        
        if(nroLote != null && nroLote > 0){
            query.setParameter("nroLote", nroLote);
        }

        return query.getResultList();
    }
    
    public List<String> getNombreUbicacionCementerioList(){
        return super.getEm().createQuery("select o.nombre from UbicacionCementerio o").getResultList();
    }
}
