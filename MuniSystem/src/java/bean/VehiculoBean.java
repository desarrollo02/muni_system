package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Contribuyente;
import jpa.Vehiculo;
import manager.ContribuyenteManager;
import manager.VehiculoManager;
import util.FormEnableVehiculo;

@ManagedBean(name = "vehiculoBean")
@SessionScoped
public class VehiculoBean extends MensajeBean implements Serializable {

    private FormEnableVehiculo formEnable;
    private VehiculoManager manager;
    private Vehiculo vehiculo;
    private Vehiculo vehiculoSelect;
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
    private List<Vehiculo> resultFiltroVehiculoList;
    private Integer filtroVehiculoRmc;
    private String filtroVehiculoCedula;
    private String filtroVehiculoChapa;
    private Integer filtroVehiculoAnio;
    private String filtroVehiculoTipo;
    private String filtroVehiculoMarca;
    private String filtroVehiculoModelo;
    private List<String> tipos;
    private List<String> marcas;
    private List<String> modelos;
    
    @PostConstruct
    public void init(){
        setManager(new VehiculoManager());
        setManagerContribuyente(new ContribuyenteManager());
        setFormEnable(new FormEnableVehiculo());
        tipos = getManager().getDescripcionTipoList();
        marcas = getManager().getDescripcionMarcaList();
        modelos = getManager().getDescripcionModeloList();
    }
    
    public String irVista(){
        inicio();
        return "vehiculo";
    }
    
    private void inicio(){
        getFormEnable().inicio();
        vehiculo = new Vehiculo();
    }
    
    public void nuevo(ActionEvent evento){
        getFormEnable().nuevo();
        vehiculo = new Vehiculo();
        vehiculo.setIdContribuyente(new Contribuyente());
    }
    
    public void cancelar(ActionEvent evento){
        inicio();
    }
    
    public void eliminar(ActionEvent evento){
        getManager().eliminar(vehiculo);
        inicio();
        super.mensajeExito("Datos Eliminados");
    }
    
    public void guardar(ActionEvent evento){
        if(vehiculo.getIdVehiculo() == null){
            guardarNuevo();
        }else{
            guardarCambios();
        }
    }
    
    private void guardarNuevo(){
        if(isValidoCampos()){    
            if(getManager().existeChapa(vehiculo)){
                super.mensajeError("La chapa ya existe");
            }else{
                vehiculo.setFechaAlta(new Date());
                getManager().guardar(vehiculo);
                inicio();
                super.mensajeExito("Datos Guardados");
            }
        }
    }
    
    private boolean isValidoCampos(){
        boolean valido=true;
        if(vehiculo.getChapa() == null || vehiculo.getChapa().equals("")){
            valido=false;
            super.mensajeError("Debe ingresar chapa del vhiculo");              
        }
        if(vehiculo.getAnio() == null ||  vehiculo.getAnio() <= 0){
            valido=false;
            super.mensajeError("Debe ingresar año del vehiculo");
        }
       
        return valido;
    }
    
    private void guardarCambios(){
        
        if(isValidoCampos()){    
            if(getManager().existeChapa(vehiculo)){
                super.mensajeError("La chapa ya existe");
            }else{ 
                getManager().actualizar(vehiculo);
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
            vehiculo.setIdContribuyente(getContribuyente());
        }     
    }
    
    public void aceptarSelect(ActionEvent ev){      
        if(vehiculoSelect != null){
            vehiculo = vehiculoSelect;
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
    
    public void filtrarVehiculo(ActionEvent evento){
        resultFiltroVehiculoList = getManager().filtrar(filtroVehiculoRmc, filtroVehiculoCedula, 
                filtroVehiculoChapa, filtroVehiculoTipo, filtroVehiculoMarca, 
                filtroVehiculoModelo);
    }
    
    public void todosVehiculo(ActionEvent evento){
        filtroVehiculoRmc=null;
        filtroVehiculoCedula=null;
        filtroVehiculoChapa=null;
        filtroVehiculoTipo=null;
        filtroVehiculoMarca=null;
        filtroVehiculoModelo=null;
        resultFiltroVehiculoList = getManager().filtrar(filtroVehiculoRmc, filtroVehiculoCedula, 
                filtroVehiculoChapa, filtroVehiculoTipo, filtroVehiculoMarca, 
                filtroVehiculoModelo);
    }
    
    public VehiculoBean() {
    }

    public FormEnableVehiculo getFormEnable() {
        return formEnable;
    }

    public void setFormEnable(FormEnableVehiculo formEnable) {
        this.formEnable = formEnable;
    }

    public VehiculoManager getManager() {
        return manager;
    }

    public void setManager(VehiculoManager manager) {
        this.manager = manager;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculoSelect() {
        return vehiculoSelect;
    }

    public void setVehiculoSelect(Vehiculo vehiculoSelect) {
        this.vehiculoSelect = vehiculoSelect;
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

    public List<Vehiculo> getResultFiltroVehiculoList() {
        return resultFiltroVehiculoList;
    }

    public void setResultFiltroVehiculoList(List<Vehiculo> resultFiltroVehiculoList) {
        this.resultFiltroVehiculoList = resultFiltroVehiculoList;
    }

    public Integer getFiltroVehiculoRmc() {
        return filtroVehiculoRmc;
    }

    public void setFiltroVehiculoRmc(Integer filtroVehiculoRmc) {
        this.filtroVehiculoRmc = filtroVehiculoRmc;
    }

    public String getFiltroVehiculoCedula() {
        return filtroVehiculoCedula;
    }

    public void setFiltroVehiculoCedula(String filtroVehiculoCedula) {
        this.filtroVehiculoCedula = filtroVehiculoCedula;
    }

    public String getFiltroVehiculoChapa() {
        return filtroVehiculoChapa;
    }

    public void setFiltroVehiculoChapa(String filtroVehiculoChapa) {
        this.filtroVehiculoChapa = filtroVehiculoChapa;
    }

    public Integer getFiltroVehiculoAnio() {
        return filtroVehiculoAnio;
    }

    public void setFiltroVehiculoAnio(Integer filtroVehiculoAnio) {
        this.filtroVehiculoAnio = filtroVehiculoAnio;
    }

    public String getFiltroVehiculoTipo() {
        return filtroVehiculoTipo;
    }

    public void setFiltroVehiculoTipo(String filtroVehiculoTipo) {
        this.filtroVehiculoTipo = filtroVehiculoTipo;
    }

    public String getFiltroVehiculoMarca() {
        return filtroVehiculoMarca;
    }

    public void setFiltroVehiculoMarca(String filtroVehiculoMarca) {
        this.filtroVehiculoMarca = filtroVehiculoMarca;
    }

    public String getFiltroVehiculoModelo() {
        return filtroVehiculoModelo;
    }

    public void setFiltroVehiculoModelo(String filtroVehiculoModelo) {
        this.filtroVehiculoModelo = filtroVehiculoModelo;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public List<String> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<String> marcas) {
        this.marcas = marcas;
    }

    public List<String> getModelos() {
        return modelos;
    }

    public void setModelos(List<String> modelos) {
        this.modelos = modelos;
    }
    
}
