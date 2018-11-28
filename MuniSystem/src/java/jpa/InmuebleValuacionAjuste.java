package jpa;

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

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "inmueble_valuacion_ajuste")
@NamedQueries({
    @NamedQuery(name = "InmuebleValuacionAjuste.findAll", query = "SELECT i FROM InmuebleValuacionAjuste i")})
public class InmuebleValuacionAjuste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inmueble_valuacion")
    private Integer idInmuebleValuacion;
    @Column(name = "porcentaje_ajuste")
    private Integer porcentajeAjuste;
    @Column(name = "anio")
    private Integer anio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_nuevo_monto")
    private Double valorNuevoMonto;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "valor_viejo_monto")
    private Double valorViejoMonto;
    @JoinColumn(name = "id_inmueble", referencedColumnName = "id_inmueble")
    @ManyToOne
    private Inmueble idInmueble;

    public InmuebleValuacionAjuste() {
    }

    public InmuebleValuacionAjuste(Integer idInmuebleValuacion) {
        this.idInmuebleValuacion = idInmuebleValuacion;
    }

    public Integer getIdInmuebleValuacion() {
        return idInmuebleValuacion;
    }

    public void setIdInmuebleValuacion(Integer idInmuebleValuacion) {
        this.idInmuebleValuacion = idInmuebleValuacion;
    }

    public Integer getPorcentajeAjuste() {
        return porcentajeAjuste;
    }

    public void setPorcentajeAjuste(Integer porcentajeAjuste) {
        this.porcentajeAjuste = porcentajeAjuste;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getValorNuevoMonto() {
        return valorNuevoMonto;
    }

    public void setValorNuevoMonto(Double valorNuevoMonto) {
        this.valorNuevoMonto = valorNuevoMonto;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Double getValorViejoMonto() {
        return valorViejoMonto;
    }

    public void setValorViejoMonto(Double valorViejoMonto) {
        this.valorViejoMonto = valorViejoMonto;
    }

    public Inmueble getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Inmueble idInmueble) {
        this.idInmueble = idInmueble;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInmuebleValuacion != null ? idInmuebleValuacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InmuebleValuacionAjuste)) {
            return false;
        }
        InmuebleValuacionAjuste other = (InmuebleValuacionAjuste) object;
        if ((this.idInmuebleValuacion == null && other.idInmuebleValuacion != null) || (this.idInmuebleValuacion != null && !this.idInmuebleValuacion.equals(other.idInmuebleValuacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.InmuebleValuacionAjuste[ idInmuebleValuacion=" + idInmuebleValuacion + " ]";
    }
    
}
