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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author diaz
 */
@Entity
@Table(name = "tipo_comprobante")
@NamedQueries({
    @NamedQuery(name = "TipoComprobante.findAll", query = "SELECT t FROM TipoComprobante t")})
public class TipoComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_comprobante")
    private Integer idTipoComprobante;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoComprobante() {
    }

    public TipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
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
        hash += (idTipoComprobante != null ? idTipoComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobante)) {
            return false;
        }
        TipoComprobante other = (TipoComprobante) object;
        if ((this.idTipoComprobante == null && other.idTipoComprobante != null) || (this.idTipoComprobante != null && !this.idTipoComprobante.equals(other.idTipoComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TipoComprobante[ idTipoComprobante=" + idTipoComprobante + " ]";
    }
    
}
