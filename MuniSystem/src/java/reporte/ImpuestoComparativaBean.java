/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import bean.MensajeBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author USUARIO
 */
@ManagedBean(name = "impuestoComparativaBean")
@SessionScoped
public class ImpuestoComparativaBean extends MensajeBean implements Serializable {

     public String irVista(){
        return "impuesto_comparativa";
    }
    
    /**
     * Creates a new instance of ImpuestoComparativaBean
     */
    public ImpuestoComparativaBean() {
    }
    
}
