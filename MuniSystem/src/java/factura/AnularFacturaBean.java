/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import bean.MensajeBean;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;

/**
 *
 * @author USUARIO
 */
@ManagedBean(name = "anularFacturaBean")
@SessionScoped
public class AnularFacturaBean extends MensajeBean implements Serializable {
    
    private Integer filtroNroFactura;
    private ComprobanteCabecera comprobanteSelect;
    private List<ComprobanteCabecera> comprobantes;
    private List<ComprobanteDetalle> detalleSelect;
    private AnularFacturaManager anularFacturaManager = new AnularFacturaManager();
    
    public String irVista(){
        filtroNroFactura = null;
        comprobanteSelect = null;
        return "anular";
    }
    
    public void filtrar(ActionEvent e){
        anularFacturaManager.setNroFactura(filtroNroFactura);
        comprobanteSelect = anularFacturaManager.getComprobante();
        comprobantes = anularFacturaManager.getComprobantes();
    }
    
    public void anular(ActionEvent e){
        try{
            anularFacturaManager.anular();
            super.mensajeExito("Factura Anulada");
        }catch(Exception ex){
            super.mensajeError("Error al intentar anular");
        }    
    }

    /**
     * Creates a new instance of AnularFacturaBean
     */
    public AnularFacturaBean() {
    }

    /**
     * @return the filtroNroFactura
     */
    public Integer getFiltroNroFactura() {
        return filtroNroFactura;
    }

    /**
     * @param filtroNroFactura the filtroNroFactura to set
     */
    public void setFiltroNroFactura(Integer filtroNroFactura) {
        this.filtroNroFactura = filtroNroFactura;
    }

    /**
     * @return the comprobanteSelect
     */
    public ComprobanteCabecera getComprobanteSelect() {
        return comprobanteSelect;
    }

    /**
     * @param comprobanteSelect the comprobanteSelect to set
     */
    public void setComprobanteSelect(ComprobanteCabecera comprobanteSelect) {
        this.comprobanteSelect = comprobanteSelect;
    }

    /**
     * @return the comprobantes
     */
    public List<ComprobanteCabecera> getComprobantes() {
        return comprobantes;
    }

    /**
     * @param comprobantes the comprobantes to set
     */
    public void setComprobantes(List<ComprobanteCabecera> comprobantes) {
        this.comprobantes = comprobantes;
    }

    /**
     * @return the detalleSelect
     */
    public List<ComprobanteDetalle> getDetalleSelect() {
        return detalleSelect;
    }

    /**
     * @param detalleSelect the detalleSelect to set
     */
    public void setDetalleSelect(List<ComprobanteDetalle> detalleSelect) {
        this.detalleSelect = detalleSelect;
    }
    
}
