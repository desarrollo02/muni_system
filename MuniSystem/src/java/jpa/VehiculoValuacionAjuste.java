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

@Entity
@Table(name = "vehiculo_valuacion_ajuste")
@NamedQueries({
    @NamedQuery(name = "VehiculoValuacionAjuste.findAll", query = "SELECT v FROM VehiculoValuacionAjuste v")})
public class VehiculoValuacionAjuste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_valuacion_ajuste")
    private Integer idVehiculoValuacionAjuste;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "porcentaje_ajuste")
    private Integer porcentajeAjuste;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "valor_nuevo_monto")
    private Double valorNuevoMonto;
    @Column(name = "valor_viejo_monto")
    private Double valorViejoMonto;
    @JoinColumn(name = "id_vehiculo_valuacion", referencedColumnName = "id_automotor_valuacion")
    @ManyToOne
    private VehiculoValuacion idVehiculoValuacion;

    public VehiculoValuacionAjuste() {
    }

    public VehiculoValuacionAjuste(Integer idVehiculoValuacionAjuste) {
        this.idVehiculoValuacionAjuste = idVehiculoValuacionAjuste;
    }

    public Integer getIdVehiculoValuacionAjuste() {
        return idVehiculoValuacionAjuste;
    }

    public void setIdVehiculoValuacionAjuste(Integer idVehiculoValuacionAjuste) {
        this.idVehiculoValuacionAjuste = idVehiculoValuacionAjuste;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getPorcentajeAjuste() {
        return porcentajeAjuste;
    }

    public void setPorcentajeAjuste(Integer porcentajeAjuste) {
        this.porcentajeAjuste = porcentajeAjuste;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Double getValorNuevoMonto() {
        return valorNuevoMonto;
    }

    public void setValorNuevoMonto(Double valorNuevoMonto) {
        this.valorNuevoMonto = valorNuevoMonto;
    }

    public Double getValorViejoMonto() {
        return valorViejoMonto;
    }

    public void setValorViejoMonto(Double valorViejoMonto) {
        this.valorViejoMonto = valorViejoMonto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculoValuacionAjuste != null ? idVehiculoValuacionAjuste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoValuacionAjuste)) {
            return false;
        }
        VehiculoValuacionAjuste other = (VehiculoValuacionAjuste) object;
        if ((this.idVehiculoValuacionAjuste == null && other.idVehiculoValuacionAjuste != null) || (this.idVehiculoValuacionAjuste != null && !this.idVehiculoValuacionAjuste.equals(other.idVehiculoValuacionAjuste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.VehiculoValuacionAjuste[ idVehiculoValuacionAjuste=" + idVehiculoValuacionAjuste + " ]";
    }

    /**
     * @return the idVehiculoValuacion
     */
    public VehiculoValuacion getIdVehiculoValuacion() {
        return idVehiculoValuacion;
    }

    /**
     * @param idVehiculoValuacion the idVehiculoValuacion to set
     */
    public void setIdVehiculoValuacion(VehiculoValuacion idVehiculoValuacion) {
        this.idVehiculoValuacion = idVehiculoValuacion;
    }
    
}
