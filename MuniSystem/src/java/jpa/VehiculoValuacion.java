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
@Table(name = "vehiculo_valuacion")
@NamedQueries({
    @NamedQuery(name = "VehiculoValuacion.findAll", query = "SELECT v FROM VehiculoValuacion v")})
public class VehiculoValuacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_automotor_valuacion")
    private Integer idAutomotorValuacion;
    @Column(name = "anio")
    private Integer anio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marcas idMarca;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne
    private Modelos idModelo;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_categoria")
    @ManyToOne
    private VehiculoTipo idTipo;

    public VehiculoValuacion() {
    }

    public VehiculoValuacion(Integer idAutomotorValuacion) {
        this.idAutomotorValuacion = idAutomotorValuacion;
    }

    public Integer getIdAutomotorValuacion() {
        return idAutomotorValuacion;
    }

    public void setIdAutomotorValuacion(Integer idAutomotorValuacion) {
        this.idAutomotorValuacion = idAutomotorValuacion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    public VehiculoTipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(VehiculoTipo idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutomotorValuacion != null ? idAutomotorValuacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoValuacion)) {
            return false;
        }
        VehiculoValuacion other = (VehiculoValuacion) object;
        if ((this.idAutomotorValuacion == null && other.idAutomotorValuacion != null) || (this.idAutomotorValuacion != null && !this.idAutomotorValuacion.equals(other.idAutomotorValuacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.VehiculoValuacion[ idAutomotorValuacion=" + idAutomotorValuacion + " ]";
    }
    
}
