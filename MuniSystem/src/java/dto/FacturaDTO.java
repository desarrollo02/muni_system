
package dto;

public class FacturaDTO {
   private String concepto;
   private Integer referencia;
   private Integer anio;

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
}
