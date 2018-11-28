package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Comercio;
import jpa.Contribuyente;
import manager.ComercioManager;
import manager.ContribuyenteManager;
import util.FormEnableComercio;

@ManagedBean(name = "comercioBean")
@SessionScoped
public class ComercioBean extends MensajeBean implements Serializable{
    
    private FormEnableComercio formEnable;
    private ComercioManager manager;
    private Comercio comercio;
    private Comercio comercioSelect;
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
    private List<Comercio> resultFiltroComercioList;
    private Integer filtroComercioRmc;
    private String filtroComercioCedula;
    private String filtroComercioRubro;
    private String filtroComercioNombreComercio;
    private Integer filtroComercioNroPatente;
    private String filtroComercioBarrio;
    private String filtroComercioDireccion;
    private List<String> rubros;
    private List<String> barrios;
    
    @PostConstruct
    public void init(){
        manager = new ComercioManager();
        managerContribuyente = new ContribuyenteManager();
        setFormEnable(new FormEnableComercio());
        rubros = manager.getDescripcionComercioRubroList();
        barrios = manager.getDescripcionBarrioList();
    }
    
    public String irVista(){
        inicio();
        return "comercio";
    }
    
    private void inicio(){
        getFormEnable().inicio();
        comercio = new Comercio();
    }
    
    public void nuevo(ActionEvent evento){
        formEnable.nuevo();
        comercio = new Comercio();
        comercio.setIdContribuyente(new Contribuyente());
    }
    
    public void cancelar(ActionEvent evento){
        inicio();
    }
    
    public void eliminar(ActionEvent evento){
        manager.eliminar(comercio);
        inicio();
        super.mensajeExito("Datos Eliminados");
    }
    
    public void guardar(ActionEvent evento){
        if(comercio.getIdComercio() == null){
            guardarNuevo();
        }else{
            guardarCambios();
        }
    }
    
    private void guardarNuevo(){
        if(isValidoCampos()){    
            if(manager.existeNroPatente(comercio)){
                super.mensajeError("La nro de patente ya existe");
            }else if(manager.existeNombreComercio(comercio)){
                super.mensajeError("El nombre de comercio ya existe");
            }else{
                comercio.setFecAlta(new Date());
                manager.guardar(comercio);
                inicio();
                super.mensajeExito("Datos Guardados");
            }
        }
    }
    
    private boolean isValidoCampos(){
        boolean valido=true;
        if(comercio.getNombreFantasia() == null || comercio.getNombreFantasia().equals("")){
            valido=false;
            super.mensajeError("Debe ingresar nombre de Comercio");              
        }
        if( comercio.getNroPatente() <= 0){
            valido=false;
            super.mensajeError("Debe ingresar en numero de patente un numero");
        }
        if(comercio.getValorActivo() == null || comercio.getValorActivo() <= 0){
            valido=false;
            super.mensajeError("Debe ingresar en valor activo un numero");
        }
       
        return valido;
    }
    
    private void guardarCambios(){
        
        if(isValidoCampos()){    
            if(manager.existeNroPatente(comercio)){
                super.mensajeError("La nro de patente ya existe");
            }else if(manager.existeNombreComercio(comercio)){
                super.mensajeError("El nombre de comercio ya existe");
            }else{    
                manager.actualizar(comercio);
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
            comercio.setIdContribuyente(contribuyente);
        }     
    }
    
    public void aceptarSelect(ActionEvent ev){      
        if(comercioSelect != null){
            comercio = comercioSelect;
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
        resultFiltroComercioList = manager.filtrar(filtroComercioRmc, filtroComercioCedula, 
                filtroComercioNombreComercio, filtroComercioNroPatente, filtroComercioBarrio, 
                filtroComercioDireccion);
    }
    
    public void todosComercio(ActionEvent evento){
        filtroComercioRmc=null;
        filtroComercioCedula=null;
        filtroComercioNombreComercio=null;
        filtroComercioNroPatente=null;
        filtroComercioBarrio=null;
        filtroComercioDireccion=null;
        resultFiltroComercioList =manager.filtrar(filtroComercioRmc, filtroComercioCedula, 
                                    filtroComercioNombreComercio, filtroComercioNroPatente, filtroComercioBarrio, 
                                    filtroComercioDireccion);
    }

    public ComercioManager getManager() {
        return manager;
    }

    public void setManager(ComercioManager manager) {
        this.manager = manager;
    }

    public List<String> getRubros() {
        return rubros;
    }

    public void setRubros(List<String> rubros) {
        this.rubros = rubros;
    }

    public FormEnableComercio getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableComercio formEnable) {
        this.formEnable = formEnable;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public Comercio getComercioSelect() {
        return comercioSelect;
    }

    public void setComercioSelect(Comercio comercioSelect) {
        this.comercioSelect = comercioSelect;
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

    public List<Comercio> getResultFiltroComercioList() {
        return resultFiltroComercioList;
    }

    public void setResultFiltroComercioList(List<Comercio> resultFiltroComercioList) {
        this.resultFiltroComercioList = resultFiltroComercioList;
    }

    public Integer getFiltroComercioRmc() {
        return filtroComercioRmc;
    }

    public void setFiltroComercioRmc(Integer filtroComercioRmc) {
        this.filtroComercioRmc = filtroComercioRmc;
    }

    public String getFiltroComercioRubro() {
        return filtroComercioRubro;
    }

    public void setFiltroComercioRubro(String filtroComercioRubro) {
        this.filtroComercioRubro = filtroComercioRubro;
    }

    public String getFiltroComercioNombreComercio() {
        return filtroComercioNombreComercio;
    }

    public void setFiltroComercioNombreComercio(String filtroComercioNombreComercio) {
        this.filtroComercioNombreComercio = filtroComercioNombreComercio;
    }

    public Integer getFiltroComercioNroPatente() {
        return filtroComercioNroPatente;
    }

    public void setFiltroComercioNroPatente(Integer filtroComercioNroPatente) {
        this.filtroComercioNroPatente = filtroComercioNroPatente;
    }

    public String getFiltroComercioBarrio() {
        return filtroComercioBarrio;
    }

    public void setFiltroComercioBarrio(String filtroComercioBarrio) {
        this.filtroComercioBarrio = filtroComercioBarrio;
    }

    public String getFiltroComercioDireccion() {
        return filtroComercioDireccion;
    }

    public void setFiltroComercioDireccion(String filtroComercioDireccion) {
        this.filtroComercioDireccion = filtroComercioDireccion;
    }

    public String getFiltroComercioCedula() {
        return filtroComercioCedula;
    }

    public void setFiltroComercioCedula(String filtroComercioCedula) {
        this.filtroComercioCedula = filtroComercioCedula;
    }

    public List<String> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<String> barrios) {
        this.barrios = barrios;
    }  
}
