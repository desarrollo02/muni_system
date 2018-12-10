package bean;

import controller.GenerarFactInvController;
import dto.FacturaDTO;
import dto.TributoFacturableDTO;
import enumerados.TributoConRegistro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

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
    private TributoFacturableDTO tributoFacturableSelect;
    private GenerarFactInvController controller = new GenerarFactInvController();
    private Integer anio;

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
    
    public void generar(ActionEvent evento){
        try{
            switch (nombreTributoSelect) {
                case "INMOBILIARIO":
                    facturas = controller.generarComprobantes(tributoFacturableSelect, anio, "admin");
                    break;
                case "PATENTE":
                    facturas = controller.generarComprobantes(tributoFacturableSelect, anio, "admin");
                    break;
                case "CEMENTERIO":
                    facturas = controller.generarComprobantes(tributoFacturableSelect, anio, "admin");
                    break;
                case "VEHICULO":
                    facturas = controller.generarComprobantes(tributoFacturableSelect, anio, "admin");
                    break;
                case "REGISTRO":
                    facturas = controller.generarComprobantes(tributoFacturableSelect, anio, "admin");
                    break;
                default:
                    break;
            }
        }catch(PersistenceException | SQLException ex){
            controller.rollbackTransaccion();
        }    
    }
    
    public String irVista(){
        nombreTributoSelect=null;
        return "generarIndividual";
    }
    
    public String mostrarDetalle(FacturaDTO factura){
        facturaSelect = factura;
        return "verfacturaIndividualDetalle";
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public TributoFacturableDTO getTributoFacturableSelect() {
        return tributoFacturableSelect;
    }

    public void setTributoFacturableSelect(TributoFacturableDTO tributoFacturableSelect) {
        this.tributoFacturableSelect = tributoFacturableSelect;
    }
}
