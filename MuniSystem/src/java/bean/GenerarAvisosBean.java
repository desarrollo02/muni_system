package bean;

import controller.GenerarAvisosController;
import dto.ContribuyenteDTO;
import enumerados.TributoConRegistro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author desarrollo2
 */
@Named(value = "generarAvisosBean")
@SessionScoped
public class GenerarAvisosBean implements Serializable {
    
    private String nombreTributo;
    private Integer idCondribuyente;
    private String cedula;
    private String ruc;
    private String nombres;
    private String apellidos;
    private Integer anio;
    private List<ContribuyenteDTO> contribuyentes;
    private GenerarAvisosController controller = new GenerarAvisosController();

    public GenerarAvisosBean() {
    }
    
    private void limpiarVariables(){
        nombreTributo=null;
        idCondribuyente=null;
        cedula=null;
        ruc=null;
        nombres=null;
        apellidos=null;
        contribuyentes=null;
    }
    
    public String irVista(){
        limpiarVariables();
        return "generarAvisos";
    }
    
    public void buscar(ActionEvent evento){
        //agregar al DAO para que filtre solo los que tienen facturas pendientes de pago
        switch (nombreTributo) {
            case "INMOBILIARIO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.INMOBILIARIO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "PATENTE":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.PATENTE, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "CEMENTERIO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.CEMENTERIO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "VEHICULO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.VEHICULO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "REGISTRO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.REGISTRO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            default:
                break;
        }
    }

    public String getNombreTributo() {
        return nombreTributo;
    }

    public void setNombreTributo(String nombreTributo) {
        this.nombreTributo = nombreTributo;
    }

    public Integer getIdCondribuyente() {
        return idCondribuyente;
    }

    public void setIdCondribuyente(Integer idCondribuyente) {
        this.idCondribuyente = idCondribuyente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<ContribuyenteDTO> getContribuyentes() {
        return contribuyentes;
    }

    public void setContribuyentes(List<ContribuyenteDTO> contribuyentes) {
        this.contribuyentes = contribuyentes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
