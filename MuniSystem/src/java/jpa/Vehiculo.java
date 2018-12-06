/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import factura.BaseCalculo;
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
import javax.validation.constraints.Size;

/**
 *
 * @author diaz
 */
@Entity
@Table(name = "vehiculo")
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")})
public class Vehiculo implements Serializable, BaseCalculo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Size(max = 10)
    @Column(name = "chapa")
    private String chapa;
    @Column(name = "anio")
    private Integer anio;
    @Size(max = 30)
    @Column(name = "chasis")
    private String chasis;
    @Size(max = 30)
    @Column(name = "color")
    private String color;
    @Size(max = 30)
    @Column(name = "motor")
    private String motor;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marcas idMarca;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne
    private Modelos idModelo;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_categoria")
    @ManyToOne
    private VehiculoTipo idTipo;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @JoinColumn(name = "id_valuacion", referencedColumnName = "id_automotor_valuacion")
    @ManyToOne
    private VehiculoValuacion idValuacion;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
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
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public VehiculoValuacion getIdValuacion() {
        return idValuacion;
    }

    public void setIdValuacion(VehiculoValuacion idValuacion) {
        this.idValuacion = idValuacion;
    }

    @Override
    public Double getValorBase() {
        return this.idValuacion.getMonto();
    }

    @Override
    public Integer getIdRef() {
        return this.idVehiculo;
    }

    @Override
    public Contribuyente getTitular() {
        return this.getIdContribuyente();
    }

    @Override
    public String getDescripcionCalculo() {
        return "Marca: " + idMarca.getDescripcion() + ", Modelo: " + idModelo.getDescripcion() +
                ", Año: " + anio + ", Valuacion: " + idValuacion.getMonto();
    }
    
}
