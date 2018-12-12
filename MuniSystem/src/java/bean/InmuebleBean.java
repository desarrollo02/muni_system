package bean;

import jpa.Contribuyente;
import manager.InmuebleManager;
import jpa.Inmueble;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import manager.ContribuyenteManager;
import util.FormEnableInmueble;

@ManagedBean(name = "inmuebleBean")
@SessionScoped
public class InmuebleBean extends MensajeBean implements Serializable {
    
    private FormEnableInmueble formEnable;
    private InmuebleManager manager;
    private Inmueble inmueble;
    private Inmueble inmuebleSelect;
    private Integer idContribuyente;
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroRuc;
    private String filtroNombre;
    private String filtroApellido;
    private String filtroEmpresa;
    private List<Contribuyente> resultFiltroList;
    private Contribuyente contribuyente;
    private ContribuyenteManager managerContribuyente;
    private List<Inmueble> resultFiltroInmuebleList;
    private Integer filtroInmRmc;
    private String filtroInmCedula;
    private String filtroInmRuc;
    private Integer filtroInmPadron;
    private String filtroInmCtaCte;
    private Integer filtroInmNroFinca;
    
    @PostConstruct
    public void init(){
        manager = new InmuebleManager();
        managerContribuyente = new ContribuyenteManager();
        setFormEnable(new FormEnableInmueble());
    }
    
    private void inicio(){
        getFormEnable().inicio();
        inmueble = new Inmueble();
    }
    
    public String irVista(){
        inicio();
        return "inmueble";
    }
    
    public void nuevo(ActionEvent evento){
        formEnable.nuevo();
        inmueble = new Inmueble();
        inmueble.setIdContribuyente(new Contribuyente());
        inmuebleSelect = null;
    }
    
    public void cancelar(ActionEvent evento){
        inicio();
    }
    
    public void eliminar(ActionEvent evento){
        manager.eliminar(inmueble);
        inicio();
        super.mensajeExito("Datos Eliminados");
    }
    
    public void guardar(ActionEvent evento){
        if(inmueble.getIdInmueble() == null){
            guardarNuevo();
        }else{
            guardarCambios();
        }
    }
    
    private void guardarNuevo(){
        if(inmueble.getCtaCte() == null && inmueble.getPadron() == null && inmueble.getNroFinca() == null){
            super.mensajeError("Debe ingresar identificador de inmueble(Cta. Cte. o Nro. Padron o Nro. Finca)");           
        }else if(manager.existeCtaCte(inmueble)){
            super.mensajeError("La cuenta corriente catastral ya existe");
        }else if(manager.existeNroFinca(inmueble)){
            super.mensajeError("El nro de finca ya existe");
        }else if(manager.existeNroPadron(inmueble)){
            super.mensajeError("El nro de padron ya existe");
        }else{  
            inmueble.setFechaAlta(new Date());
            manager.guardar(inmueble);
            inicio();
            super.mensajeExito("Datos Guardados");
        }
    }
    
    private void guardarCambios(){
        if(inmueble.getCtaCte() == null && inmueble.getPadron() == null && inmueble.getNroFinca() == null){
            super.mensajeError("Debe ingresar identificador de inmueble(Cta. Cte. o Nro. Padron o Nro. Finca)");           
        }else if(manager.existeCtaCte(inmueble)){
            super.mensajeError("La cuenta corriente catastral ya existe");
        }else if(manager.existeNroFinca(inmueble)){
            super.mensajeError("El nro de finca ya existe");
        }else if(manager.existeNroPadron(inmueble)){
            super.mensajeError("El nro de padron ya existe");
        }else{
            manager.actualizar(inmueble);
            inicio();
            super.mensajeExito("Datos Guardados");
        }
    }
    
    public void editar(ActionEvent e){
        formEnable.editar();
    }
    
    
    public void aceptarSelectContribuyente(ActionEvent e){
        
        if(contribuyente != null){
            inmueble.setIdContribuyente(contribuyente);
        }     
    }
    
