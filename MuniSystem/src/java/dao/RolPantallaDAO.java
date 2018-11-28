package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Rol;
import jpa.RolPantalla;

public class RolPantallaDAO {
    
    private EntityManager em;

    public RolPantallaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(RolPantalla rolPantalla){
        em.persist(rolPantalla);
    }
    
    public void eliminar(Rol rol){
        Query query = em.createQuery("Delete from RolPantalla o where o.idRol = :rol");
        query.setParameter("rol", rol);
        query.executeUpdate();
    }
    
    public List<RolPantalla> getRolPantalla(Rol rol){
        Query query = em.createQuery("select o from RolPantalla o where o.idRol = :rol");
        query.setParameter("rol", rol);
        return query.getResultList();
    }
}
