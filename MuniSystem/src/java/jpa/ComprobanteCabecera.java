package jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "comprobante_cabecera")
@NamedQueries({
    @NamedQuery(name = "ComprobanteCabecera.findAll", query = "SELECT c FROM ComprobanteCabecera c")})
public class ComprobanteCabecera implements Serializable {

    @OneToMany(mappedBy = "idComprobanteCab")
    private List<ComprobanteDetalle> comprobanteDetalleList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante_cabecera")
    private Integer idComprobanteCabecera;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Size(max = 40)
    @Column(name = "usuario_alta")
    private String usuarioAlta;
    @Column(name = "anulado")
    private Boolean anulado;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "vencimiento")
    @Temporal(TemporalType.DATE)
    private Date vencimiento;
    @Column(name = "pagado")
    private Boolean pagado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_pagar")
    private Double totalPagar;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Size(max = 1)
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Size(max = 50)
    @Column(name = "nro_cheque")
    private String nroCheque;
    @Size(max = 50)
    @Column(name = "usuario_pago")
    private String usuarioPago;
    @Column(name = "periodo")
    private Integer periodo;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @JoinColumn(name = "id_tributo", referencedColumnName = "id_tributo")
    @ManyToOne
    private Tributo idTributo;
    @Column(name = "id_ref")
    private Integer id_ref;

    public ComprobanteCabecera() {
    }

    public ComprobanteCabecera(Integer idComprobanteCabecera) {
        this.idComprobanteCabecera = idComprobanteCabecera;
    }

    public Integer getIdComprobanteCabecera() {
        return idComprobanteCabecera;
    }

    public void setIdComprobanteCabecera(Integer idComprobanteCabecera) {
        this.idComprobanteCabecera = idComprobanteCabecera;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public String getUsuarioPago() {
        return usuarioPago;
    }

    public void setUsuarioPago(String usuarioPago) {
        this.usuarioPago = usuarioPago;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
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
        hash += (idComprobanteCabecera != null ? idComprobanteCabecera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteCabecera)) {
            return false;
        }
        ComprobanteCabecera other = (ComprobanteCabecera) object;
        if ((this.idComprobanteCabecera == null && other.idComprobanteCabecera != null) || (this.idComprobanteCabecera != null && !this.idComprobanteCabecera.equals(other.idComprobanteCabecera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ComprobanteCabecera[ idComprobanteCabecera=" + idComprobanteCabecera + " ]";
    }

    public List<ComprobanteDetalle> getComprobanteDetalleList() {
        return comprobanteDetalleList;
    }

    public void setComprobanteDetalleList(List<ComprobanteDetalle> comprobanteDetalleList) {
        this.comprobanteDetalleList = comprobanteDetalleList;
    }

    public Integer getId_ref() {
        return id_ref;
    }

    public void setId_ref(Integer id_ref) {
        this.id_ref = id_ref;
    }
    
}
