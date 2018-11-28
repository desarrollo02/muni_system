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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ubicacion_cementerio")
@NamedQueries({
    @NamedQuery(name = "UbicacionCementerio.findAll", query = "SELECT u FROM UbicacionCementerio u")})
public class UbicacionCementerio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ubicacion_cementerio")
    private Integer idUbicacionCementerio;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 120)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
    @ManyToOne
    private Barrio idBarrio;
    @OneToMany(mappedBy = "idUbicacionCementerio")
    private List<Cementerio> cementerioList;

    public UbicacionCementerio() {
    }

    public UbicacionCementerio(Integer idUbicacionCementerio) {
        this.idUbicacionCementerio = idUbicacionCementerio;
    }

    public Integer getIdUbicacionCementerio() {
        return idUbicacionCementerio;
    }

    public void setIdUbicacionCementerio(Integer idUbicacionCementerio) {
        this.idUbicacionCementerio = idUbicacionCementerio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public List<Cementerio> getCementerioList() {
        return cementerioList;
    }

    public void setCementerioList(List<Cementerio> cementerioList) {
        this.cementerioList = cementerioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicacionCementerio != null ? idUbicacionCementerio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionCementerio)) {
            return false;
        }
        UbicacionCementerio other = (UbicacionCementerio) object;
        if ((this.idUbicacionCementerio == null && other.idUbicacionCementerio != null) || (this.idUbicacionCementerio != null && !this.idUbicacionCementerio.equals(other.idUbicacionCementerio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.UbicacionCementerio[ idUbicacionCementerio=" + idUbicacionCementerio + " ]";
    }
    
}
