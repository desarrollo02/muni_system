package bean;

import controller.GenerarFactInvController;
import dto.FacturaDTO;
import dto.TributoFacturableDTO;
import enumerados.TributoConRegistro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;

@Named(value = "generarFactIndividualBean")
@SessionScoped
public class GenerarFactIndividualBean implements Serializable {
    
    private String nombreTributoSelect;
    private List<FacturaDTO> facturas;
    private FacturaDTO facturaSelect;
    private Integer idCondribuyente;
    private String cedula;
    private String ruc;
    private String nombres;
    private String apellidos;
    private List<TributoFacturableDTO> tributosFacturables;
    private GenerarFactInvController controller = new GenerarFactInvController();

    public GenerarFactIndividualBean() {
    }
    
    public void buscar(ActionEvent evento){
        switch (nombreTributoSelect) {
            case "INMOBILIARIO":
                tributosFacturables = controller.getTributosFacturables(TributoConRegistro.INMOBILIARIO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "PATENTE":
                tributosFacturables = controller.getTributosFacturables(TributoConRegistro.PATENTE, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "CEMENTERIO":
                tributosFacturables = controller.getTributosFacturables(TributoConRegistro.CEMENTERIO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "VEHICULO":
                tributosFacturables = controller.getTributosFacturables(TributoConRegistro.VEHICULO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            case "REGISTRO":
                tributosFacturables = controller.getTributosFacturables(TributoConRegistro.REGISTRO, idCondribuyente, cedula, ruc, nombres, apellidos);
                break;
            default:
                break;
        }
    }
    
    public String irVista(){
        nombreTributoSelect=null;
        return "generarIndividual";
    }

    public String getNombreTributoSelect() {
        return nombreTributoSelect;
    }

    public void setNombreTributoSelect(String nombreTributoSelect) {
        this.nombreTributoSelect = nombreTributoSelect;
    }

    public List<FacturaDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaDTO> facturas) {
        this.facturas = facturas;
    }

    public FacturaDTO getFacturaSelect() {
        return facturaSelect;
    }

    public void setFacturaSelect(FacturaDTO facturaSelect) {
        this.facturaSelect = facturaSelect;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public List<TributoFacturableDTO> getTributosFacturables() {
        return tributosFacturables;
    }

    public void setTributosFacturables(List<TributoFacturableDTO> tributosFacturables) {
        this.tributosFacturables = tributosFacturables;
    }
}
