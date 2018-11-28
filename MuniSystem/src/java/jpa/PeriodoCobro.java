package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author diaz
 */
@Entity
@Table(name = "periodo_cobro")
@NamedQueries({
    @NamedQuery(name = "PeriodoCobro.findAll", query = "SELECT p FROM PeriodoCobro p")})
public class PeriodoCobro implements Serializable {

    @OneToMany(mappedBy = "idPeriodoCobro")
    private List<Tributo> tributoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodo_cobro")
    private Integer idPeriodoCobro;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private Integer valor;

    public PeriodoCobro() {
    }

    public PeriodoCobro(Integer idPeriodoCobro) {
        this.idPeriodoCobro = idPeriodoCobro;
    }

    public Integer getIdPeriodoCobro() {
        return idPeriodoCobro;
    }

    public void setIdPeriodoCobro(Integer idPeriodoCobro) {
        this.idPeriodoCobro = idPeriodoCobro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodoCobro != null ? idPeriodoCobro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoCobro)) {
            return false;
        }
        PeriodoCobro other = (PeriodoCobro) object;
        if ((this.idPeriodoCobro == null && other.idPeriodoCobro != null) || (this.idPeriodoCobro != null && !this.idPeriodoCobro.equals(other.idPeriodoCobro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.PeriodoCobro[ idPeriodoCobro=" + idPeriodoCobro + " ]";
    }

    public List<Tributo> getTributoList() {
        return tributoList;
    }

    public void setTributoList(List<Tributo> tributoList) {
        this.tributoList = tributoList;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
}
