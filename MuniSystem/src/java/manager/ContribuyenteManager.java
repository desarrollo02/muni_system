package manager;

import jpa.Contribuyente;
import java.util.List;
import javax.persistence.Query;
import manager.BaseManager;

public class ContribuyenteManager extends BaseManager{
    
    public List<String> getDescripcionBarrioList(){
        return super.getEm().createQuery("select o.descripcion from Barrio o").getResultList();
    }
    
    public List<Contribuyente> filtrar(String cedula, String ruc, String nombre, String apellido, String empresa){
        
        String sql = "Select o from Contribuyente o where 1=1";
        
        if(cedula != null && !cedula.equals("")){
            sql = sql + " and upper(o.cedula) like :cedula"; 
        }
        
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and upper(o.ruc) like :ruc"; 
        }
        
        if(nombre != null && !nombre.equals("")){
            sql = sql + " and upper(o.nombres) like :nombre"; 
        }
        
        if(apellido != null && !apellido.equals("")){
            sql = sql + " and upper(o.apellidos) like :apellido"; 
        }
        
        if(empresa != null && !empresa.equals("")){
            sql = sql + " and upper(o.razonSocial) like :empresa"; 
        }
        
        Query query = super.getEm().createQuery(sql);
        
        
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", "%"+cedula.toUpperCase()+"%"); 
        }
        
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", "%"+ruc.toUpperCase()+"%");  
        }
        
        if(nombre != null && !nombre.equals("")){
            query.setParameter("nombre", "%"+nombre.toUpperCase()+"%"); 
        }
        
        if(apellido != null && !apellido.equals("")){
            query.setParameter("apellido", "%"+apellido.toUpperCase()+"%"); 
        }
        
        if(empresa != null && !empresa.equals("")){
            query.setParameter("empresa", "%"+empresa.toUpperCase()+"%"); 
        }

        return query.getResultList();
    }
    
    public boolean yaExisteRuc(String ruc){
        Query query = getEm().createQuery("select o from Contribuyente o where o.ruc = :ruc");
        query.setParameter("ruc", ruc);
        return !query.getResultList().isEmpty();
    }
    
    public boolean yaExisteRuc(String ruc, Integer idContribuyente){
        Query query = getEm().createQuery("select o from Contribuyente o where o.ruc = :ruc and o.idContribuyente != :idContribuyente");
        query.setParameter("ruc", ruc);
        query.setParameter("idContribuyente", idContribuyente);
        return !query.getResultList().isEmpty();
    }
    
    public boolean yaExisteCedula(String cedula){
        Query query = getEm().createQuery("select o from Contribuyente o where o.cedula = :cedula");
        query.setParameter("cedula", cedula);
        return !query.getResultList().isEmpty();
    }
    
    public boolean yaExisteCedula(String cedula, Integer idContribuyente){
        Query query = getEm().createQuery("select o from Contribuyente o where o.cedula = :cedula and o.idContribuyente != :idContribuyente");
        query.setParameter("cedula", cedula);
        query.setParameter("idContribuyente", idContribuyente);
        return !query.getResultList().isEmpty();
    }
}
