package manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.ComprobanteCabecera;
import jpa.Parametros;
import util.fabrica.Util;

public class BaseManager {
    
    private EntityManager em = Util.getEm();

     
    public void guardar(Object entidad){
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
     } 
    
    public void eliminar(Object entidad){
        em.getTransaction().begin();
        em.remove(entidad);
        em.getTransaction().commit();
     }
     
     public void actualizar(Object entidad){
        em.getTransaction().begin();
        em.merge(entidad);
        em.getTransaction().commit();
     }
     
     public EntityManager getEm() {
        return em;
    }
     
    public Parametros getParemtro(String nombre){
        Query query = em.createQuery("select o from Parametros o where o.nombre = :nombre");
        query.setParameter("nombre", nombre);
        return (Parametros) query.getSingleResult();
    }
    
    public Integer getAnioActual(){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getAnioDate(Date date){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(date);
        
        return fecha.get(Calendar.YEAR);
    }
}
