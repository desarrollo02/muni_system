package jpa;

import factura.BaseCalculo;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cementerio")
@NamedQueries({
    @NamedQuery(name = "Cementerio.findAll", query = "SELECT c FROM Cementerio c")})
public class Cementerio implements Serializable, BaseCalculo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cementerio")
    private Integer idCementerio;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecAlta;
    @Column(name = "fec_modif")
    @Temporal(TemporalType.DATE)
    private Date fecModif;
    @Column(name = "nro_lote")
    private Integer nroLote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valuacion")
    private Double valuacion;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @JoinColumn(name = "id_ubicacion_cementerio", referencedColumnName = "id_ubicacion_cementerio")
    @ManyToOne
    private UbicacionCementerio idUbicacionCementerio;
    @JoinColumn(name = "id_usu_alta", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuAlta;
    @JoinColumn(name = "id_usu_modif", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuModif;

    public Cementerio() {
    }

    public Cementerio(Integer idCementerio) {
        this.idCementerio = idCementerio;
    }

    public Integer getIdCementerio() {
        return idCementerio;
    }

    public void setIdCementerio(Integer idCementerio) {
        this.idCementerio = idCementerio;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecModif() {
        return fecModif;
    }

    public void setFecModif(Date fecModif) {
        this.fecModif = fecModif;
    }

    public Integer getNroLote() {
        return nroLote;
    }

    public void setNroLote(Integer nroLote) {
        this.nroLote = nroLote;
    }

    public Double getValuacion() {
        return valuacion;
    }

    public void setValuacion(Double valuacion) {
        this.valuacion = valuacion;
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public UbicacionCementerio getIdUbicacionCementerio() {
        return idUbicacionCementerio;
    }

    public void setIdUbicacionCementerio(UbicacionCementerio idUbicacionCementerio) {
        this.idUbicacionCementerio = idUbicacionCementerio;
    }

    public Usuario getIdUsuAlta() {
        return idUsuAlta;
    }

    public void setIdUsuAlta(Usuario idUsuAlta) {
        this.idUsuAlta = idUsuAlta;
    }

    public Usuario getIdUsuModif() {
        return idUsuModif;
    }

    public void setIdUsuModif(Usuario idUsuModif) {
        this.idUsuModif = idUsuModif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCementerio != null ? idCementerio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cementerio)) {
            return false;
        }
        Cementerio other = (Cementerio) object;
        if ((this.idCementerio == null && other.idCementerio != null) || (this.idCementerio != null && !this.idCementerio.equals(other.idCementerio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Cementerio[ idCementerio=" + idCementerio + " ]";
    }

    @Override
    public Double getValorBase() {
        return this.valuacion;
    }

    @Override
    public Integer getIdRef() {
        return this.idCementerio;
    }

    @Override
    public Contribuyente getTitular() {
        return this.getIdContribuyente();
    }

    @Override
    public String getDescripcionCalculo() {
        return "Cementerio: " + idUbicacionCementerio.getNombre() + ", Nro. Lote: " + nroLote; 
    }
    
}
