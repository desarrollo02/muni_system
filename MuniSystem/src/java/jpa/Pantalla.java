/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author diaz
 */
@Entity
@Table(name = "pantalla")
@NamedQueries({
    @NamedQuery(name = "Pantalla.findAll", query = "SELECT p FROM Pantalla p")})
public class Pantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pantalla")
    private Integer idPantalla;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "url")
    private String url;

    public Pantalla() {
    }

    public Pantalla(Integer idPantalla) {
        this.idPantalla = idPantalla;
    }

    public Integer getIdPantalla() {
        return idPantalla;
    }

    public void setIdPantalla(Integer idPantalla) {
        this.idPantalla = idPantalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPantalla != null ? idPantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalla)) {
            return false;
        }
        Pantalla other = (Pantalla) object;
        if ((this.idPantalla == null && other.idPantalla != null) || (this.idPantalla != null && !this.idPantalla.equals(other.idPantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Pantalla[ idPantalla=" + idPantalla + " ]";
    }
    
}
