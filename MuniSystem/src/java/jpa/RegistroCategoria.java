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
@Table(name = "registro_categoria")
@NamedQueries({
    @NamedQuery(name = "RegistroCategoria.findAll", query = "SELECT r FROM RegistroCategoria r")})
public class RegistroCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idCategoria")
    private List<RegistroConducir> registroConducirList;
    @Column(name = "monto")
    private Double monto;

    public RegistroCategoria() {
    }

    public RegistroCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<RegistroConducir> getRegistroConducirList() {
        return registroConducirList;
    }

    public void setRegistroConducirList(List<RegistroConducir> registroConducirList) {
        this.registroConducirList = registroConducirList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroCategoria)) {
            return false;
        }
        RegistroCategoria other = (RegistroCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.RegistroCategoria[ idCategoria=" + idCategoria + " ]";
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
}
