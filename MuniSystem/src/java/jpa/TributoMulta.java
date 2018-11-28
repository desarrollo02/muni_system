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
 * @author USUARIO
 */
@Entity
@Table(name = "tributo_multa")
@NamedQueries({
    @NamedQuery(name = "TributoMulta.findAll", query = "SELECT t FROM TributoMulta t")})
public class TributoMulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tributo_multa")
    private Integer idTributoMulta;
    @Column(name = "dias_min")
    private Integer diasMin;
    @Column(name = "dias_max")
    private Integer diasMax;
    @Column(name = "valor")
    private Integer valor;
    @JoinColumn(name = "id_tributo", referencedColumnName = "id_tributo")
    @ManyToOne
    private Tributo idTributo;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne
    private UnidadMedida idUnidadMedida;

    public TributoMulta() {
    }

    public TributoMulta(Integer idTributoMulta) {
        this.idTributoMulta = idTributoMulta;
    }

    public Integer getIdTributoMulta() {
        return idTributoMulta;
    }

    public void setIdTributoMulta(Integer idTributoMulta) {
        this.idTributoMulta = idTributoMulta;
    }

    public Integer getDiasMin() {
        return diasMin;
    }

    public void setDiasMin(Integer diasMin) {
        this.diasMin = diasMin;
    }

    public Integer getDiasMax() {
        return diasMax;
    }

    public void setDiasMax(Integer diasMax) {
        this.diasMax = diasMax;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Tributo getIdTributo() {
        return idTributo;
    }

    public void setIdTributo(Tributo idTributo) {
        this.idTributo = idTributo;
    }

    public UnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(UnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTributoMulta != null ? idTributoMulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TributoMulta)) {
            return false;
        }
        TributoMulta other = (TributoMulta) object;
        if ((this.idTributoMulta == null && other.idTributoMulta != null) || (this.idTributoMulta != null && !this.idTributoMulta.equals(other.idTributoMulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TributoMulta[ idTributoMulta=" + idTributoMulta + " ]";
    }
    
}
