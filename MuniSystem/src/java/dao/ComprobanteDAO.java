package dao;

import javax.persistence.EntityManager;
import jpa.ComprobanteCabecera;

public class ComprobanteDAO {
    
    private EntityManager em;

    public ComprobanteDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(ComprobanteCabecera cabecera){
        em.persist(cabecera);
    }
}
