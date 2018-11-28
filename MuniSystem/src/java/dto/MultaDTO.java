package dto;

public class MultaDTO {
    
    private String key;
    private Integer idMulta;
    private Integer diasMin;
    private Integer diasMax;
    private Integer valor;
    private String unidadMedida;

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
