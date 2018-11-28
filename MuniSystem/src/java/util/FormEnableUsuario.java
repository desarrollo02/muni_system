package util;

public class FormEnableUsuario {
    
    private boolean desc;
    private boolean cedula;
    private boolean nombres;
    private boolean apellidos;
    private boolean rol;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCancelar;
    private boolean botonGuardar;
    private boolean botonEliminar;
    
    public void inicio(){
        setDesc(false);
        setCedula(false);
        setNombres(false);
        setApellidos(false);
        setRol(false);
        setBotonNuevo(true);
        setBotonBuscar(true);
        setBotonEditar(false);
        
        setBotonCancelar(false);
        setBotonGuardar(false);
        setBotonEliminar(false);
    }
    
    public void nuevo(){
        setDesc(true);
        setCedula(true);
        setNombres(true);
        setApellidos(true);
        setRol(true);
        setBotonNuevo(false);
        setBotonBuscar(false);
        setBotonEditar(false);
        setBotonCancelar(true);
        setBotonGuardar(true);
        setBotonEliminar(false);
    }
    
    public void editar(){
        setDesc(true);
        setCedula(true);
        setNombres(true);
        setApellidos(true);
        setRol(true);
        setBotonNuevo(false);
        setBotonBuscar(true);
        setBotonEditar(false);
        setBotonCancelar(true);
        setBotonGuardar(true);
        setBotonEliminar(false);
    }
    
    public void ver(){
        setDesc(false);
        setCedula(false);
        setNombres(false);
        setApellidos(false);
        setRol(false);
        setBotonNuevo(false);
        setBotonBuscar(true);
        setBotonEditar(true);
        setBotonCancelar(true);
        setBotonGuardar(false);
        setBotonEliminar(true);
    }

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    public boolean isCedula() {
        return cedula;
    }

    public void setCedula(boolean cedula) {
        this.cedula = cedula;
    }

    public boolean isNombres() {
        return nombres;
    }

    public void setNombres(boolean nombres) {
        this.nombres = nombres;
    }

    public boolean isApellidos() {
        return apellidos;
    }

    public void setApellidos(boolean apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public boolean isBotonNuevo() {
        return botonNuevo;
    }

    public void setBotonNuevo(boolean botonNuevo) {
        this.botonNuevo = botonNuevo;
    }

    public boolean isBotonBuscar() {
        return botonBuscar;
    }

    public void setBotonBuscar(boolean botonBuscar) {
        this.botonBuscar = botonBuscar;
    }

    public boolean isBotonEditar() {
        return botonEditar;
    }

    public void setBotonEditar(boolean botonEditar) {
        this.botonEditar = botonEditar;
    }

    public boolean isBotonCancelar() {
        return botonCancelar;
    }

    public void setBotonCancelar(boolean botonCancelar) {
        this.botonCancelar = botonCancelar;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }

    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }
}
