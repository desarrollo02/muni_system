package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.Usuario;

public class UsuarioDAO {
    
    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(Usuario usuario){
        em.persist(usuario);
    }
    
    public void actualizar(Usuario usuario){
        em.merge(usuario);
    }
    
    public void eliminar(Usuario usuario){
        em.remove(usuario);
    }
    
    public Usuario getUsuario(Integer id){
        return em.find(Usuario.class, id);
    }
    
    public List<Usuario> getUsuarioAll(){
        Query query = em.createQuery("select o from Usuario o");
        return query.getResultList();
    }
    
    public List<Usuario> getUsuario(String desc, String cedula, String nombres, String apellidos){
    
         String sql = "select o from Usuario o where 1 = 1";
         
         if(desc != null && !desc.equals("")){
             sql = sql + " and o.descripcion like :desc";
         }
         
         if(cedula != null && !cedula.equals("")){
             sql = sql + " and o.cedula = :cedula";
         }
         
         if(nombres != null && !nombres.equals("")){
             sql = sql + " and upper(o.nombres) like :nombres";
         }
         
         if(apellidos != null && !apellidos.equals("")){
             sql = sql + " and upper(o.apellidos) like :apellidos";
         }
         
         Query query = em.createQuery(sql);
         
         if(desc != null && !desc.equals("")){
             query.setParameter("desc", desc);
         }
         
         if(cedula != null && !cedula.equals("")){
             query.setParameter("cedula", cedula);
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
