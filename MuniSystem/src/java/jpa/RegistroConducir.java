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
@Table(name = "registro_conducir")
@NamedQueries({
    @NamedQuery(name = "RegistroConducir.findAll", query = "SELECT r FROM RegistroConducir r")})
public class RegistroConducir implements Serializable, BaseCalculo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_registro_conducir")
    private Integer idRegistroConducir;
    @Size(max = 10)
    @Column(name = "grupo_sangre")
    private String grupoSangre;
    @Column(name = "licencia_nro")
    private Integer licenciaNro;
    @Column(name = "vencicimiento")
    @Temporal(TemporalType.DATE)
    private Date vencicimiento;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private RegistroCategoria idCategoria;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    public RegistroConducir() {
    }

    public RegistroConducir(Integer idRegistroConducir) {
        this.idRegistroConducir = idRegistroConducir;
    }

    public Integer getIdRegistroConducir() {
        return idRegistroConducir;
    }

    public void setIdRegistroConducir(Integer idRegistroConducir) {
        this.idRegistroConducir = idRegistroConducir;
    }

    public String getGrupoSangre() {
        return grupoSangre;
    }

    public void setGrupoSangre(String grupoSangre) {
        this.grupoSangre = grupoSangre;
    }

    public Integer getLicenciaNro() {
        return licenciaNro;
    }

    public void setLicenciaNro(Integer licenciaNro) {
        this.licenciaNro = licenciaNro;
    }

    public Date getVencicimiento() {
        return vencicimiento;
    }

    public void setVencicimiento(Date vencicimiento) {
        this.vencicimiento = vencicimiento;
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public RegistroCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(RegistroCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroConducir != null ? idRegistroConducir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroConducir)) {
            return false;
        }
        RegistroConducir other = (RegistroConducir) object;
        if ((this.idRegistroConducir == null && other.idRegistroConducir != null) || (this.idRegistroConducir != null && !this.idRegistroConducir.equals(other.idRegistroConducir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.RegistroConducir[ idRegistroConducir=" + idRegistroConducir + " ]";
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public Double getValorBase() {
        return this.getIdCategoria().getMonto();
    }

    @Override
    public Integer getIdRef() {
        return this.getIdRegistroConducir();
    }

    @Override
    public Contribuyente getTitular() {
        return this.getIdContribuyente();
    }
    
}
