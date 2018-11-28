package util;

public class FormEnableInmueble {
    private boolean rmc;
    private boolean tipo;
    private boolean ctacte;
    private boolean padron;
    private boolean finca;
    private boolean superficie;
    private boolean unidadMedSup;
    private boolean supEdificada;
    private boolean valuacion;
    private boolean recoleccionBasura;
    private boolean mantPavimento;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCacelar;
    private boolean botonGuardar;
    private boolean botonEliminar;
    private boolean botonBuscarContribuyente;
    
    public void inicio(){
        FormEnableCampos(false, false, false, false, false, false, false, false, false, false, false);
        FormEnableBotones(true, true, false, false, false, false, false);
    }
    
    public void nuevo(){
        FormEnableCampos(true, true, true, true, true, true, true, true, true, true, true);
        FormEnableBotones(false, false, false, true, true, false, true);
    }
    
    public void editar(){
        FormEnableCampos(true, true, true, true, true, true, true, true, true, true, true);    
        FormEnableBotones(false, false, false, true, true, true, true);
    }
    
    public void FormEnableCampos(boolean rmc, boolean tipo, boolean ctacte, boolean padron, boolean finca, boolean superficie, boolean unidadMedSup, boolean supEdificada, boolean valuacion, boolean recoleccionBasura, boolean mantPavimento) {
        this.rmc = rmc;
        this.tipo = tipo;
        this.ctacte = ctacte;
        this.padron = padron;
        this.finca = finca;
        this.superficie = superficie;
        this.unidadMedSup = unidadMedSup;
        this.supEdificada = supEdificada;
        this.valuacion = valuacion;
        this.recoleccionBasura = recoleccionBasura;
        this.mantPavimento = mantPavimento;
    }

    public void FormEnableBotones(boolean botonNuevo, boolean botonBuscar, boolean botonEditar, boolean botonCacelar, boolean botonGuardar, boolean botonEliminar, boolean botonBuscarContribuyente) {
        this.botonNuevo = botonNuevo;
        this.botonBuscar = botonBuscar;
        this.botonEditar = botonEditar;
        this.botonCacelar = botonCacelar;
        this.botonGuardar = botonGuardar;
        this.botonEliminar = botonEliminar;
        this.botonBuscarContribuyente = botonBuscarContribuyente;
    }

    public boolean isRmc() {
        return rmc;
    }

    public void setRmc(boolean rmc) {
        this.rmc = rmc;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isCtacte() {
        return ctacte;
    }

    public void setCtacte(boolean ctacte) {
        this.ctacte = ctacte;
    }

    public boolean isPadron() {
        return padron;
    }

    public void setPadron(boolean padron) {
        this.padron = padron;
    }

    public boolean isFinca() {
        return finca;
    }

    public void setFinca(boolean finca) {
        this.finca = finca;
    }

    public boolean isSuperficie() {
        return superficie;
    }

    public void setSuperficie(boolean superficie) {
        this.superficie = superficie;
    }

    public boolean isUnidadMedSup() {
        return unidadMedSup;
    }

    public void setUnidadMedSup(boolean unidadMedSup) {
        this.unidadMedSup = unidadMedSup;
    }

    public boolean isSupEdificada() {
        return supEdificada;
    }

    public void setSupEdificada(boolean supEdificada) {
        this.supEdificada = supEdificada;
    }

    public boolean isValuacion() {
        return valuacion;
    }

    public void setValuacion(boolean valuacion) {
        this.valuacion = valuacion;
    }

    public boolean isRecoleccionBasura() {
        return recoleccionBasura;
    }

    public void setRecoleccionBasura(boolean recoleccionBasura) {
        this.recoleccionBasura = recoleccionBasura;
    }

    public boolean isMantPavimento() {
        return mantPavimento;
    }

    public void setMantPavimento(boolean mantPavimento) {
        this.mantPavimento = mantPavimento;
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

    public boolean isBotonCacelar() {
        return botonCacelar;
    }

    public void setBotonCacelar(boolean botonCacelar) {
        this.botonCacelar = botonCacelar;
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

    public boolean isBotonBuscarContribuyente() {
        return botonBuscarContribuyente;
    }

    public void setBotonBuscarContribuyente(boolean botonBuscarContribuyente) {
        this.botonBuscarContribuyente = botonBuscarContribuyente;
    }
    
    
}
