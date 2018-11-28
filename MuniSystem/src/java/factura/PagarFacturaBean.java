package factura;

import bean.MensajeBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;

@ManagedBean(name = "pagarFacturaBean")
@SessionScoped
public class PagarFacturaBean extends MensajeBean implements Serializable {
    
    private Integer filtroNroFactura;
    private Integer filtroRmc;
    private String filtroCedula;
    private ComprobanteCabecera comprobanteSelect;
    private List<ComprobanteCabecera> comprobantes;
    private List<ComprobanteDetalle> detalleSelect;
    private PagarFacturaManager pagarFacturaManager = new PagarFacturaManager();
    private String tipoPago;
    private String nroCheque;
    private Double monto;
    private Double vuelto;
    
    private void limpiarDialogo(){
        tipoPago = "SELECCIONAR";
        nroCheque = null;
        monto = null;
        vuelto = null;
    }
    
    private void limpiarVariables(){
        filtroNroFactura = null;
        filtroRmc = null;
        filtroCedula = null;
        comprobanteSelect = null;
        comprobantes = null;
        detalleSelect = null;
        limpiarDialogo();
    }
    
    public String irVista(){
        limpiarVariables();
        return "pagar";
    }
    
    public void filtrar(ActionEvent e){
        pagarFacturaManager.setFiltro(filtroNroFactura, filtroRmc, filtroCedula);
        comprobantes = pagarFacturaManager.filtrar();
    }
    
    public void cancelarPago(ActionEvent e){
        limpiarDialogo();
    }
    
    public void pagar(ActionEvent e){
        if(comprobanteSelect == null){
            super.mensajeError("Debe seleccinar una factura");
        }else if(comprobanteSelect.getTotalPagar() > monto){
            super.mensajeError("El monto ingresado no cubre la deuda");
        }else{
            pagarFacturaManager.setComprobante(comprobanteSelect);
            try{
                if(pagarFacturaManager.isVencido()){
                    super.mensajeError("Factura Vencida");
                    limpiarDialogo();
                }else{
                    pagarFacturaManager.setComprobante(comprobanteSelect);
                    pagarFacturaManager.getComprobante().setFechaPago(new Date());
                    pagarFacturaManager.getComprobante().setTipoPago(tipoPago);
                    pagarFacturaManager.getComprobante().setNroCheque(nroCheque);
                    pagarFacturaManager.pagar(super.getUsuario().getDescripcion());
                    super.mensajeExito("Factura Pagada");
                    limpiarVariables();
                }    
            }catch(Exception ex){
                super.mensajeError("Error al intentar Pagar");
            }
        }    
    }

    public PagarFacturaBean() {
    }

    public Integer getFiltroNroFactura() {
        return filtroNroFactura;
    }

    public void setFiltroNroFactura(Integer filtroNroFactura) {
        this.filtroNroFactura = filtroNroFactura;
    }

    public ComprobanteCabecera getComprobanteSelect() {
        return comprobanteSelect;
    }

    public void setComprobanteSelect(ComprobanteCabecera comprobanteSelect) {
        this.comprobanteSelect = comprobanteSelect;
    }

    public List<ComprobanteCabecera> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<ComprobanteCabecera> comprobantes) {
        this.comprobantes = comprobantes;
    }

    public List<ComprobanteDetalle> getDetalleSelect() {
        return detalleSelect;
    }

    public void setDetalleSelect(List<ComprobanteDetalle> detalleSelect) {
        this.detalleSelect = detalleSelect;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getVuelto() {
        if(comprobanteSelect != null && monto != null){
            vuelto = monto - comprobanteSelect.getTotalPagar();
        }    
        return vuelto;
    }

    public void setVuelto(Double vuelto) {
        this.vuelto = vuelto;
    }    

    public Integer getFiltroRmc() {
        return filtroRmc;
    }

    public void setFiltroRmc(Integer filtroRmc) {
        this.filtroRmc = filtroRmc;
    }

    public String getFiltroCedula() {
        return filtroCedula;
    }

    public void setFiltroCedula(String filtroCedula) {
        this.filtroCedula = filtroCedula;
    }
}
