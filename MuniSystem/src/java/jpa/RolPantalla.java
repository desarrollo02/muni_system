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

/**
 *
 * @author diaz
 */
@Entity
@Table(name = "rol_pantalla")
@NamedQueries({
    @NamedQuery(name = "RolPantalla.findAll", query = "SELECT r FROM RolPantalla r")})
public class RolPantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol_pantalla")
    private Integer idRolPantalla;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol idRol;
    @JoinColumn(name = "id_pantalla", referencedColumnName = "id_pantalla")
    @ManyToOne
    private Pantalla idPantalla;
    @Column(name = "alta")
    private boolean alta;
    @Column(name = "editar")
    private boolean editar;
    @Column(name = "consultar")
    private boolean consultar;
    @Column(name = "eliminar")
    private boolean eliminar;

    public RolPantalla() {
    }

    public RolPantalla(Integer idRolPantalla) {
        this.idRolPantalla = idRolPantalla;
    }

    public Integer getIdRolPantalla() {
        return idRolPantalla;
    }

    public void setIdRolPantalla(Integer idRolPantalla) {
        this.idRolPantalla = idRolPantalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolPantalla != null ? idRolPantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPantalla)) {
            return false;
        }
        RolPantalla other = (RolPantalla) object;
        if ((this.idRolPantalla == null && other.idRolPantalla != null) || (this.idRolPantalla != null && !this.idRolPantalla.equals(other.idRolPantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.RolPantalla[ idRolPantalla=" + idRolPantalla + " ]";
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Pantalla getIdPantalla() {
        return idPantalla;
    }

    public void setIdPantalla(Pantalla idPantalla) {
        this.idPantalla = idPantalla;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }
    
}
