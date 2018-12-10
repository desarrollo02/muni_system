package bean;

import controller.PagarFacController;
import dto.FacturaDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

/**
 *
 * @author desarrollo2
 */
@Named(value = "pagarBean")
@SessionScoped
public class PagarBean extends BaseBean implements Serializable {
    
    private Integer nroFactura; 
    private Integer rmc;
    private Integer anio;
    private String nombreTributo;
    private List<FacturaDTO> facturas;
    private FacturaDTO facturaSelect;
    private PagarFacController controller = new PagarFacController();
    private String tipoPago;
    private String nroCheque;
    private Double montoRecibido;
    private Double vuelto;
    private String decsTipoPago;
    
    public void limbiarVariables(){
        nroFactura=null; 
        setRmc(null);
        anio=null;
        nombreTributo=null;
        facturas=null;
        facturaSelect=null;
        tipoPago=null;
        nroCheque=null;
        montoRecibido=null;
        decsTipoPago=null;
    }
    
    public String irVista(){
        limbiarVariables();
        return "pagar";
    }

    public PagarBean() {
    }

    public void buscar(ActionEvent evento){
        facturas = controller.getFacturas(nroFactura, rmc, anio, nombreTributo);
    }
    
    public String mostrarDetalle(FacturaDTO factura){
        facturaSelect = factura;
        return "pagarDetalle";
    }
    
    public String pagar(){
        try{
            if(montoRecibido < facturaSelect.getTotal()){
                super.setMensajeError("Monto Recibido no cubre el monto de la factura");
                return null;
            }
            if(facturaSelect.getPagado().equals("Si")){
                super.setMensajeError("La factura ya esta pagada");
                return null;
            }
            Integer diasAtraso = controller.getDiasAtraso(facturaSelect);
            if(diasAtraso > 1){
                super.setMensajeError("La factura esta vencida");
                return null;
            }
            controller.pagar(facturaSelect, tipoPago, nroCheque);
            vuelto = montoRecibido - facturaSelect.getTotal();
            if(tipoPago.equals("E")){
                decsTipoPago="Efectivo";
            }else if(tipoPago.equals("C")){
                decsTipoPago="Cheque";
            }else if(tipoPago.equals("T")){
                decsTipoPago="Tarjeta de Crédito";
            }else if(tipoPago.equals("P")){
                decsTipoPago="Tarjeta de Debito";
            }
            super.setMensaje("Factura pagada correctamente");
        }catch(PersistenceException | SQLException ex){
            controller.rollbackTransaccion();
            super.setMensajeError("Error al intentar anular la factura");
        }    
        return "pagoVuelto";
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Integer getRmc() {
        return rmc;
    }

    public void setRmc(Integer rmc) {
        this.rmc = rmc;
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

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public Double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(Double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public Double getVuelto() {
        return vuelto;
    }

    public void setVuelto(Double vuelto) {
        this.vuelto = vuelto;
    }

    public String getDecsTipoPago() {
        return decsTipoPago;
    }

    public void setDecsTipoPago(String decsTipoPago) {
        this.decsTipoPago = decsTipoPago;
    }
}
