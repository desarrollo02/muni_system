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
    
    public List<BaseCalculo> getBaseCalculoPatenteComercial(){
        Query query = em.createQuery("select o from Comercio o");
        return query.getResultList();
    }
    
    public List<BaseCalculo> getBaseCalculoLoteCementerio(){
        Query query = em.createQuery("select o from Cementerio o");
        return query.getResultList();
    }
    
    public List<BaseCalculo> getBaseCalculoHabilitacionVehiculo(){
        Query query = em.createQuery("select o from Vehiculo o");
        return query.getResultList();
    }
    
    public List<BaseCalculo> getBaseCalculoRegistroConducir(){
        Query query = em.createQuery("select o from RegistroConducir o");
        return query.getResultList();
    }
}
