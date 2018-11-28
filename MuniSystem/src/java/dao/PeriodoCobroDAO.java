package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.PeriodoCobro;

public class PeriodoCobroDAO {
    
    private EntityManager em;

    public PeriodoCobroDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<PeriodoCobro> getPeriodoCobroAll(){
        Query query = em.createQuery("select o from PeriodoCobro o");
        return query.getResultList();
    }
    
    public PeriodoCobro getPeriodoCobro(String nombre){
        Query query = em.createQuery("select o from PeriodoCobro o where o.descripcion = :nombre");
        query.setParameter("nombre", nombre);
        return (PeriodoCobro) query.getSingleResult();
    }
}
