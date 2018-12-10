package bean;

import controller.AnularFacController;
import dto.FacturaDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

/**
 *
 * @author desarrollo2
 */
@Named(value = "anularBean")
@SessionScoped
public class AnularFacturaBean extends BaseBean implements Serializable {
    
    private Integer nroFactura; 
    private Integer rmc;
    private Integer anio;
    private String nombreTributo;
    private List<FacturaDTO> facturas;
    private FacturaDTO facturaSelect;
    private AnularFacController controller = new AnularFacController();
    
    public void limbiarVariables(){
        nroFactura=null; 
        setRmc(null);
        anio=null;
        nombreTributo=null;
        facturas=null;
        facturaSelect=null;
    }
    
    public String irVista(){
        limbiarVariables();
        return "anular";
    }
    
    public void buscar(ActionEvent evento){
        facturas = controller.getFacturas(nroFactura, rmc, anio, nombreTributo);
    }
    
    public void anular(ActionEvent evento){
        try{
            controller.anular(facturaSelect);
            limbiarVariables();
            super.setMensaje("Factura anulada correctamente");
        }catch(PersistenceException | SQLException ex){
            controller.rollbackTransaccion();
            super.setMensajeError("Error al intentar anular la factura");
        }
    }
    
    public String mostrarDetalle(FacturaDTO factura){
        facturaSelect = factura;
        return "anularDetalle";
    }

    public AnularFacturaBean() {
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getNombreTributo() {
        return nombreTributo;
    }

    public void setNombreTributo(String nombreTributo) {
        this.nombreTributo = nombreTributo;
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

    public Integer getRmc() {
        return rmc;
    }

    public void setRmc(Integer rmc) {
        this.rmc = rmc;
    }
    
}
