package manager;

import jpa.Inmueble;
import jpa.Contribuyente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import manager.BaseManager;


public class InmuebleManager extends BaseManager{
    
    public List<Contribuyente> findAllContribuyente(){        
        Query query = super.getEm().createNamedQuery("Contribuyente.findAll");
        return query.getResultList();
    }
    
    public List<String> getDescripcionTipoPavimentoList(){
        return super.getEm().createQuery("select o.descripcion from TipoPavimento o").getResultList();
    }
    
    public List<Contribuyente> findContribuyente(String cedula){
        
        Query query = super.getEm().createNamedQuery("Contribuyente.findByCedula");
        query.setParameter("cedula", cedula);
       
        return query.getResultList();
    }
    
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
    
    public boolean existeNroPadron(Inmueble inmueble){
        Query query = getEm().createQuery("select o from Inmueble o where o.padron = :padron");
        query.setParameter("padron", inmueble.getPadron());
        List<Inmueble> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdInmueble().equals(inmueble.getIdInmueble())){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean existeNroFinca(Inmueble inmueble){
        Query query = getEm().createQuery("select o from Inmueble o where o.nroFinca = :nroFinca");
        query.setParameter("nroFinca", inmueble.getNroFinca());
        List<Inmueble> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdInmueble().equals(inmueble.getIdInmueble())){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean existeCtaCte(Inmueble inmueble){
        Query query = getEm().createQuery("select o from Inmueble o where o.ctaCte = :ctaCte");
        query.setParameter("ctaCte", inmueble.getCtaCte());
        List<Inmueble> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdInmueble().equals(inmueble.getIdInmueble())){
            return false;
        }else{
            return true;
        }
    }
    
}
