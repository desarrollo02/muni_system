package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Tributo;
import jpa.TributoMulta;

public class MultaDAO {
    
    private EntityManager em;

    public MultaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(TributoMulta multa){
        em.persist(multa);
    }
    
    public void actualizar(TributoMulta multa){
        em.merge(multa);
    }
    
    public void eliminar(TributoMulta multa){
        em.remove(multa);
    }
    
    public List<TributoMulta> getTributoMultas(Tributo tributo){
        Query query = em.createQuery("select o from TributoMulta o where o.idTributo = :tributo");
        query.setParameter("tributo", tributo);
        return query.getResultList();
    }
    
    public void eliminarMultas(Tributo tributo){
        Query query = em.createQuery("delete from TributoMulta o where o.idTributo = :tributo");
        query.setParameter("tributo", tributo);
        query.executeUpdate();
    }
}
