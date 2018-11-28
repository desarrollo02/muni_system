package util;

public class FormEnableCementerio {
    private boolean rmc;
    private boolean nroLote;
    private boolean valuacion;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCancelar;
    private boolean botonEliminar;
    private boolean botonGuardar;
    private boolean botonBuscarContribuyente;
    
    public void inicio(){
        rmc=false;
        nroLote=false;
        valuacion=false;
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
        nroLote=true;
        valuacion=true;
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
        nroLote=true;
        valuacion=true;
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
        nroLote=false;
        valuacion=false;
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

    public boolean isNroLote() {
        return nroLote;
    }

    public void setNroLote(boolean nroLote) {
        this.nroLote = nroLote;
    }

    public boolean isValuacion() {
        return valuacion;
    }

    public void setValuacion(boolean valuacion) {
        this.valuacion = valuacion;
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
