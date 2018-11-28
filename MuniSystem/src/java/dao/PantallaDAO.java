package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Pantalla;
import jpa.Rol;
import jpa.RolPantalla;

public class PantallaDAO {
    
    private EntityManager em;

    public PantallaDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<Pantalla> getPantallaAll(){
        Query query = em.createQuery("select o from Pantalla o");
        return query.getResultList();
    }
    
    public Pantalla getPantalla(String nombre){
        Query query = em.createQuery("select o from Pantalla o where o.descripcion = :nombre");
        query.setParameter("nombre", nombre);
        return (Pantalla) query.getSingleResult();
    }
}
