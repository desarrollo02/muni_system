package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Usuario;

public class UsuarioManager extends BaseManager{
    
    public Usuario getUsuario(String usuario, String clave){
        Query query = getEm().createQuery("select o from Usuario o where o.descripcion = :usuario and o.contrasena = :clave");
        query.setParameter("usuario", usuario);
        query.setParameter("clave", clave);
        List<Usuario> usuarios = query.getResultList();
        if(usuarios.isEmpty()){
            return null;
        }else{
            return usuarios.get(0);
        }
    }
    
}
