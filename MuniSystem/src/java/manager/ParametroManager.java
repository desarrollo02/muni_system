package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Parametros;

/**
 *
 * @author diaz
 */
public class ParametroManager extends BaseManager {
    
    public List<Parametros> filtrar(String nombre, String valor){
        
        String sql = "Select o from Parametros o where 1=1";
        
        if(nombre != null && !nombre.equals("")){
            sql = sql + " and upper(o.nombre) like :nombre"; 
        }
        
        if(valor != null && !valor.equals("")){
            sql = sql + " and upper(o.valor) like :valor"; 
        }
        
        Query query = super.getEm().createQuery(sql);
        
        
        if(nombre != null && !nombre.equals("")){
            query.setParameter("nombre", "%"+nombre.toUpperCase()+"%"); 
        }
        
        if(valor != null && !valor.equals("")){
            query.setParameter("valor", "%"+valor.toUpperCase()+"%"); 
        }

        return query.getResultList();
    }   
}
