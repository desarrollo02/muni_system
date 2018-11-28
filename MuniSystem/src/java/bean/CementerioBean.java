package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Cementerio;
import jpa.Contribuyente;
import manager.CementerioManager;
import manager.ContribuyenteManager;
import util.FormEnableCementerio;

@ManagedBean(name = "cementerioBean")
@SessionScoped
public class CementerioBean extends MensajeBean implements Serializable {
    
    private FormEnableCementerio formEnable;
    private CementerioManager manager;
    private Cementerio cementerio;
    private Cementerio cementerioSelect;
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroRuc;
    private String filtroNombre;
    private String filtroApellido;
    private String filtroEmpresa;
    private List<Contribuyente> resultFiltroContribuyenteList;
    private Contribuyente contribuyente;
    private ContribuyenteManager managerContribuyente;
    private List<Cementerio> resultFiltroCementerioList;
    private Integer filtroCementerioRmc;
    private String filtroCementerioCedula;
    private Integer filtroCementerioNroLote;
    private List<String> ubicacionCementerio;
    
    @PostConstruct
    public void init(){
        manager = new CementerioManager();
        managerContribuyente = new ContribuyenteManager();
        setFormEnable(new FormEnableCementerio());
        ubicacionCementerio = getManager().getNombreUbicacionCementerioList();
    }
    
    public String irVista(){
        inicio();
        return "cementerio";
    }
    
    private void inicio(){
        getFormEnable().inicio();
        cementerio = new Cementerio();
    }
    
    public void nuevo(ActionEvent evento){
        formEnable.nuevo();
        cementerio = new Cementerio();
        cementerio.setIdContribuyente(new Contribuyente());
    }
    
    public void cancelar(ActionEvent evento){
        inicio();
    }
    
    public void eliminar(ActionEvent evento){
        manager.eliminar(cementerio);
        inicio();
        super.mensajeExito("Datos Eliminados");
    }
    
    public void guardar(ActionEvent evento){
        if(cementerio.getIdCementerio() == null){
            guardarNuevo();
        }else{
            guardarCambios();
        }
    }
    
    private void guardarNuevo(){
        if(isValidoCampos()){    
            if(manager.existeNroPatente(cementerio)){
                super.mensajeError("La nro de lote ya existe");
            }else{
                cementerio.setFecAlta(new Date());
                manager.guardar(cementerio);
                inicio();
                super.mensajeExito("Datos Guardados");
            }
        }
    }
    
    private boolean isValidoCampos(){
        boolean valido=true;
        if(cementerio.getNroLote() == null || cementerio.getNroLote() <= 0){
            valido=false;
            super.mensajeError("Debe ingresar nro de lote");              
        }
        if(cementerio.getValuacion() == null || cementerio.getValuacion() <= 0){
            valido=false;
            super.mensajeError("Debe ingresar valuacion");
        }
       
        return valido;
    }
    
    private void guardarCambios(){
        
        if(isValidoCampos()){    
            if(manager.existeNroPatente(cementerio)){
                super.mensajeError("La nro de lote ya existe");
            }else{    
                manager.actualizar(cementerio);
                inicio();
                super.mensajeExito("Datos Guardados");
            }
        }
    }
    
    public void editar(ActionEvent e){
        formEnable.editar();
    }
    
    
    public void aceptarSelectContribuyente(ActionEvent e){
        
        if(contribuyente != null){
            cementerio.setIdContribuyente(contribuyente);
        }     
    }
    
    public void aceptarSelect(ActionEvent ev){      
        if(cementerioSelect != null){
            cementerio = cementerioSelect;
            formEnable.selecionado();
        }
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
    
    public void filtrarComercio(ActionEvent evento){
        resultFiltroCementerioList = manager.filtrar(filtroCementerioRmc, 
                                    filtroCementerioCedula, 
                                    filtroCementerioNroLote);
    }
    
    public void todosComercio(ActionEvent evento){
        filtroCementerioRmc=null;
        filtroCementerioCedula=null;
        filtroCementerioNroLote=null;
        resultFiltroCementerioList =manager.filtrar(filtroCementerioRmc, 
                                    filtroCementerioCedula, 
                                    filtroCementerioNroLote);
    }

    public CementerioBean() {
    }

    public FormEnableCementerio getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableCementerio formEnable) {
        this.formEnable = formEnable;
    }

    public CementerioManager getManager() {
        return manager;
    }

    public void setManager(CementerioManager manager) {
        this.manager = manager;
    }

    public Cementerio getCementerio() {
        return cementerio;
    }

    public void setCementerio(Cementerio cementerio) {
        this.cementerio = cementerio;
    }

    public Cementerio getCementerioSelect() {
        return cementerioSelect;
    }

    public void setCementerioSelect(Cementerio cementerioSelect) {
        this.cementerioSelect = cementerioSelect;
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

    public List<Contribuyente> getResultFiltroContribuyenteList() {
        return resultFiltroContribuyenteList;
    }

    public void setResultFiltroContribuyenteList(List<Contribuyente> resultFiltroContribuyenteList) {
        this.resultFiltroContribuyenteList = resultFiltroContribuyenteList;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public ContribuyenteManager getManagerContribuyente() {
        return managerContribuyente;
    }

    public void setManagerContribuyente(ContribuyenteManager managerContribuyente) {
        this.managerContribuyente = managerContribuyente;
    }

    public List<Cementerio> getResultFiltroCementerioList() {
        return resultFiltroCementerioList;
    }

    public void setResultFiltroCementerioList(List<Cementerio> resultFiltroCementerioList) {
        this.resultFiltroCementerioList = resultFiltroCementerioList;
    }

    public Integer getFiltroCementerioRmc() {
        return filtroCementerioRmc;
    }

    public void setFiltroCementerioRmc(Integer filtroCementerioRmc) {
        this.filtroCementerioRmc = filtroCementerioRmc;
    }

    public String getFiltroCementerioCedula() {
        return filtroCementerioCedula;
    }

    public void setFiltroCementerioCedula(String filtroCementerioCedula) {
        this.filtroCementerioCedula = filtroCementerioCedula;
    }

    public Integer getFiltroCementerioNroLote() {
        return filtroCementerioNroLote;
    }

    public void setFiltroCementerioNroLote(Integer filtroCementerioNroLote) {
        this.filtroCementerioNroLote = filtroCementerioNroLote;
    }

    public List<String> getUbicacionCementerio() {
        return ubicacionCementerio;
    }

    public void setUbicacionCementerio(List<String> ubicacionCementerio) {
        this.ubicacionCementerio = ubicacionCementerio;
    }
    
}
