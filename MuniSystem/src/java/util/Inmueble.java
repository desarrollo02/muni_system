package util;

import jpa.Contribuyente;

public class Inmueble {
    
    private Integer clave;
    private Integer idInmueble;
    private String tipo;
    private Contribuyente contribuyente;
    private Integer padron;
    private String ctaCte;
    private Integer hectareas;
    private Integer supM2;
    private Double supEdificadaM2;
    private Integer zona;
    private Integer manzana;
    private Integer lote;
    private Integer piso;
    private Integer salon;
    private Integer calle1;
    private Integer calle2;
    private Integer calle3;
    private Integer calle4;
    
    public Inmueble(){
    
    }

    public Inmueble(Integer clave, Integer idInmueble, String tipo, Contribuyente contribuyente, Integer padron, String ctaCte) {
        this.clave = clave;
        this.idInmueble = idInmueble;
        this.tipo = tipo;
        this.contribuyente = contribuyente;
        this.padron = padron;
        this.ctaCte = ctaCte;
    }
    
    

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public Integer getPadron() {
        return padron;
    }

    public void setPadron(Integer padron) {
        this.padron = padron;
    }

    public String getCtaCte() {
        return ctaCte;
    }

    public void setCtaCte(String ctaCte) {
        this.ctaCte = ctaCte;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Integer getHectareas() {
        return hectareas;
    }

    public void setHectareas(Integer hectareas) {
        this.hectareas = hectareas;
    }

    public Integer getSupM2() {
        return supM2;
    }

    public void setSupM2(Integer supM2) {
        this.supM2 = supM2;
    }

    public Double getSupEdificadaM2() {
        return supEdificadaM2;
    }

    public void setSupEdificadaM2(Double supEdificadaM2) {
        this.supEdificadaM2 = supEdificadaM2;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
    }

    public Integer getManzana() {
        return manzana;
    }

    public void setManzana(Integer manzana) {
        this.manzana = manzana;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getSalon() {
        return salon;
    }

    public void setSalon(Integer salon) {
        this.salon = salon;
    }

    public Integer getCalle1() {
        return calle1;
    }

    public void setCalle1(Integer calle1) {
        this.calle1 = calle1;
    }

    public Integer getCalle2() {
        return calle2;
    }

    public void setCalle2(Integer calle2) {
        this.calle2 = calle2;
    }

    public Integer getCalle3() {
        return calle3;
    }

    public void setCalle3(Integer calle3) {
        this.calle3 = calle3;
    }

    public Integer getCalle4() {
        return calle4;
    }

    public void setCalle4(Integer calle4) {
        this.calle4 = calle4;
    }
}
