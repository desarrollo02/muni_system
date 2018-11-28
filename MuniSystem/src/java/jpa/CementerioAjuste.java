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
@Table(name = "cementerio_ajuste")
@NamedQueries({
    @NamedQuery(name = "CementerioAjuste.findAll", query = "SELECT c FROM CementerioAjuste c")})
public class CementerioAjuste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cementerio_ajuste")
    private Integer idCementerioAjuste;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "porcentaje_ajuste")
    private Integer porcentajeAjuste;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "valor_neuvo_monto")
    private Double valorNeuvoMonto;
    @Column(name = "valor_viejo_monto")
    private Double valorViejoMonto;
    @JoinColumn(name = "id_cementerio", referencedColumnName = "id_cementerio")
    @ManyToOne
    private Cementerio idCementerio;

    public CementerioAjuste() {
    }

    public CementerioAjuste(Integer idCementerioAjuste) {
        this.idCementerioAjuste = idCementerioAjuste;
    }

    public Integer getIdCementerioAjuste() {
        return idCementerioAjuste;
    }

    public void setIdCementerioAjuste(Integer idCementerioAjuste) {
        this.idCementerioAjuste = idCementerioAjuste;
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

    public Double getValorNeuvoMonto() {
        return valorNeuvoMonto;
    }

    public void setValorNeuvoMonto(Double valorNeuvoMonto) {
        this.valorNeuvoMonto = valorNeuvoMonto;
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
        hash += (idCementerioAjuste != null ? idCementerioAjuste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CementerioAjuste)) {
            return false;
        }
        CementerioAjuste other = (CementerioAjuste) object;
        if ((this.idCementerioAjuste == null && other.idCementerioAjuste != null) || (this.idCementerioAjuste != null && !this.idCementerioAjuste.equals(other.idCementerioAjuste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.CementerioAjuste[ idCementerioAjuste=" + idCementerioAjuste + " ]";
    }

    /**
     * @return the idCementerio
     */
    public Cementerio getIdCementerio() {
        return idCementerio;
    }

    /**
     * @param idCementerio the idCementerio to set
     */
    public void setIdCementerio(Cementerio idCementerio) {
        this.idCementerio = idCementerio;
    }
    
}
