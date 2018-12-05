package dao;

import enumerados.TributoConRegistro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Tributo;

public class TributoDAO {
    
    private EntityManager em;

    public TributoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(Tributo tributo){
        em.persist(tributo);
    }
    
    public void actualizar(Tributo tributo){
        em.merge(tributo);
    }
    
    public void eliminar(Tributo tributo){
        em.remove(tributo);
    }
    
    public Tributo getTributo(Integer id){
        return em.find(Tributo.class, id);
    }
    
    public List<Tributo> getTributoAnexoAll(){
        Query query = em.createQuery("select o from Tributo o where o.registrar = :registrar");
        query.setParameter("registrar", TributoConRegistro.NINGUNO.toString());
        return query.getResultList();
    }
    
    public List<Tributo> getTributoConRegistroAll(){
        Query query = em.createQuery("select o from Tributo o where o.registrar != :registrar");
        query.setParameter("registrar", TributoConRegistro.NINGUNO.toString());
        return query.getResultList();
    }
    
    public List<Tributo> getTributoAll(){
        Query query = em.createQuery("select o from Tributo o");
        return query.getResultList();
    } 
    
    public List<Tributo> getTributos(String nombre, String tipo){
        
        String sql = "select o from Tributo o where 1 = 1";
        
        if(nombre != null && !nombre.equals("")){
            sql = sql + " and upper(o.nombre) like :nombre";
        }
        
        if(tipo != null && !tipo.equals("")){
            sql = sql + " and upper(o.tipo) like :tipo";
        }
        
        Query query = em.createQuery(sql);
        
        if(nombre != null && !nombre.equals("")){
            query.setParameter("nombre", "%" + nombre.toUpperCase() + "%");
        }
        
        if(tipo != null && !tipo.equals("")){
            query.setParameter("tipo", "%" + tipo.toUpperCase() + "%");
        }
        
        return query.getResultList();
    }
    
    public Tributo getTributo(String nombre){
        Query query = em.createQuery("select o from Tributo o where o.nombre = :nombre");
        query.setParameter("nombre", nombre);
        return (Tributo) query.getSingleResult();
    }
    
    public Tributo getTributoPorLugarDeRegistro(TributoConRegistro tributoConRegistro){
        Query query = em.createQuery("select o from Tributo o where o.registrar = :registro");
        if(null != tributoConRegistro)switch (tributoConRegistro) {
            case INMOBILIARIO:
                query.setParameter("registro", "INMUEBLE");
                break;
            case PATENTE:
                query.setParameter("registro", "PATENTE");
                break;
            case CEMENTERIO:
                query.setParameter("registro", "CEMENTERIO");
                break;
            default:
                break;
        }
        return (Tributo) query.getSingleResult();
    }
}
