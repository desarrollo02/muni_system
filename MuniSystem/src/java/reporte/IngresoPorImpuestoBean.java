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
@ManagedBean(name = "ingresoPorImpuestoBean")
@SessionScoped
public class IngresoPorImpuestoBean extends MensajeBean implements Serializable {
    
    public String irVista(){
        return "ingreso_por_impuesto";
    }

    /**
     * Creates a new instance of IngresoPorImpuestoBean
     */
    public IngresoPorImpuestoBean() {
    }
    
}
