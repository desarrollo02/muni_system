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
@Table(name = "contribuyente")
@NamedQueries({
    @NamedQuery(name = "Contribuyente.findAll", query = "SELECT c FROM Contribuyente c")})
public class Contribuyente implements Serializable {

    @OneToMany(mappedBy = "idContribuyente")
    private List<ComprobanteCabecera> comprobanteCabeceraList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contribuyente")
    private Integer idContribuyente;
    @Size(max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 150)
    @Column(name = "razon_social")
    private String razonSocial;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "persona_juridica")
    private Boolean personaJuridica;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 15)
    @Column(name = "linea_baja")
    private String lineaBaja;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Size(max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "nro_casa")
    private Integer nroCasa;
    @Size(max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 12)
    @Column(name = "ruc")
    private String ruc;
    @OneToMany(mappedBy = "idContribuyente")
    private List<RegistroConducir> registroConducirList;
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
    @ManyToOne
    private Barrio idBarrio;
    @OneToMany(mappedBy = "idContribuyente")
    private List<Vehiculo> vehiculoList;
    @OneToMany(mappedBy = "idContribuyente")
    private List<Cementerio> cementerioList;
    @OneToMany(mappedBy = "idContribuyente")
    private List<Comercio> comercioList;

    public Contribuyente() {
    }

    public Contribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Integer getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(Boolean personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getLineaBaja() {
        return lineaBaja;
    }

    public void setLineaBaja(String lineaBaja) {
        this.lineaBaja = lineaBaja;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNroCasa() {
        return nroCasa;
    }

    public void setNroCasa(Integer nroCasa) {
        this.nroCasa = nroCasa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public List<RegistroConducir> getRegistroConducirList() {
        return registroConducirList;
    }

    public void setRegistroConducirList(List<RegistroConducir> registroConducirList) {
        this.registroConducirList = registroConducirList;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public List<Cementerio> getCementerioList() {
        return cementerioList;
    }

    public void setCementerioList(List<Cementerio> cementerioList) {
        this.cementerioList = cementerioList;
    }

    public List<Comercio> getComercioList() {
        return comercioList;
    }

    public void setComercioList(List<Comercio> comercioList) {
        this.comercioList = comercioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContribuyente != null ? idContribuyente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contribuyente)) {
            return false;
        }
        Contribuyente other = (Contribuyente) object;
        if ((this.idContribuyente == null && other.idContribuyente != null) || (this.idContribuyente != null && !this.idContribuyente.equals(other.idContribuyente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Contribuyente[ idContribuyente=" + idContribuyente + " ]";
    }

    public List<ComprobanteCabecera> getComprobanteCabeceraList() {
        return comprobanteCabeceraList;
    }

    public void setComprobanteCabeceraList(List<ComprobanteCabecera> comprobanteCabeceraList) {
        this.comprobanteCabeceraList = comprobanteCabeceraList;
    }
    
}
