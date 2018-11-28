package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.UnidadMedida;

public class UnidadMedidaDAO {

    private EntityManager em;

    public UnidadMedidaDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<UnidadMedida> getUnidadMedidaAll(){
        Query query = em.createQuery("select o from UnidadMedida o");
        return query.getResultList();
    }
    
    public UnidadMedida getUnidadMedida(String nombre){
        Query query = em.createQuery("select o from UnidadMedida o where o.nombre = :nombre");
        query.setParameter("nombre", nombre);
        return (UnidadMedida) query.getSingleResult();
    }
}
