package bean;

import buil.RolDTOListBuilder;
import controller.RolController;
import dto.RolDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;
import util.FormEnableRol;

@Named(value = "rolManagedBean")
@SessionScoped
public class RolBean extends BaseBean implements Serializable {
    
    private String descripcionFiltro;
    private List<RolDTO> rolListDTO = new RolDTOListBuilder().build();
    private RolDTO rolDTO;
    private RolController rolController = new RolController();
    private FormEnableRol formEnable = new FormEnableRol();
    
    public String irVista(){
        getFormEnable().inicio();
        rolDTO = rolController.getNewRolEmpty();
        return "rol";
    }
    
    public void nuevo(ActionEvent evento){
        formEnable.nuevo();
        rolDTO = rolController.getNewRolPantallasAll();
    }
    
    public void filtrar(ActionEvent e){
        if(descripcionFiltro != null || !descripcionFiltro.equals("")){
            rolListDTO = rolController.getRoles(descripcionFiltro);
        }
    }
    
    public void todos(ActionEvent e){
        descripcionFiltro = null;
        rolListDTO = rolController.getRolAll();
        
    }
    
    public void aceptarSeleccion(ActionEvent e){   
        if(rolDTO != null){
            rolDTO.setPantallas(rolController.getRolPantallas(rolDTO));
            formEnable.ver();
        }else{
            formEnable.inicio();
        }     
    }
    
    public void editar(ActionEvent evento){
        formEnable.editar();
    }
    
    public void cancelar(ActionEvent evento){
        rolDTO = rolController.getNewRolEmpty();
        getFormEnable().inicio();
    }
    
    public void eliminar(ActionEvent evento){
        try{
            if(rolDTO != null){
                rolController.eliminar(rolDTO);
                rolDTO = rolController.getNewRolEmpty();
                getFormEnable().inicio();
                super.setMensaje("Datos Eliminados");
            }
        }catch(Exception ex){
            super.setMensajeError("Error al intentar eliminar los datos");
        }
    }
    
    public void guardar(ActionEvent evento){
        try{
            if(rolDTO.getIdRol() == null){
                rolController.guardar(rolDTO);
                rolDTO = rolController.getNewRolEmpty();
                getFormEnable().inicio();
                super.setMensaje("Datos guardados");
            }else{
                rolController.actualizar(rolDTO);
                rolDTO = rolController.getNewRolEmpty();
                getFormEnable().inicio();
                super.setMensaje("Datos guardados");
            }
        }catch(Exception ex){
            super.setMensajeError("Error al intentar guardar los datos");
        }    
    }

    public RolBean() {
    }

    public String getDescripcionFiltro() {
        return descripcionFiltro;
    }

    public void setDescripcionFiltro(String descripcionFiltro) {
        this.descripcionFiltro = descripcionFiltro;
    }

    public List<RolDTO> getRolListDTO() {
        return rolListDTO;
    }

    public void setRolListDTO(List<RolDTO> rolListDTO) {
        this.rolListDTO = rolListDTO;
    }

    public RolDTO getRolDTO() {
        return rolDTO;
    }

    public void setRolDTO(RolDTO rolDTO) {
        this.rolDTO = rolDTO;
    }

    public FormEnableRol getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableRol formEnable) {
        this.formEnable = formEnable;
    }
    
}
