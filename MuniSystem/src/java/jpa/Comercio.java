/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

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
@Table(name = "comercio")
@NamedQueries({
    @NamedQuery(name = "Comercio.findAll", query = "SELECT c FROM Comercio c")})
public class Comercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comercio")
    private Integer idComercio;
    @Column(name = "nro_referencia")
    private Integer nroReferencia;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecAlta;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 200)
    @Column(name = "nombre_fantasia")
    private String nombreFantasia;
    @Size(max = 300)
    @Column(name = "obs")
    private String obs;
    @Column(name = "fec_vigencia")
    @Temporal(TemporalType.DATE)
    private Date fecVigencia;
    @Basic(optional = false)
    @Column(name = "nro_patente")
    private int nroPatente;
    @Column(name = "fec_modif")
    @Temporal(TemporalType.DATE)
    private Date fecModif;
    @Column(name = "fec_baja")
    @Temporal(TemporalType.DATE)
    private Date fecBaja;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_activo")
    private Double valorActivo;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ultimo_anio")
    @Temporal(TemporalType.DATE)
    private Date ultimoAnio;
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
    @ManyToOne
    private Barrio idBarrio;
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    @ManyToOne
    private ComercioRubro idRubro;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @JoinColumn(name = "id_usu_alta", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuAlta;
    @JoinColumn(name = "id_usu_modif", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuModif;
    @JoinColumn(name = "id_usu_baja", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuBaja;

    public Comercio() {
    }

    public Comercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Comercio(Integer idComercio, int nroPatente) {
        this.idComercio = idComercio;
        this.nroPatente = nroPatente;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Integer getNroReferencia() {
        return nroReferencia;
    }

    public void setNroReferencia(Integer nroReferencia) {
        this.nroReferencia = nroReferencia;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getFecVigencia() {
        return fecVigencia;
    }

    public void setFecVigencia(Date fecVigencia) {
        this.fecVigencia = fecVigencia;
    }

    public int getNroPatente() {
        return nroPatente;
    }

    public void setNroPatente(int nroPatente) {
        this.nroPatente = nroPatente;
    }

    public Date getFecModif() {
        return fecModif;
    }

    public void setFecModif(Date fecModif) {
        this.fecModif = fecModif;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Double getValorActivo() {
        return valorActivo;
    }

    public void setValorActivo(Double valorActivo) {
        this.valorActivo = valorActivo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getUltimoAnio() {
        return ultimoAnio;
    }

    public void setUltimoAnio(Date ultimoAnio) {
        this.ultimoAnio = ultimoAnio;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public ComercioRubro getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(ComercioRubro idRubro) {
        this.idRubro = idRubro;
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Usuario getIdUsuAlta() {
        return idUsuAlta;
    }

    public void setIdUsuAlta(Usuario idUsuAlta) {
        this.idUsuAlta = idUsuAlta;
    }

    public Usuario getIdUsuModif() {
        return idUsuModif;
    }

    public void setIdUsuModif(Usuario idUsuModif) {
        this.idUsuModif = idUsuModif;
    }

    public Usuario getIdUsuBaja() {
        return idUsuBaja;
    }

    public void setIdUsuBaja(Usuario idUsuBaja) {
        this.idUsuBaja = idUsuBaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComercio != null ? idComercio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comercio)) {
            return false;
        }
        Comercio other = (Comercio) object;
        if ((this.idComercio == null && other.idComercio != null) || (this.idComercio != null && !this.idComercio.equals(other.idComercio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Comercio[ idComercio=" + idComercio + " ]";
    }
    
}
