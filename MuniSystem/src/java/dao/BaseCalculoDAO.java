package dao;

import factura.BaseCalculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BaseCalculoDAO {
    
    private EntityManager em;
    
    public BaseCalculoDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<BaseCalculo> getBaseCalculoInmueble(){
        Query query = em.createQuery("select o from Inmueble o");
        return query.getResultList();
    }
}
