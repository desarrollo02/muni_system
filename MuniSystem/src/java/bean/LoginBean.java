package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Usuario;
import manager.UsuarioManager;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends MensajeBean implements Serializable {
    
    private String nombreUsuario;
    private String claveUsuario;
    private Usuario usuarioLogeado;
    private UsuarioManager manager = new UsuarioManager();
    
    public String login(){
        usuarioLogeado = manager.getUsuario(nombreUsuario, claveUsuario);
        if(usuarioLogeado != null){
            return "inicio";
        }else{
            super.mensajeError("Acceso Denegado");
            return null;
        }    
    }
            
    public LoginBean() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }    
}
