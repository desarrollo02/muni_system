package converter;

import jpa.ComercioRubro;
import jpa.Barrio;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.Marcas;
import jpa.Modelos;
import jpa.PeriodoCobro;
import jpa.RegistroCategoria;
import jpa.UbicacionCementerio;
import jpa.UnidadMedida;
import jpa.VehiculoTipo;

public class ConverterManager {
    
    private EntityManager em = Persistence.createEntityManagerFactory("MuniSystemPU").createEntityManager();
    
    public ComercioRubro getComercioRubro(String descripcion){
        
        
        String sql = "Select o from ComercioRubro o where o.descripcion = :descripcion";
        
        Query query = em.createQuery(sql);
        
        if(descripcion != null && !descripcion.equals("")){
            query.setParameter("descripcion", descripcion); 
        }

        return (ComercioRubro) query.getSingleResult();
    
    }
    
    public Barrio getBarrio(String descripcion){
        
        
        String sql = "Select o from Barrio o where o.descripcion = :descripcion";
        
        Query query = em.createQuery(sql);
        
        if(descripcion != null && !descripcion.equals("")){
            query.setParameter("descripcion", descripcion); 
        }

        return (Barrio) query.getSingleResult();
    
    }
    
    public Marcas getMarca(String descripcion){
        
        
        String sql = "Select o from Marcas o where o.descripcion = :descripcion";
        
        Query query = em.createQuery(sql);
        
        if(descripcion != null && !descripcion.equals("")){
            query.setParameter("descripcion", descripcion); 
        }

        return (Marcas) query.getSingleResult();
    
    }
    
    public Modelos getModelo(String descripcion){
        
        
        String sql = "Select o from Modelos o where o.descripcion = :descripcion";
        
        Query query = em.createQuery(sql);
        
        if(descripcion != null && !descripcion.equals("")){
            query.setParameter("descripcion", descripcion); 
        }

        return (Modelos) query.getSingleResult();
    
    }
    
    public VehiculoTipo getVehiculoTipo(String descripcion){
        
        
        String sql = "Select o from VehiculoTipo o where o.descripcion = :descripcion";
        
        Query query = em.createQuery(sql);
        
        if(descripcion != null && !descripcion.equals("")){
            query.setParameter("descripcion", descripcion); 
        }

        return (VehiculoTipo) query.getSingleResult();
    
    }
    
    public RegistroCategoria getRegistroCategoria(String descripcion){
        
        
        String sql = "Select o from RegistroCategoria o where o.descripcion = :descripcion";
        
        Query query = em.createQuery(sql);
        
        if(descripcion != null && !descripcion.equals("")){
            query.setParameter("descripcion", descripcion); 
        }

        return (RegistroCategoria) query.getSingleResult();
    
    }
    
    public UbicacionCementerio getUbicacionCementerio(String nombre){
        
        
        String sql = "Select o from UbicacionCementerio o where o.nombre = :nombre";
        
        Query query = em.createQuery(sql);
        
        if(nombre != null && !nombre.equals("")){
            query.setParameter("nombre", nombre); 
        }

        return (UbicacionCementerio) query.getSingleResult();
    
    }
    
    public UnidadMedida getUnidadMedida(String nombre){
        
        Query query = em.createQuery("select o from UnidadMedida o where o.nombre = :nombre");
        
        query.setParameter("nombre", nombre); 

        return (UnidadMedida) query.getSingleResult();
    
    }
    
    public PeriodoCobro getPeriodoCobro(String descripcion){
        
        Query query = em.createQuery("select o from PeriodoCobro o where o.descripcion = :nombre");
        
        query.setParameter("nombre", descripcion); 

        return (PeriodoCobro) query.getSingleResult();
    
    }
    
}
