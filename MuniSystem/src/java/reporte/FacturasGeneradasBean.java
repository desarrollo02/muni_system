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
import reporte.manager.FacturasGeneradasManager;



/**
 *
 * @author USUARIO
 */
@ManagedBean(name = "facturasGeneradasBean")
@SessionScoped
public class FacturasGeneradasBean extends MensajeBean implements Serializable{
    
    private String filtroTipoImpuesto;
    private Integer filtroAnio;
    private FacturasGeneradasManager manager = new FacturasGeneradasManager();
    private List<ComprobanteCabecera> comprobantes;
    
    public void filtrar(ActionEvent e){
        /*if(filtroTipoImpuesto.equals("I")){
            impuesto = manager.getImpuestoInmobiliario();
        }else if(filtroTipoImpuesto.equals("P")){
            impuesto = manager.getImpuestoPatenteComercial();
        }else if(filtroTipoImpuesto.equals("C")){
            impuesto = manager.getImpuestoLoteCementerio();
        }else if(filtroTipoImpuesto.equals("H")){
            impuesto = manager.getImpuestoHabilitacion();
        }else if(filtroTipoImpuesto.equals("R")){
            impuesto = manager.getImpuestoRegistroConducir();
        }else{
            impuesto = null;
        }
        comprobantes = manager.getComprobante(impuesto, filtroAnio);*/
    }

    public String irVista(){
        return "facturas_generadas";
    }
    
    /**
     * Creates a new instance of acturasGeneradasBean
     */
    public FacturasGeneradasBean() {
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
