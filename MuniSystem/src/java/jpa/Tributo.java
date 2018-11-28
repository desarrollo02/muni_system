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
 * @author USUARIO
 */
@Entity
@Table(name = "tributo")
@NamedQueries({
    @NamedQuery(name = "Tributo.findAll", query = "SELECT t FROM Tributo t")})
public class Tributo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tributo")
    private Integer idTributo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "primer_vencimiento")
    private Integer primerVencimiento;
    @Column(name = "registrar_en")
    private String registrar;
    @JoinColumn(name = "id_periodo_cobro", referencedColumnName = "id_periodo_cobro")
    @ManyToOne
    private PeriodoCobro idPeriodoCobro;
    @Column(name = "valor")
    private Integer valor;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne
    private UnidadMedida idUnidadMedida;

    public Tributo() {
    }

    public Tributo(Integer idTributo) {
        this.idTributo = idTributo;
    }

    public Integer getIdTributo() {
        return idTributo;
    }

    public void setIdTributo(Integer idTributo) {
        this.idTributo = idTributo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrimerVencimiento() {
        return primerVencimiento;
    }

    public void setPrimerVencimiento(Integer primerVencimiento) {
        this.primerVencimiento = primerVencimiento;
    }

    public PeriodoCobro getIdPeriodoCobro() {
        return idPeriodoCobro;
    }

    public void setIdPeriodoCobro(PeriodoCobro idPeriodoCobro) {
        this.idPeriodoCobro = idPeriodoCobro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTributo != null ? idTributo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tributo)) {
            return false;
        }
        Tributo other = (Tributo) object;
        if ((this.idTributo == null && other.idTributo != null) || (this.idTributo != null && !this.idTributo.equals(other.idTributo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Tributo[ idTributo=" + idTributo + " ]";
    }

    public String isRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }    

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public UnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(UnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }
}
