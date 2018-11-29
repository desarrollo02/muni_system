package dao;

import javax.persistence.EntityManager;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;

public class ComprobanteDAO {
    
    private EntityManager em;

    public ComprobanteDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(ComprobanteCabecera cabecera){
        em.persist(cabecera);
    }
    
    public void guardar(ComprobanteDetalle detalle){
        em.persist(detalle);
    }
}
