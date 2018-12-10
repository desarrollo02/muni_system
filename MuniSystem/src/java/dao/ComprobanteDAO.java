package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    public List<ComprobanteCabecera> getComprobantes(Integer nroFactura, Integer rmc, Integer anio, String nombreTributo){
        String sql = "select o from ComprobanteCabecera o where o.anulado = :anulado";
        if(nroFactura != null && nroFactura > 0){
            sql = sql + " and o.idComprobanteCabecera = :nroFactura";
        }
        if(rmc != null && rmc > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :rmc";
        }
        if(anio != null && anio > 0){
            sql = sql + " and o.anio = :anio";
        }
        if(nombreTributo != null && !nombreTributo.equals("")){
            sql = sql + " and upper(o.idTributo.nombre) like :nombre";
        }
        Query query = em.createQuery(sql);
        query.setParameter("anulado", false);
        if(nroFactura != null && nroFactura > 0){
            query.setParameter("nroFactura", nroFactura);
        }
        if(rmc != null && rmc > 0){
            query.setParameter("rmc", rmc);
        }
        if(anio != null && anio > 0){
            query.setParameter("anio", anio);
        }
        if(nombreTributo != null && !nombreTributo.equals("")){
            query.setParameter("nombre", "%"+nombreTributo.toUpperCase()+"%");
        }
        return query.getResultList();
    }
    
    public List<ComprobanteDetalle> getComprobanteDetalles(ComprobanteCabecera comprobanteCab){
        Query query = em.createQuery("select o from ComprobanteDetalle o where o.idComprobanteCab = :cab");
        query.setParameter("cab", comprobanteCab);
        return query.getResultList();
    }
    
    public void anular(Integer idComprobanteCab){
        ComprobanteCabecera compCab = em.find(ComprobanteCabecera.class, idComprobanteCab);
        compCab.setAnulado(Boolean.TRUE);
        em.merge(compCab);
    }
    
    public void pagar(Integer idComprobanteCab, String formaPago, String nroCheque){
        ComprobanteCabecera compCab = em.find(ComprobanteCabecera.class, idComprobanteCab);
        compCab.setPagado(Boolean.TRUE);
        compCab.setTipoPago(formaPago);
        compCab.setNroCheque(nroCheque);
        em.merge(compCab);
    }
}
