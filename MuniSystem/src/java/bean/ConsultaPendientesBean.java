package bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.ComprobanteCabecera;

/**
 *
 * @author diaz
 */
@ManagedBean(name = "consultaPendientesBean")
@SessionScoped
public class ConsultaPendientesBean implements Serializable {
    
    private Integer filtroNroFactura;
    private Integer filtroAnio;
    private String filtroImpuesto;
    private Integer filtroRmc;
    private String filtroCedula;
    private String filtroRuc;
    private String filtroEmpresa;
    private String filtroNombres;
    private String filtroApellidos;
    private List<ComprobanteCabecera> comprobantes;
    
    public void filtrar(ActionEvent e){
        /*comprobantes = manager.filtrar(filtroAnio, filtroImpuesto, filtroRmc, 
                        filtroCedula, filtroNombres, filtroApellidos, 
                        filtroRuc, filtroEmpresa, filtroNroFactura);*/
    }
    
    public void limpiarFiltro(ActionEvent e){
        comprobantes = null;
        filtroAnio = null;
        filtroImpuesto = null;
        filtroRmc = null;
        filtroCedula = null;
        filtroRuc = null;
        filtroEmpresa = null;
        filtroNombres = null;
        filtroApellidos = null;
        filtroNroFactura = null;
    }
    
    public String mostrarDetalle(ComprobanteCabecera cabecera){
        return "detalleComprobante";
    }
    
    public String irVista(){
        comprobantes = null;
        filtroAnio = null;
        filtroImpuesto = null;
        filtroRmc = null;
        filtroCedula = null;
        filtroRuc = null;
        filtroEmpresa = null;
        filtroNombres = null;
        filtroApellidos = null;
        return "pendientes";
    }

    /**
     * Creates a new instance of ConsultaPendientesBean
     */
    public ConsultaPendientesBean() {
    }

    public List<ComprobanteCabecera> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<ComprobanteCabecera> comprobantes) {
        this.comprobantes = comprobantes;
    }

    public Integer getFiltroAnio() {
        return filtroAnio;
    }

    public void setFiltroAnio(Integer filtroAnio) {
        this.filtroAnio = filtroAnio;
    }

    public String getFiltroImpuesto() {
        return filtroImpuesto;
    }

    public void setFiltroImpuesto(String filtroImpuesto) {
        this.filtroImpuesto = filtroImpuesto;
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

    public String getFiltroRuc() {
        return filtroRuc;
    }

    public void setFiltroRuc(String filtroRuc) {
        this.filtroRuc = filtroRuc;
    }

    public String getFiltroEmpresa() {
        return filtroEmpresa;
    }

    public void setFiltroEmpresa(String filtroEmpresa) {
        this.filtroEmpresa = filtroEmpresa;
    }

    public String getFiltroNombres() {
        return filtroNombres;
    }

    public void setFiltroNombres(String filtroNombres) {
        this.filtroNombres = filtroNombres;
    }

    public String getFiltroApellidos() {
        return filtroApellidos;
    }

    public void setFiltroApellidos(String filtroApellidos) {
        this.filtroApellidos = filtroApellidos;
    }

    public Integer getFiltroNroFactura() {
        return filtroNroFactura;
    }

    public void setFiltroNroFactura(Integer filtroNroFactura) {
        this.filtroNroFactura = filtroNroFactura;
    }
    
}
