/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import bean.MensajeBean;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.ComprobanteCabecera;
import reporte.manager.FacturasAnuladasManager;

/**
 *
 * @author USUARIO
 */
@ManagedBean(name = "facturasAnuladasBean")
@SessionScoped
public class FacturasAnuladasBean extends MensajeBean implements Serializable {
    
    private String filtroTipoImpuesto;
    private Integer filtroAnio;
    private FacturasAnuladasManager manager = new FacturasAnuladasManager();
    private List<ComprobanteCabecera> comprobantes;
    
    public void filtrar(ActionEvent e){
        /*if(getFiltroTipoImpuesto().equals("I")){
            impuesto = manager.getImpuestoInmobiliario();
        }else if(getFiltroTipoImpuesto().equals("P")){
            impuesto = manager.getImpuestoPatenteComercial();
        }else if(getFiltroTipoImpuesto().equals("C")){
            impuesto = manager.getImpuestoLoteCementerio();
        }else if(getFiltroTipoImpuesto().equals("H")){
            impuesto = manager.getImpuestoHabilitacion();
        }else if(getFiltroTipoImpuesto().equals("R")){
            impuesto = manager.getImpuestoRegistroConducir();
        }else{
            impuesto = null;
        }
        setComprobantes(manager.getComprobante(impuesto, getFiltroAnio()));*/
    }

    public String irVista(){
        return "facturas_anuladas";
    }
    
    /**
     * Creates a new instance of FacturasAnuladasBean
     */
    public FacturasAnuladasBean() {
    }

    /**
     * @return the filtroTipoImpuesto
     */
    public String getFiltroTipoImpuesto() {
        return filtroTipoImpuesto;
    }

    /**
     * @param filtroTipoImpuesto the filtroTipoImpuesto to set
     */
    public void setFiltroTipoImpuesto(String filtroTipoImpuesto) {
        this.filtroTipoImpuesto = filtroTipoImpuesto;
    }

    /**
     * @return the filtroAnio
     */
    public Integer getFiltroAnio() {
        return filtroAnio;
    }

    /**
     * @param filtroAnio the filtroAnio to set
     */
    public void setFiltroAnio(Integer filtroAnio) {
        this.filtroAnio = filtroAnio;
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
    
}
