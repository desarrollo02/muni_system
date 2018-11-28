package jpa;

import java.io.Serializable;
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

@Entity
@Table(name = "tributo_detalle")
@NamedQueries({
    @NamedQuery(name = "TributoDetalle.findAll", query = "SELECT t FROM TributoDetalle t")})
public class TributoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tributo_detalle")
    private Integer idTributoDetalle;
    @JoinColumn(name = "id_tributo_base", referencedColumnName = "id_tributo")
    @ManyToOne
    private Tributo idTributoBase;
    @JoinColumn(name = "id_tributo_agregado", referencedColumnName = "id_tributo")
    @ManyToOne
    private Tributo idTributoAgregado;

    public TributoDetalle() {
    }

    public TributoDetalle(Integer idTributoDetalle) {
        this.idTributoDetalle = idTributoDetalle;
    }

    public Integer getIdTributoDetalle() {
        return idTributoDetalle;
    }

    public void setIdTributoDetalle(Integer idTributoDetalle) {
        this.idTributoDetalle = idTributoDetalle;
    }

    public Tributo getIdTributoBase() {
        return idTributoBase;
    }

    public void setIdTributoBase(Tributo idTributoBase) {
        this.idTributoBase = idTributoBase;
    }

    public Tributo getIdTributoAgregado() {
        return idTributoAgregado;
    }

    public void setIdTributoAgregado(Tributo idTributoAgregado) {
        this.idTributoAgregado = idTributoAgregado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTributoDetalle != null ? idTributoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TributoDetalle)) {
            return false;
        }
        TributoDetalle other = (TributoDetalle) object;
        if ((this.idTributoDetalle == null && other.idTributoDetalle != null) || (this.idTributoDetalle != null && !this.idTributoDetalle.equals(other.idTributoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TributoDetalle[ idTributoDetalle=" + idTributoDetalle + " ]";
    }
    
}