    public void filtrarContribuyente(ActionEvent evento){
        resultFiltroList = managerContribuyente.filtrar(filtroCedula, filtroRuc, filtroNombre, filtroApellido, filtroEmpresa);
    }
    
    public void todosContribuyente(ActionEvent evento){
        filtroCedula=null;
        filtroRuc=null;
        filtroNombre=null;
        filtroApellido=null;
        filtroEmpresa=null;
        resultFiltroList = managerContribuyente.filtrar(filtroCedula, filtroRuc, filtroNombre, filtroApellido, filtroEmpresa);
    }
    
    public void filtrarInmueble(ActionEvent evento){
        resultFiltroInmuebleList = manager.filtrar(filtroInmRmc, filtroInmCedula, filtroInmCedula, filtroInmPadron, filtroInmCtaCte, filtroInmNroFinca);
    }
    
    public void todosInmueble(ActionEvent evento){
        filtroInmRmc=null;
        filtroInmCedula=null;
        filtroInmCedula=null;
        filtroInmPadron=null;
        filtroInmCtaCte=null;
        filtroInmNroFinca=null;
        resultFiltroInmuebleList = manager.filtrar(filtroInmRmc, filtroInmCedula, filtroInmCedula, filtroInmPadron, filtroInmCtaCte, filtroInmNroFinca);
    }
    
    public void aceptarSelect(ActionEvent ev){      
        if(inmueble != null){
            getFormEnable().FormEnableCampos(false, false, false, false, false, false, false, false, false, false, false);
            getFormEnable().FormEnableBotones(false, true, true, false, false, false, false);
        }
    }

    public FormEnableInmueble getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableInmueble formEnable) {
        this.formEnable = formEnable;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Integer getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public Integer getFiltroRMC() {
        return filtroRMC;
    }

    public void setFiltroRMC(Integer filtroRMC) {
        this.filtroRMC = filtroRMC;
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

    public List<Inmueble> getResultFiltroInmuebleList() {
        return resultFiltroInmuebleList;
    }

    public void setResultFiltroInmuebleList(List<Inmueble> resultFiltroInmuebleList) {
        this.resultFiltroInmuebleList = resultFiltroInmuebleList;
    }

    public Integer getFiltroInmRmc() {
        return filtroInmRmc;
    }

    public void setFiltroInmRmc(Integer filtroInmRmc) {
        this.filtroInmRmc = filtroInmRmc;
    }

    public String getFiltroInmCedula() {
        return filtroInmCedula;
    }

    public void setFiltroInmCedula(String filtroInmCedula) {
        this.filtroInmCedula = filtroInmCedula;
    }

    public String getFiltroInmRuc() {
        return filtroInmRuc;
    }

    public void setFiltroInmRuc(String filtroInmRuc) {
        this.filtroInmRuc = filtroInmRuc;
    }

    public Integer getFiltroInmPadron() {
        return filtroInmPadron;
    }

    public void setFiltroInmPadron(Integer filtroInmPadron) {
        this.filtroInmPadron = filtroInmPadron;
    }

    public String getFiltroInmCtaCte() {
        return filtroInmCtaCte;
    }

    public void setFiltroInmCtaCte(String filtroInmCtaCte) {
        this.filtroInmCtaCte = filtroInmCtaCte;
    }

    public Integer getFiltroInmNroFinca() {
        return filtroInmNroFinca;
    }

    public void setFiltroInmNroFinca(Integer filtroInmNroFinca) {
        this.filtroInmNroFinca = filtroInmNroFinca;
    }

    public Inmueble getInmuebleSelect() {
        return inmuebleSelect;
    }

    public void setInmuebleSelect(Inmueble inmuebleSelect) {
        this.inmuebleSelect = inmuebleSelect;
        if(inmuebleSelect != null){
            inmueble = inmuebleSelect;
        }
    }
}
