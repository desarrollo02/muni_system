package util;

public class FormEnableRegistro {
    
    private boolean rmc;
    private boolean categoria;
    private boolean registroNro;
    private boolean grupoSangre;
    private boolean vencimiento;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCancelar;
    private boolean botonEliminar;
    private boolean botonGuardar;
    private boolean botonBuscarContribuyente;
    
    public void inicio(){
        setRmc(false);
        setCategoria(false);
        setRegistroNro(false);
        setGrupoSangre(false);
        setVencimiento(false);
        setBotonNuevo(true);
        setBotonBuscar(true);
        setBotonEditar(false);
        setBotonCancelar(false);
        setBotonEliminar(false);
        setBotonGuardar(false);
        setBotonBuscarContribuyente(false);
    }
    
    public void nuevo(){
        setRmc(true);
        setCategoria(true);
        setRegistroNro(true);
        setGrupoSangre(true);
        setVencimiento(true);
        setBotonNuevo(false);
        setBotonBuscar(false);
        setBotonEditar(false);
        setBotonCancelar(true);
        setBotonEliminar(false);
        setBotonGuardar(true);
        setBotonBuscarContribuyente(true);
    }
    
    public void editar(){
        setRmc(true);
        setCategoria(true);
        setRegistroNro(true);
        setGrupoSangre(true);
        setVencimiento(true);
        setBotonNuevo(false);
        setBotonBuscar(false);
        setBotonEditar(false);
        setBotonCancelar(true);
        setBotonEliminar(true);
        setBotonGuardar(true);
        setBotonBuscarContribuyente(false);
    }
    
    public void selecionado(){
        setRmc(false);
        setCategoria(false);
        setRegistroNro(false);
        setGrupoSangre(false);
        setVencimiento(false);
        setBotonNuevo(false);
        setBotonBuscar(true);
        setBotonEditar(true);
        setBotonCancelar(true);
        setBotonEliminar(false);
        setBotonGuardar(false);
        setBotonBuscarContribuyente(false);
    }

    public boolean isRmc() {
        return rmc;
    }

    public void setRmc(boolean rmc) {
        this.rmc = rmc;
    }

    public boolean isCategoria() {
        return categoria;
    }

    public void setCategoria(boolean categoria) {
        this.categoria = categoria;
    }

    public boolean isRegistroNro() {
        return registroNro;
    }

    public void setRegistroNro(boolean registroNro) {
        this.registroNro = registroNro;
    }

    public boolean isGrupoSangre() {
        return grupoSangre;
    }

    public void setGrupoSangre(boolean grupoSangre) {
        this.grupoSangre = grupoSangre;
    }

    public boolean isVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(boolean vencimiento) {
        this.vencimiento = vencimiento;
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
