package reporte;

import bean.MensajeBean;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import jpa.Contribuyente;
import manager.ContribuyenteManager;
import reporte.manager.EstadoCuentaManager;
import util.JasperReportUtils;

@ManagedBean(name = "estadoCuentaBean")
@SessionScoped
public class EstadoCuentaBean extends MensajeBean implements Serializable {
    
    private Contribuyente contribuyente;
    private List<Contribuyente> resultFiltroContribuyenteList;
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroRuc;
    private String filtroNombre;
    private String filtroApellido;
    private String filtroEmpresa;
    private ContribuyenteManager managerContribuyente = new ContribuyenteManager();
    private EstadoCuentaManager manager = new EstadoCuentaManager();
    
    public String descargar(){
        try {
            ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
            String separador = System.getProperty("file.separator");
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("FACHA_ACTUAL",new Date());
            parametros.put("RMC",contribuyente.getIdContribuyente());
            JasperReportUtils.runReportB("estado_cuenta","/seguro/reporte/estado_cuenta.jasper",parametros);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CobranzasDelDiaBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void aceptarSelectContribuyente(ActionEvent e){
        
            
    }
    
    public void filtrarContribuyente(ActionEvent evento){
        resultFiltroContribuyenteList = managerContribuyente.filtrar(filtroCedula, filtroRuc, filtroNombre, filtroApellido, filtroEmpresa);
    }
    
    public void todosContribuyente(ActionEvent evento){
        filtroCedula=null;
        filtroRuc=null;
        filtroNombre=null;
        filtroApellido=null;
        filtroEmpresa=null;
        resultFiltroContribuyenteList = managerContribuyente.filtrar(filtroCedula, filtroRuc, filtroNombre, filtroApellido, filtroEmpresa);
    }

    public String irVista(){
        contribuyente = new Contribuyente();
        return "estado_cuenta";
    }
    
    /**
     * Creates a new instance of EstadoCuentaBean
     */
    public EstadoCuentaBean() {
    }

    /**
     * @return the contribuyente
     */
    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    /**
     * @param contribuyente the contribuyente to set
     */
    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    /**
     * @return the resultFiltroContribuyenteList
     */
    public List<Contribuyente> getResultFiltroContribuyenteList() {
        return resultFiltroContribuyenteList;
    }

    /**
     * @param resultFiltroContribuyenteList the resultFiltroContribuyenteList to set
     */
    public void setResultFiltroContribuyenteList(List<Contribuyente> resultFiltroContribuyenteList) {
        this.resultFiltroContribuyenteList = resultFiltroContribuyenteList;
    }

    /**
     * @return the filtroRMC
     */
    public Integer getFiltroRMC() {
        return filtroRMC;
    }

    /**
     * @param filtroRMC the filtroRMC to set
     */
    public void setFiltroRMC(Integer filtroRMC) {
        this.filtroRMC = filtroRMC;
    }

    /**
     * @return the filtroCedula
     */
    public String getFiltroCedula() {
        return filtroCedula;
    }

    /**
     * @param filtroCedula the filtroCedula to set
     */
    public void setFiltroCedula(String filtroCedula) {
        this.filtroCedula = filtroCedula;
    }

    /**
     * @return the filtroRuc
     */
    public String getFiltroRuc() {
        return filtroRuc;
    }

    /**
     * @param filtroRuc the filtroRuc to set
     */
    public void setFiltroRuc(String filtroRuc) {
        this.filtroRuc = filtroRuc;
    }

    public String getFiltroNombre() {
        return filtroNombre;
    }

    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    public String getFiltroApellido() {
        return filtroApellido;
    }

    public void setFiltroApellido(String filtroApellido) {
        this.filtroApellido = filtroApellido;
    }

    public String getFiltroEmpresa() {
        return filtroEmpresa;
    }

    public void setFiltroEmpresa(String filtroEmpresa) {
        this.filtroEmpresa = filtroEmpresa;
    }
}
