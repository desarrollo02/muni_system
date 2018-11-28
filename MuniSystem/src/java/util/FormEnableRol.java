package util;

public class FormEnableRol {
    
    private boolean nombre;
    private boolean pantalla;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCancelar;
    private boolean botonGuardar;
    private boolean botonEliminar;
    
    public void inicio(){
        setNombre(false);
        setPantalla(false);
        setBotonNuevo(true);
        setBotonBuscar(true);
        setBotonEditar(false);
        setBotonCancelar(false);
        setBotonGuardar(false);
        setBotonEliminar(false);
    }
    
    public void nuevo(){
        setNombre(true);
        setPantalla(true);
        setBotonNuevo(false);
        setBotonBuscar(false);
        setBotonEditar(false);
        setBotonCancelar(true);
        setBotonGuardar(true);
        setBotonEliminar(false);
    }
    
    public void editar(){
        setNombre(true);
        setPantalla(true);
        setBotonNuevo(false);
        setBotonBuscar(true);
        setBotonEditar(false);
        setBotonCancelar(true);
        setBotonGuardar(true);
        setBotonEliminar(false);
    }
    
    public void ver(){
        setNombre(false);
        setPantalla(false);
        setBotonNuevo(false);
        setBotonBuscar(true);
        setBotonEditar(true);
        setBotonCancelar(true);
        setBotonGuardar(false);
        setBotonEliminar(true);
    }

    public boolean isNombre() {
        return nombre;
    }

    public void setNombre(boolean nombre) {
        this.nombre = nombre;
    }

    public boolean isPantalla() {
        return pantalla;
    }

    public void setPantalla(boolean pantalla) {
        this.pantalla = pantalla;
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
