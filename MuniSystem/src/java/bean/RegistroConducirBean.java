package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Contribuyente;
import jpa.RegistroConducir;
import manager.ContribuyenteManager;
import manager.RegistroConducirManager;
import util.FormEnableRegistro;

@ManagedBean(name = "registroConducirBean")
@SessionScoped
public class RegistroConducirBean extends MensajeBean implements Serializable {
    
    private FormEnableRegistro formEnable;
    private RegistroConducirManager manager;
    private RegistroConducir registroConducir;
    private RegistroConducir registroConducirSelect;
    private Integer idContribuyente;
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroRuc;
    private String filtroNombre;
    private String filtroApellido;
    private String filtroEmpresa;
    private List<Contribuyente> resultFiltroContribuyenteList;
    private Contribuyente contribuyente;
    private ContribuyenteManager managerContribuyente;
    private List<RegistroConducir> resultFiltroRegistroConducirList;
    private Integer filtroRegistroConducirRmc;
    private String filtroRegistroConducirCedula;
    private Integer filtroRegistroConducirNro;
    private String filtroRegistroConducirCategoria;
    private List<String> categorias;
    
    @PostConstruct
    public void init(){
        setManager(new RegistroConducirManager());
        setManagerContribuyente(new ContribuyenteManager());
        setFormEnable(new FormEnableRegistro());
        categorias = getManager().getDescripcionCategoriaList();
    }
    
    public String irVista(){
        inicio();
        return "registro";
    }
    
    private void inicio(){
        getFormEnable().inicio();
        registroConducir = new RegistroConducir();
    }
    
    public void nuevo(ActionEvent evento){
        getFormEnable().nuevo();
        registroConducir = new RegistroConducir();
        registroConducir.setIdContribuyente(new Contribuyente());
        registroConducirSelect=null;
    }
    
    public void cancelar(ActionEvent evento){
        inicio();
    }
    
    public void eliminar(ActionEvent evento){
        getManager().eliminar(registroConducir);
        inicio();
        super.mensajeExito("Datos Eliminados");
    }
    
    public void guardar(ActionEvent evento){
        if(registroConducir.getIdRegistroConducir() == null){
            guardarNuevo();
        }else{
            guardarCambios();
        }
    }
    
    private void guardarNuevo(){
        if(isValidoCampos()){    
            if(getManager().existeNroRegistro(registroConducir)){
                super.mensajeError("El nro de licencia ya existe");
            }else{
                registroConducir.setFechaAlta(new Date());
                getManager().guardar(registroConducir);
                inicio();
                super.mensajeExito("Datos Guardados");
            }
        }
    }
    
    private boolean isValidoCampos(){
        boolean valido=true;
        if(registroConducir.getLicenciaNro() == null){
            valido=false;
            super.mensajeError("Debe ingresar nro de licencia");              
        }
        
        if(registroConducir.getVencicimiento() == null){
            valido=false;
            super.mensajeError("Debe ingresar vencimiento");
        }
       
        return valido;
    }
    
    private void guardarCambios(){
        
        if(isValidoCampos()){    
            if(getManager().existeNroRegistro(registroConducir)){
                super.mensajeError("El nro licencia ya existe");
            }else{    
                getManager().actualizar(registroConducir);
                inicio();
                super.mensajeExito("Datos Guardados");
            }
        }
    }
    
    public void editar(ActionEvent e){
        getFormEnable().editar();
    }
    
    
    public void aceptarSelectContribuyente(ActionEvent e){
        
        if(getContribuyente() != null){
            registroConducir.setIdContribuyente(getContribuyente());
        }     
    }
    
    public void aceptarSelect(ActionEvent ev){      
        if(registroConducirSelect != null){
            registroConducir = registroConducirSelect;
            getFormEnable().selecionado();
        }
    }
    
    public void filtrarContribuyente(ActionEvent evento){
        setResultFiltroContribuyenteList(getManagerContribuyente().filtrar(getFiltroCedula(), getFiltroRuc(), getFiltroNombre(), getFiltroApellido(), getFiltroEmpresa()));
    }
    
    public void todosContribuyente(ActionEvent evento){
        setFiltroCedula(null);
        setFiltroRuc(null);
        setFiltroNombre(null);
        setFiltroApellido(null);
        setFiltroEmpresa(null);
        setResultFiltroContribuyenteList(getManagerContribuyente().filtrar(getFiltroCedula(), getFiltroRuc(), getFiltroNombre(), getFiltroApellido(), getFiltroEmpresa()));
    }
    
    public void filtrarRegistroConducir(ActionEvent evento){
        resultFiltroRegistroConducirList = getManager().filtrar(filtroRegistroConducirRmc, filtroRegistroConducirCedula, 
                filtroRegistroConducirNro, filtroRegistroConducirCategoria);
    }
    
    public void todosRegistroConducir(ActionEvent evento){
        filtroRegistroConducirRmc=null;
        filtroRegistroConducirCedula=null;
        filtroRegistroConducirNro=null;
        filtroRegistroConducirCategoria=null;
   
        resultFiltroRegistroConducirList = getManager().filtrar(filtroRegistroConducirRmc, filtroRegistroConducirCedula, 
                filtroRegistroConducirNro, filtroRegistroConducirCategoria);
    }

    public RegistroConducirBean() {
    }

    public FormEnableRegistro getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableRegistro formEnable) {
        this.formEnable = formEnable;
    }

    public RegistroConducirManager getManager() {
        return manager;
    }

    public void setManager(RegistroConducirManager manager) {
        this.manager = manager;
    }

    public RegistroConducir getRegistroConducir() {
        return registroConducir;
    }

    public void setRegistroConducir(RegistroConducir registroConducir) {
        this.registroConducir = registroConducir;
    }

    public RegistroConducir getRegistroConducirSelect() {
        return registroConducirSelect;
    }

    public void setRegistroConducirSelect(RegistroConducir registroConducirSelect) {
        this.registroConducirSelect = registroConducirSelect;
    }

    public Integer getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
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

    public List<RegistroConducir> getResultFiltroRegistroConducirList() {
        return resultFiltroRegistroConducirList;
    }

    public void setResultFiltroRegistroConducirList(List<RegistroConducir> resultFiltroRegistroConducirList) {
        this.resultFiltroRegistroConducirList = resultFiltroRegistroConducirList;
    }

    public Integer getFiltroRegistroConducirRmc() {
        return filtroRegistroConducirRmc;
    }

    public void setFiltroRegistroConducirRmc(Integer filtroRegistroConducirRmc) {
        this.filtroRegistroConducirRmc = filtroRegistroConducirRmc;
    }

    public String getFiltroRegistroConducirCedula() {
        return filtroRegistroConducirCedula;
    }

    public void setFiltroRegistroConducirCedula(String filtroRegistroConducirCedula) {
        this.filtroRegistroConducirCedula = filtroRegistroConducirCedula;
    }

    public Integer getFiltroRegistroConducirNro() {
        return filtroRegistroConducirNro;
    }

    public void setFiltroRegistroConducirNro(Integer filtroRegistroConducirNro) {
        this.filtroRegistroConducirNro = filtroRegistroConducirNro;
    }

    public String getFiltroRegistroConducirCategoria() {
        return filtroRegistroConducirCategoria;
    }

    public void setFiltroRegistroConducirCategoria(String filtroRegistroConducirCategoria) {
        this.filtroRegistroConducirCategoria = filtroRegistroConducirCategoria;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    
}
