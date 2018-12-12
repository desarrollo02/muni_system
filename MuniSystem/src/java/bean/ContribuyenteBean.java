package bean;

import jpa.Contribuyente;
import manager.ContribuyenteManager;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import util.FormEnableContribuyente;

@ManagedBean(name = "contribuyenteBean")
@SessionScoped
public class ContribuyenteBean extends MensajeBean implements Serializable {
    
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroRuc;
    private String filtroNombre;
    private String filtroApellido;
    private String filtroEmpresa;
    private List<Contribuyente> resultFiltroList;
    private Contribuyente itemSeleccionado;
    private Contribuyente contribuyente;
    private ContribuyenteManager manager = new ContribuyenteManager();
    private boolean tipoContribuyenteFisico;
    private String tipoContribuyente;
    private FormEnableContribuyente formEnable = new FormEnableContribuyente();
    
    public void nuevo(ActionEvent evento){
        formEnable.formContribuyenteBotones(false, false, false, true, true);
        formEnable.formContribuyenteCampos(true, false, false, false, false, false, false, false, false, false, false, false);
        contribuyente = new Contribuyente();
        itemSeleccionado = null;
    }
    
    public void cancelar(ActionEvent evento){
        formEnable.formContribuyenteBotones(true, true, false, false, false);
        formEnable.formContribuyenteCampos(false, false, false, false, false, false, false, false, false, false, false, false);
        tipoContribuyente = "";
        contribuyente = new Contribuyente();
        itemSeleccionado = null;
    }
    
    public void tipoContribuyenteBlur(AjaxBehaviorEvent e){
        if(tipoContribuyente.equals("F")){
            tipoContribuyenteFisico=true;
            formEnable.formContribuyenteCampos(true, true, true, true, true, false, true, true, true, true, true, true);
        }else{
            tipoContribuyenteFisico=false;
            formEnable.formContribuyenteCampos(true, false, false, false, true, true, true, true, true, true, true, true);
        }
    }
    
    public ContribuyenteBean() {
    }
    
    private void guardarNuevo(){
        try{
            boolean valido=false;
            if(tipoContribuyenteFisico){
                contribuyente.setPersonaJuridica(false);
                if(manager.yaExisteCedula(contribuyente.getCedula())){
                    mensajeError("La cedula ya existe");
                }else if(contribuyente.getRuc() != null && !contribuyente.getRuc().equals("") && manager.yaExisteRuc(contribuyente.getRuc())){
                    mensajeError("RUC ya existe");
                }else{
                    valido=true;
                }
            }else{
                contribuyente.setPersonaJuridica(true);
                if(manager.yaExisteRuc(contribuyente.getRuc())){
                    mensajeError("RUC ya existe");
                }else{
                    valido=true;
                }
            }
            if(valido){
                manager.guardar(contribuyente);
                formEnable.formContribuyenteBotones(true, true, false, false, false);
                formEnable.formContribuyenteCampos(false, false, false, false, false, false, false, false, false, false, false, false);
                tipoContribuyente = "";
                contribuyente = new Contribuyente();
                mensajeExito("Datos Guardados");
            }    
        }catch(Exception e){
            mensajeError("Error al intentar guardar los datos");
        }
    }
    
    public void guardar(ActionEvent evento){
        if(contribuyente.getIdContribuyente() == null){
            guardarNuevo();
        }else{
            guardarCambios();
        }
    }
    
