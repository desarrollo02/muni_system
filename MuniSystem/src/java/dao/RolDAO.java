package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Rol;

public class RolDAO {
    
    private EntityManager em;
    
    public void guardar(Rol rol){
        em.persist(rol);
    }
    
    public void actualizar(Rol rol){
        em.merge(rol);
    }
    
    public void eliminar(Rol rol){
        em.remove(rol);
    }
    
    public Rol getRol(Integer id){
        return em.find(Rol.class, id);
    }

    public RolDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<Rol> getRol(String descripton){
        Query query = em.createQuery("select o from Rol o where upper(o.descripcion) like :descripcion");
        query.setParameter("descripcion", "%" + descripton.toUpperCase() + "%");
        return query.getResultList();
    }
    
    public List<Rol> getRolAll(){
        Query query = em.createQuery("select o from Rol o");
        return query.getResultList();
    }
    
    public Rol getRolByDesc(String desc){
        Query query = em.createQuery("select o from Rol o where o.descripcion = :desc");
        query.setParameter("desc", desc);
        return (Rol) query.getSingleResult();
    }
}
