package dao;

import enumerados.TributoConRegistro;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;
import jpa.Tributo;

public class ComprobanteDAO {
    
    private EntityManager em;

    public ComprobanteDAO(EntityManager em) {
        this.em = em;
    }
    
    public void actualizar(ComprobanteCabecera cabecera){
        em.merge(cabecera);
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
    
    public void pagar(Integer idComprobanteCab, String formaPago, String nroCheque, String usuario){
        ComprobanteCabecera compCab = em.find(ComprobanteCabecera.class, idComprobanteCab);
        compCab.setPagado(Boolean.TRUE);
        compCab.setTipoPago(formaPago);
        compCab.setFechaPago(new Date());
        compCab.setNroCheque(nroCheque);
        compCab.setUsuarioPago(usuario);
        em.merge(compCab);
    }
    
    public ComprobanteCabecera getCompCabecera(Integer id){
        return em.find(ComprobanteCabecera.class, id);
    }
    
    public Double getTotal(Date fechaInicio, Date fechaFin, String tipoPago, String usuario){
        Query query = em.createQuery("select sum(o.totalPagar) from ComprobanteCabecera o "
                + "where o.anulado = :anulado "
                + "and o.pagado = :pagado "
                + "and o.tipoPago = :tipoPago "
                + "and o.fechaPago >= :fechaIncio "
                + "and o.fechaPago <= :fechaFin "
                + "and o.usuarioPago = :usuario");
        query.setParameter("anulado", false);
        query.setParameter("pagado", true);
        query.setParameter("tipoPago", tipoPago);
        query.setParameter("fechaIncio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        query.setParameter("usuario", usuario);
        List result = query.getResultList();
        if(result.isEmpty()){
            return 0.0;
        }else if(result.get(0) == null){
            return 0.0;
        }else{
            return (Double) result.get(0);
        }
    }
    
    public Double getMontoEstimado(Tributo tributo, Integer anio){
        Query query = em.createQuery("select sum(o.totalPagar) from ComprobanteCabecera o "
                + "where o.anulado = :anulado "
                + "and o.idTributo = :tributo " 
                + "and o.anio = :anio");
        query.setParameter("anulado", false);
        query.setParameter("tributo", tributo);
        query.setParameter("anio", anio);
        
        List result = query.getResultList();
        if(result.isEmpty()){
            return 0.0;
        }else if(result.get(0) == null){
            return 0.0;
        }else{
            return (Double) result.get(0);
        }
    }
    
    public Double getMontoIngreso(Tributo tributo, Integer anio){
        Query query = em.createQuery("select sum(o.totalPagar) from ComprobanteCabecera o "
                + "where o.anulado = :anulado "
                + "and o.idTributo = :tributo "
                + "and o.pagado = :pagado "
                + "and o.anio = :anio");
        query.setParameter("anulado", false);
        query.setParameter("tributo", tributo);
        query.setParameter("pagado", true);
        query.setParameter("anio", anio);
        
        List result = query.getResultList();
        if(result.isEmpty()){
            return 0.0;
        }else if(result.get(0) == null){
            return 0.0;
        }else{
            return (Double) result.get(0);
        }
    }
    
    public void elimianarComprobanteCab(Integer anio, Tributo tributo, Integer referencia){
        Query query = em.createQuery("select o from ComprobanteCabecera o where "
                + "o.anio = :anio and o.pagado = :pagado and o.idTributo = :tributo and o.id_ref = :referencia");
        query.setParameter("anio", anio);
        query.setParameter("pagado", false);
        query.setParameter("tributo", tributo);
        query.setParameter("referencia", referencia);
        List<ComprobanteCabecera> comprobantes = query.getResultList();
        for(ComprobanteCabecera cabecera : comprobantes){
            eliminarComprobanteDet(cabecera);
            em.remove(cabecera);
        }
    }
    
    public void elimianarComprobanteCab(Integer anio, Tributo tributo){
        Query query = em.createQuery("select o from ComprobanteCabecera o where "
                + "o.anio = :anio and o.pagado = :pagado and o.idTributo = :tributo");
        query.setParameter("anio", anio);
        query.setParameter("pagado", false);
        query.setParameter("tributo", tributo);
        List<ComprobanteCabecera> comprobantes = query.getResultList();
        for(ComprobanteCabecera cabecera : comprobantes){
            eliminarComprobanteDet(cabecera);
            em.remove(cabecera);
        }
    }
    
    public void eliminarComprobanteDet(ComprobanteCabecera cabecera){
        Query query = em.createQuery("delete from ComprobanteDetalle o where o.idComprobanteCab = :cabecera");
        query.setParameter("cabecera", cabecera);
        query.executeUpdate();
    
    }
    
    public boolean isPagado(Integer anio, Tributo tributo, Integer referencia){
        Query query = em.createQuery("select o from ComprobanteCabecera o where o.pagado = :pagado "
                + "and o.anio = :anio and o.idTributo = :tributo and o.id_ref = :referencia");
        query.setParameter("pagado", true);
        query.setParameter("anio", anio);
        query.setParameter("tributo", tributo);
        query.setParameter("referencia", referencia);
        return !query.getResultList().isEmpty();
    }
}
