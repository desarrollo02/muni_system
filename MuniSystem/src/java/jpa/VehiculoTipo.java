/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "vehiculo_tipo")
@NamedQueries({
    @NamedQuery(name = "VehiculoTipo.findAll", query = "SELECT v FROM VehiculoTipo v")})
public class VehiculoTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipo")
    private List<VehiculoValuacion> vehiculoValuacionList;
    @OneToMany(mappedBy = "idTipo")
    private List<Vehiculo> vehiculoList;

    public VehiculoTipo() {
    }

    public VehiculoTipo(Integer idCategoria) {
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

    public List<VehiculoValuacion> getVehiculoValuacionList() {
        return vehiculoValuacionList;
    }

    public void setVehiculoValuacionList(List<VehiculoValuacion> vehiculoValuacionList) {
        this.vehiculoValuacionList = vehiculoValuacionList;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
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
        if (!(object instanceof VehiculoTipo)) {
            return false;
        }
        VehiculoTipo other = (VehiculoTipo) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.VehiculoTipo[ idCategoria=" + idCategoria + " ]";
    }
    
}
