package jpa;

import factura.BaseCalculo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inmueble")
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i")})
public class Inmueble implements Serializable, BaseCalculo {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inmueble")
    private Integer idInmueble;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @Column(name = "nro_finca")
    private Integer nroFinca;
    @Size(max = 20)
    @Column(name = "cta_cte")
    private String ctaCte;
    @Column(name = "superficie")
    private Integer superficie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sup_edificada_m2")
    private Double supEdificadaM2;
    @Column(name = "valuacion_fiscal")
    private Double valuacionFiscal;
    @Column(name = "recoleccion_basura")
    private Boolean recoleccionBasura;
    @Column(name = "padron")
    private Integer padron;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 1)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "mantenimiento_pavimento")
    private Boolean mantenimientoPavimento;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @OneToMany(mappedBy = "idInmueble")
    private List<InmuebleValuacionAjuste> inmuebleValuacionAjusteList;

    public Inmueble() {
    }

    public Inmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getNroFinca() {
        return nroFinca;
    }

    public void setNroFinca(Integer nroFinca) {
        this.nroFinca = nroFinca;
    }

    public String getCtaCte() {
        return ctaCte;
    }

    public void setCtaCte(String ctaCte) {
        this.ctaCte = ctaCte;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public Double getSupEdificadaM2() {
        return supEdificadaM2;
    }

    public void setSupEdificadaM2(Double supEdificadaM2) {
        this.supEdificadaM2 = supEdificadaM2;
    }

    public Double getValuacionFiscal() {
        return valuacionFiscal;
    }

    public void setValuacionFiscal(Double valuacionFiscal) {
        this.valuacionFiscal = valuacionFiscal;
    }

    public Boolean getRecoleccionBasura() {
        return recoleccionBasura;
    }

    public void setRecoleccionBasura(Boolean recoleccionBasura) {
        this.recoleccionBasura = recoleccionBasura;
    }

    public Integer getPadron() {
        return padron;
    }

    public void setPadron(Integer padron) {
        this.padron = padron;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Boolean getMantenimientoPavimento() {
        return mantenimientoPavimento;
    }

    public void setMantenimientoPavimento(Boolean mantenimientoPavimento) {
        this.mantenimientoPavimento = mantenimientoPavimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInmueble != null ? idInmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.idInmueble == null && other.idInmueble != null) || (this.idInmueble != null && !this.idInmueble.equals(other.idInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Inmueble[ idInmueble=" + idInmueble + " ]";
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<InmuebleValuacionAjuste> getInmuebleValuacionAjusteList() {
        return inmuebleValuacionAjusteList;
    }

    public void setInmuebleValuacionAjusteList(List<InmuebleValuacionAjuste> inmuebleValuacionAjusteList) {
        this.inmuebleValuacionAjusteList = inmuebleValuacionAjusteList;
    }

    @Override
    public Double getValorBase() {
        return this.valuacionFiscal;
    }    

    @Override
    public Integer getIdRef() {
        return this.idInmueble;
    }

    @Override
    public Contribuyente getTitular() {
        return this.idContribuyente;
    }

    @Override
    public String getDescripcionCalculo() {
        String texto = "";
        if(this.ctaCte != null){
            texto ="Cta. Cte: " + ctaCte;
        }else if(this.padron != null){
            texto ="Nro. de Padron: " + padron;
        }else if(this.nroFinca != null){
            texto ="Nro. de Finca: "+ nroFinca.toString();
        }
        texto = texto + ", Valuacion:" + this.valuacionFiscal;
                
        return texto;
    }
}
