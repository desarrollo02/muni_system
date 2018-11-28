package bean;

import buil.UsuarioDTOListBuilder;
import controller.UsuarioController;
import dto.UsuarioDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;
import util.FormEnableUsuario;

@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean extends BaseBean implements Serializable {
    
    private String descripcionFiltro;
    private String cedulaFiltro;
    private String nombresFiltro;
    private String apellidosFiltro;
    private List<UsuarioDTO> usuarioListDTO = new UsuarioDTOListBuilder().build();
    private UsuarioDTO usuarioDTO;
    private UsuarioController usuarioController = new UsuarioController();
    private FormEnableUsuario formEnable = new FormEnableUsuario();
    private List<String> nombresRoles;
    private UsuarioDTO usuarioDTOSelect;
    
    public String irVista(){
        getFormEnable().inicio();
        usuarioDTO = usuarioController.getNewUsuarioEmpty();
        return "usuario";
    }
    
    public void nuevo(ActionEvent evento){
        formEnable.nuevo();
        usuarioDTO = usuarioController.getNewUsuarioEmpty();
        nombresRoles = usuarioController.getNombresRoles();
    }
    
    public void filtrar(ActionEvent e){
        usuarioListDTO = usuarioController.getUsuarios(descripcionFiltro, cedulaFiltro, nombresFiltro, apellidosFiltro);
    }
    
    public void todos(ActionEvent e){
        descripcionFiltro = null;
        cedulaFiltro = null;
        nombresFiltro = null;
        apellidosFiltro = null;
        usuarioListDTO = usuarioController.getUsuarioAll();
    }
    
    public void aceptarSeleccion(ActionEvent e){ 
        usuarioDTO = usuarioDTOSelect; 
        if(usuarioDTO != null){
            formEnable.ver();
        }else{
            formEnable.inicio();
        }     
    }

    public void editar(ActionEvent evento){
        formEnable.editar();
    }
    
    public void cancelar(ActionEvent evento){
        usuarioDTO = usuarioController.getNewUsuarioEmpty();
        getFormEnable().inicio();
    }
    
    public void eliminar(ActionEvent evento){
        try{
            if(usuarioDTO != null){
                usuarioController.eliminar(usuarioDTO);
                usuarioDTO = usuarioController.getNewUsuarioEmpty();
                getFormEnable().inicio();
                super.setMensaje("Datos Eliminados");
            }
        }catch(Exception ex){
            super.setMensajeError("Error al intentar eliminar los datos");
        }
    }
    
    public void guardar(ActionEvent evento){
        try{
            if(usuarioDTO.getId() == null){
                usuarioController.guardar(usuarioDTO);
                usuarioDTO = usuarioController.getNewUsuarioEmpty();
                getFormEnable().inicio();
                super.setMensaje("Datos guardados");
            }else{
                usuarioController.actualizar(usuarioDTO);
                usuarioDTO = usuarioController.getNewUsuarioEmpty();
                getFormEnable().inicio();
                super.setMensaje("Datos guardados");
            }
        }catch(Exception ex){
            super.setMensajeError("Error al intentar guardar los datos");
        }    
    }

    public String getDescripcionFiltro() {
        return descripcionFiltro;
    }

    public void setDescripcionFiltro(String descripcionFiltro) {
        this.descripcionFiltro = descripcionFiltro;
    }

    public String getCedulaFiltro() {
        return cedulaFiltro;
    }

    public void setCedulaFiltro(String cedulaFiltro) {
        this.cedulaFiltro = cedulaFiltro;
    }

    public String getNombresFiltro() {
        return nombresFiltro;
    }

    public void setNombresFiltro(String nombresFiltro) {
        this.nombresFiltro = nombresFiltro;
    }

    public String getApellidosFiltro() {
        return apellidosFiltro;
    }

    public void setApellidosFiltro(String apellidosFiltro) {
        this.apellidosFiltro = apellidosFiltro;
    }

    public List<UsuarioDTO> getUsuarioListDTO() {
        return usuarioListDTO;
    }

    public void setUsuarioListDTO(List<UsuarioDTO> usuarioListDTO) {
        this.usuarioListDTO = usuarioListDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public FormEnableUsuario getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableUsuario formEnable) {
        this.formEnable = formEnable;
    }

    public List<String> getNombresRoles() {
        return nombresRoles;
    }

    public void setNombresRoles(List<String> nombresRoles) {
        this.nombresRoles = nombresRoles;
    }

    public UsuarioDTO getUsuarioDTOSelect() {
        return usuarioDTOSelect;
    }

    public void setUsuarioDTOSelect(UsuarioDTO usuarioDTOSelect) {
        this.usuarioDTOSelect = usuarioDTOSelect;
    }
}
