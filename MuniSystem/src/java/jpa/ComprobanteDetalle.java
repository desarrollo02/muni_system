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
@Table(name = "comprobante_detalle")
@NamedQueries({
    @NamedQuery(name = "ComprobanteDetalle.findAll", query = "SELECT c FROM ComprobanteDetalle c")})
public class ComprobanteDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante_detalle")
    private Integer idComprobanteDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @JoinColumn(name = "id_comprobante_cab", referencedColumnName = "id_comprobante_cabecera")
    @ManyToOne
    private ComprobanteCabecera idComprobanteCab;
    @JoinColumn(name = "id_tributo", referencedColumnName = "id_tributo")
    @ManyToOne
    private Tributo idTributo;

    public ComprobanteDetalle() {
    }

    public ComprobanteDetalle(Integer idComprobanteDetalle) {
        this.idComprobanteDetalle = idComprobanteDetalle;
    }

    public Integer getIdComprobanteDetalle() {
        return idComprobanteDetalle;
    }

    public void setIdComprobanteDetalle(Integer idComprobanteDetalle) {
        this.idComprobanteDetalle = idComprobanteDetalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public ComprobanteCabecera getIdComprobanteCab() {
        return idComprobanteCab;
    }

    public void setIdComprobanteCab(ComprobanteCabecera idComprobanteCab) {
        this.idComprobanteCab = idComprobanteCab;
    }

    public Tributo getIdTributo() {
        return idTributo;
    }

    public void setIdTributo(Tributo idTributo) {
        this.idTributo = idTributo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobanteDetalle != null ? idComprobanteDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteDetalle)) {
            return false;
        }
        ComprobanteDetalle other = (ComprobanteDetalle) object;
        if ((this.idComprobanteDetalle == null && other.idComprobanteDetalle != null) || (this.idComprobanteDetalle != null && !this.idComprobanteDetalle.equals(other.idComprobanteDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ComprobanteDetalle[ idComprobanteDetalle=" + idComprobanteDetalle + " ]";
    }
    
}
