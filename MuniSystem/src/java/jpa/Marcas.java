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
@Table(name = "marcas")
@NamedQueries({
    @NamedQuery(name = "Marcas.findAll", query = "SELECT m FROM Marcas m")})
public class Marcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca")
    private Integer idMarca;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idMarca")
    private List<VehiculoValuacion> vehiculoValuacionList;
    @OneToMany(mappedBy = "idMarca")
    private List<Vehiculo> vehiculoList;
    @OneToMany(mappedBy = "idMarca")
    private List<Modelos> modelosList;

    public Marcas() {
    }

    public Marcas(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
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

    public List<Modelos> getModelosList() {
        return modelosList;
    }

    public void setModelosList(List<Modelos> modelosList) {
        this.modelosList = modelosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcas)) {
            return false;
        }
        Marcas other = (Marcas) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Marcas[ idMarca=" + idMarca + " ]";
    }
    
}
