
package dto;

import java.util.Date;
import java.util.List;

public class FacturaDTO {
   private Integer nroFactura; 
   private String concepto;
   private Integer referencia;
   private Integer anio;
   private String nombreTributo;
   private Date vencimiento;
   private Double total;
   private String pagado;
   private String contribuyente;
   //muestra los valores segun el tributo, para que el contribuyente pueda verificar los
   //calculos de la factura
   private String variablesParaCalculo;
   private List<FacturaDetalleDTO> detalles;

   public String getConcepto() {
       return concepto;
   }

   public void setConcepto(String concepto) {
       this.concepto = concepto;
   }

   public Integer getReferencia() {
        return referencia;
   }

   public void setReferencia(Integer referencia) {
        this.referencia = referencia;
   }

   public Integer getAnio() {
        return anio;
   }

   public void setAnio(Integer anio) {
        this.anio = anio;
   } 

    public String getNombreTributo() {
        return nombreTributo;
    }

    public void setNombreTributo(String nombreTributo) {
        this.nombreTributo = nombreTributo;
    }

    public String getVariablesParaCalculo() {
        return variablesParaCalculo;
    }

    public void setVariablesParaCalculo(String variablesParaCalculo) {
        this.variablesParaCalculo = variablesParaCalculo;
    }

    public List<FacturaDetalleDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalleDTO> detalles) {
        this.detalles = detalles;
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(String contribuyente) {
        this.contribuyente = contribuyente;
    }
}
