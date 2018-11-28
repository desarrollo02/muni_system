package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Tributo;
import jpa.TributoDetalle;

public class TributoAnexoDAO {
    
    private EntityManager em;

    public TributoAnexoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(TributoDetalle tributoAnexo){
        em.persist(tributoAnexo);
    }
    
    public List<Tributo> getAnexos(Tributo tributo){
        Query query = em.createQuery("select o.idTributoAgregado from TributoDetalle o where o.idTributoBase = :tributo");
        query.setParameter("tributo", tributo);
        return query.getResultList();
    }
    
    public void eliminarAnexos(Tributo tributo){
        Query query = em.createQuery("delete from TributoDetalle o where o.idTributoBase = :tributo");
        query.setParameter("tributo", tributo);
        query.executeUpdate();
    }
}
