package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Contribuyente;

public class ContribuyenteDAO {
    
    private EntityManager em;

    public ContribuyenteDAO(EntityManager em) {
        this.em = em;
    }
    
    public Contribuyente getContribuyente(Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        String sql = "select o from Contribuyente o where 1 = 1";
        if(idCondribuyente != null && idCondribuyente > 0){
            sql = sql + " and o.idContribuyente = :idContribuyente";
        }
        if(cedula != null && !cedula.equals("")){
            sql =  sql + " and o.cedula = :cedula";
        }
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.ruc = :ruc";
        }
        if(nombres != null && !nombres.equals("")){
            sql = sql + " and o.nombres = :nombres";
        }
        if(apellidos != null && !apellidos.equals("")){
            sql =  sql + " and o.apellidos = :apellidos";
        }
        Query query = em.createQuery(sql);
        if(idCondribuyente != null && idCondribuyente > 0){
            query.setParameter("idContribuyente", idCondribuyente);
        }
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
        if(nombres != null && !nombres.equals("")){
            query.setParameter("nombres", nombres);
        }
        if(apellidos != null && !apellidos.equals("")){
            query.setParameter("apellidos", apellidos);
        }
        if(query.getResultList().isEmpty()){
            return null;
        }else{
            return (Contribuyente) query.getResultList().get(0);
        }
    }
    
    public List<Contribuyente> getContribuyentesInmobiliario(Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        String sql = "select o from Inmueble o where 1 = 1";
        if(idCondribuyente != null && idCondribuyente > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :idContribuyente";
        }
        if(cedula != null && !cedula.equals("")){
            sql =  sql + " and o.idContribuyente.cedula = :cedula";
        }
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.idContribuyente.ruc = :ruc";
        }
        if(nombres != null && !nombres.equals("")){
            sql = sql + " and o.idContribuyente.nombres = :nombres";
        }
        if(apellidos != null && !apellidos.equals("")){
            sql =  sql + " and o.idContribuyente.apellidos = :apellidos";
        }
    
        Query query = em.createQuery(sql);
    
        if(idCondribuyente != null && idCondribuyente > 0){
            query.setParameter("idContribuyente", idCondribuyente);
        }
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
        if(nombres != null && !nombres.equals("")){
            query.setParameter("nombres", nombres);
        }
        if(apellidos != null && !apellidos.equals("")){
            query.setParameter("apellidos", apellidos);
        }
        return query.getResultList();
    }
    
    public List<Contribuyente> getContribuyentesPantente(Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        String sql = "select o from Comercio o where 1 = 1";
        if(idCondribuyente != null && idCondribuyente > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :idContribuyente";
        }
        if(cedula != null && !cedula.equals("")){
            sql =  sql + " and o.idContribuyente.cedula = :cedula";
        }
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.idContribuyente.ruc = :ruc";
        }
        if(nombres != null && !nombres.equals("")){
            sql = sql + " and o.idContribuyente.nombres = :nombres";
        }
        if(apellidos != null && !apellidos.equals("")){
            sql =  sql + " and o.idContribuyente.apellidos = :apellidos";
        }
        
        Query query = em.createQuery(sql);
        if(idCondribuyente != null && idCondribuyente > 0){
            query.setParameter("idContribuyente", idCondribuyente);
        }
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
        if(nombres != null && !nombres.equals("")){
            query.setParameter("nombres", nombres);
        }
        if(apellidos != null && !apellidos.equals("")){
            query.setParameter("apellidos", apellidos);
        }
        return query.getResultList();
    }
    
    public List<Contribuyente> getContribuyentesCementerio(Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        String sql = "select o from Cementerio o where 1 = 1";
        if(idCondribuyente != null && idCondribuyente > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :idContribuyente";
        }
        if(cedula != null && !cedula.equals("")){
            sql =  sql + " and o.idContribuyente.cedula = :cedula";
        }
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.idContribuyente.ruc = :ruc";
        }
        if(nombres != null && !nombres.equals("")){
            sql = sql + " and o.idContribuyente.nombres = :nombres";
        }
        if(apellidos != null && !apellidos.equals("")){
            sql =  sql + " and o.idContribuyente.apellidos = :apellidos";
        }
    
        Query query = em.createQuery(sql);
    
        if(idCondribuyente != null && idCondribuyente > 0){
            query.setParameter("idContribuyente", idCondribuyente);
        }
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
        if(nombres != null && !nombres.equals("")){
            query.setParameter("nombres", nombres);
        }
        if(apellidos != null && !apellidos.equals("")){
            query.setParameter("apellidos", apellidos);
        }
        return query.getResultList();
    }
    
    public List<Contribuyente> getContribuyentesHabilitacion(Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        String sql = "select o from Vehiculo o where 1 = 1";
        if(idCondribuyente != null && idCondribuyente > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :idContribuyente";
        }
        if(cedula != null && !cedula.equals("")){
            sql =  sql + " and o.idContribuyente.cedula = :cedula";
        }
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.idContribuyente.ruc = :ruc";
        }
        if(nombres != null && !nombres.equals("")){
            sql = sql + " and o.idContribuyente.nombres = :nombres";
        }
        if(apellidos != null && !apellidos.equals("")){
            sql =  sql + " and o.idContribuyente.apellidos = :apellidos";
        }
        
        Query query = em.createQuery(sql);
        if(idCondribuyente != null && idCondribuyente > 0){
            query.setParameter("idContribuyente", idCondribuyente);
        }
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
        if(nombres != null && !nombres.equals("")){
            query.setParameter("nombres", nombres);
        }
        if(apellidos != null && !apellidos.equals("")){
            query.setParameter("apellidos", apellidos);
        }
        return query.getResultList();
    }
    
    public List<Contribuyente> getContribuyentesRegistro(Integer idCondribuyente, 
                                        String cedula, 
                                        String ruc, 
                                        String nombres,
                                        String apellidos){
        String sql = "select o from RegistroConducir o where 1 = 1";
        if(idCondribuyente != null && idCondribuyente > 0){
            sql = sql + " and o.idContribuyente.idContribuyente = :idContribuyente";
        }
        if(cedula != null && !cedula.equals("")){
            sql =  sql + " and o.idContribuyente.cedula = :cedula";
        }
        if(ruc != null && !ruc.equals("")){
            sql = sql + " and o.idContribuyente.ruc = :ruc";
        }
        if(nombres != null && !nombres.equals("")){
            sql = sql + " and o.idContribuyente.nombres = :nombres";
        }
        if(apellidos != null && !apellidos.equals("")){
            sql =  sql + " and o.idContribuyente.apellidos = :apellidos";
        }
        
        Query query = em.createQuery(sql);
        
        if(idCondribuyente != null && idCondribuyente > 0){
            query.setParameter("idContribuyente", idCondribuyente);
        }
        if(cedula != null && !cedula.equals("")){
            query.setParameter("cedula", cedula);
        }
        if(ruc != null && !ruc.equals("")){
            query.setParameter("ruc", ruc);
        }
        if(nombres != null && !nombres.equals("")){
            query.setParameter("nombres", nombres);
        }
        if(apellidos != null && !apellidos.equals("")){
            query.setParameter("apellidos", apellidos);
        }
        return query.getResultList();
    }
}
