package bean;

import controller.GenerarFacturaController;
import dto.FacturaDTO;
import enumerados.TributoConRegistro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;

@Named(value = "generarFacturasBean")
@SessionScoped
public class GenerarFacturasBean implements Serializable {
    
    private String nombreTributoSelect;
    private Integer anio;
    private GenerarFacturaController controller = new GenerarFacturaController();
    private List<FacturaDTO> facturas;
    private FacturaDTO facturaSelect;

    public GenerarFacturasBean() {
    } 
    
    public String irVista(){
        nombreTributoSelect=null;
        anio=null;
        return "generar";
    }
    
    public void generar(ActionEvent evento){
        if(nombreTributoSelect.equals("INMOBILIARIO")){
            facturas = controller.generarComprobantes(TributoConRegistro.INMOBILIARIO, anio, "admin");
        }else if(nombreTributoSelect.equals("PATENTE")){
            facturas = controller.generarComprobantes(TributoConRegistro.PATENTE, anio, "admin");
        }else if(nombreTributoSelect.equals("CEMENTERIO")){
            facturas = controller.generarComprobantes(TributoConRegistro.CEMENTERIO, anio, "admin");
        }else if(nombreTributoSelect.equals("VEHICULO")){
            facturas = controller.generarComprobantes(TributoConRegistro.VEHICULO, anio, "admin");
        }
    }
    
    public String mostrarDetalle(FacturaDTO factura){
        facturaSelect = factura;
        return "verfacturaDetalle";
    }

    public String getNombreTributoSelect() {
        return nombreTributoSelect;
    }

    public void setNombreTributoSelect(String nombreTributoSelect) {
        this.nombreTributoSelect = nombreTributoSelect;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
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
}