    private void guardarCambios(){
        try{
            boolean valido=false;
            if(tipoContribuyenteFisico){
                contribuyente.setPersonaJuridica(false);
                if(manager.yaExisteCedula(contribuyente.getCedula(), contribuyente.getIdContribuyente())){
                    mensajeError("La cedula ya existe");
                }else if(contribuyente.getRuc() != null && !contribuyente.getRuc().equals("") && manager.yaExisteRuc(contribuyente.getRuc(), contribuyente.getIdContribuyente())){
                    mensajeError("RUC ya existe");
                }else{
                    valido=true;
                }
            }else{
                contribuyente.setPersonaJuridica(true);
                if(manager.yaExisteRuc(contribuyente.getRuc(), contribuyente.getIdContribuyente())){
                    mensajeError("RUC ya existe");
                }else{
                    valido=true;
                }
            }
            if(valido){
                manager.actualizar(contribuyente);
                formEnable.formContribuyenteBotones(true, true, false, false, false);
                formEnable.formContribuyenteCampos(false, false, false, false, false, false, false, false, false, false, false, false);
                tipoContribuyente = "";
                contribuyente = new Contribuyente();
                mensajeExito("Datos Guardados");
            }    
        }catch(Exception e){
            mensajeError("Error al intentar guardar los datos");
        }
    }
    
    public void editar(ActionEvent e){
        if(itemSeleccionado.getPersonaJuridica()){
            tipoContribuyenteFisico=true;
            getFormEnable().formContribuyenteCampos(true, false, false, false, true, true, true, true, true, true, true, true);
        }else{
            tipoContribuyenteFisico=false;
            getFormEnable().formContribuyenteCampos(true, true, true, true, true, false, true, true, true, true, true, true);
        }    
        getFormEnable().formContribuyenteBotones(false, false,false, true, true);
    }
    
    public String eliminar(){
        try{
            manager.eliminar(itemSeleccionado);
            return "listaContribuyente";
        }catch(Exception e){
            return null;
        }
    }
    
    public String irVistaAlta(){
        tipoContribuyente = "F";
        tipoContribuyenteFisico = true;
        contribuyente = new Contribuyente();
        return "contribuyente";
    }
    
    public void todos(ActionEvent evento){
        filtroCedula=null;
        filtroRuc=null;
        filtroNombre=null;
        filtroApellido=null;
        filtroEmpresa=null;
        resultFiltroList = getManager().filtrar(filtroCedula, filtroRuc, filtroNombre, filtroApellido, filtroEmpresa);
    }
    
    public void filtrar(ActionEvent evento){
        resultFiltroList = getManager().filtrar(filtroCedula, filtroRuc, filtroNombre, filtroApellido, filtroEmpresa);
    }
    
    public String aceptarSelect(){
        
        if(itemSeleccionado != null){
            getFormEnable().formContribuyenteCampos(false, false, false, false, false, false, false, false, false, false, false, false);
            getFormEnable().formContribuyenteBotones(false, true, true, true, false);
        }
        return "contribuyente";
        
    }
    
    public String irVista(){
        getFormEnable().formContribuyenteCampos(false, false, false, false, false, false, false, false, false, false, false, false);
        getFormEnable().formContribuyenteBotones(true, true, false, false, false);
        return "contribuyente";
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

    public List<Contribuyente> getResultFiltroList() {
        return resultFiltroList;
    }

    public void setResultFiltroList(List<Contribuyente> resultFiltroList) {
        this.resultFiltroList = resultFiltroList;
    }

    public Contribuyente getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(Contribuyente itemSeleccionado) {
        if(itemSeleccionado != null){
            contribuyente = itemSeleccionado;
        }
        this.itemSeleccionado = itemSeleccionado;
    }

    public boolean isTipoContribuyenteFisico() {
        return tipoContribuyenteFisico;
    }

    public void setTipoContribuyenteFisico(boolean tipoContribuyenteFisico) {
        this.tipoContribuyenteFisico = tipoContribuyenteFisico;
    }

    public String getTipoContribuyente() {
        return tipoContribuyente;
    }

    public void setTipoContribuyente(String tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }

    public ContribuyenteManager getManager() {
        return manager;
    }

    public FormEnableContribuyente getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableContribuyente formEnable) {
        this.formEnable = formEnable;
    }

    public Integer getFiltroRMC() {
        return filtroRMC;
    }

    public void setFiltroRMC(Integer filtroRMC) {
        this.filtroRMC = filtroRMC;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
    
}
