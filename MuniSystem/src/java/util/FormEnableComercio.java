package util;

public class FormEnableComercio {
    private boolean rmc;
    private boolean rubro;
    private boolean nombre;
    private boolean nroPatente;
    private boolean barrio;
    private boolean direccion;
    private boolean valorActivo;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCancelar;
    private boolean botonEliminar;
    private boolean botonGuardar;
    private boolean botonBuscarContribuyente;
    
    public void inicio(){
        rmc=false;
        rubro=false;
        nombre=false;
        nroPatente=false;
        barrio=false;
        direccion=false;
        valorActivo=false;
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
        rubro=true;
        nombre=true;
        nroPatente=true;
        barrio=true;
        direccion=true;
        valorActivo=true;
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
        rubro=true;
        nombre=true;
        nroPatente=true;
        barrio=true;
        direccion=true;
        valorActivo=true;
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
        rubro=false;
        nombre=false;
        nroPatente=false;
        barrio=false;
        direccion=false;
        valorActivo=false;
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

    public boolean isRubro() {
        return rubro;
    }

    public void setRubro(boolean rubro) {
        this.rubro = rubro;
    }

    public boolean isNombre() {
        return nombre;
    }

    public void setNombre(boolean nombre) {
        this.nombre = nombre;
    }

    public boolean isNroPatente() {
        return nroPatente;
    }

    public void setNroPatente(boolean nroPatente) {
        this.nroPatente = nroPatente;
    }

    public boolean isBarrio() {
        return barrio;
    }

    public void setBarrio(boolean barrio) {
        this.barrio = barrio;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public boolean isValorActivo() {
        return valorActivo;
    }

    public void setValorActivo(boolean valorActivo) {
        this.valorActivo = valorActivo;
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
