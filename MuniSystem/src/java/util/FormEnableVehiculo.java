package util;

public class FormEnableVehiculo {
    
    private boolean rmc;
    private boolean chapa;
    private boolean anio;
    private boolean tipo;
    private boolean marca;
    private boolean modelo;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCancelar;
    private boolean botonEliminar;
    private boolean botonGuardar;
    private boolean botonBuscarContribuyente;
    
    public void inicio(){
        rmc=false;
        chapa=false;
        anio=false;
        tipo=false;
        marca=false;
        modelo=false;
        botonNuevo=true;
        botonBuscar=true;
        botonEditar=false;
        botonCancelar=false;
        botonEliminar=false;
        botonGuardar=false;
        botonBuscarContribuyente=false;
    }
    
    public void nuevo(){
        rmc=true;
        chapa=true;
        anio=true;
        tipo=true;
        marca=true;
        modelo=true;
        botonNuevo=false;
        botonBuscar=false;
        botonEditar=false;
        botonCancelar=true;
        botonEliminar=false;
        botonGuardar=true;
        botonBuscarContribuyente=true;
    }
    
    public void editar(){
        rmc=true;
        chapa=true;
        anio=true;
        tipo=true;
        marca=true;
        modelo=true;
        botonNuevo=false;
        botonBuscar=false;
        botonEditar=false;
        botonCancelar=true;
        botonEliminar=true;
        botonGuardar=true;
        botonBuscarContribuyente=false;
    }
    
    public void selecionado(){
        rmc=false;
        chapa=false;
        anio=false;
        tipo=false;
        marca=false;
        modelo=false;
        botonNuevo=false;
        botonBuscar=true;
        botonEditar=true;
        botonCancelar=true;
        botonEliminar=false;
        botonGuardar=false;
        botonBuscarContribuyente=false;
    }

    public boolean isRmc() {
        return rmc;
    }

    public void setRmc(boolean rmc) {
        this.rmc = rmc;
    }

    public boolean isChapa() {
        return chapa;
    }

    public void setChapa(boolean chapa) {
        this.chapa = chapa;
    }

    public boolean isAnio() {
        return anio;
    }

    public void setAnio(boolean anio) {
        this.anio = anio;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isMarca() {
        return marca;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }

    public boolean isModelo() {
        return modelo;
    }

    public void setModelo(boolean modelo) {
        this.modelo = modelo;
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

    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }

    public boolean isBotonBuscarContribuyente() {
        return botonBuscarContribuyente;
    }

    public void setBotonBuscarContribuyente(boolean botonBuscarContribuyente) {
        this.botonBuscarContribuyente = botonBuscarContribuyente;
    }
    
}
