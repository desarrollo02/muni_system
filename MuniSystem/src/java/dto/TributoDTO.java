package dto;

import java.util.Date;
import java.util.List;

public class TributoDTO {
    
    private String nombre;
    private String tipo;
    private String periodo;
    private String registrar;
    private Integer primerVencimiento;
    private String unidadMedida;
    private Integer valor;
    private List<MultaDTO> multas;
    private List<String> tributosAnexos;

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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getPrimerVencimiento() {
        return primerVencimiento;
    }

    public void setPrimerVencimiento(Integer primerVencimiento) {
        this.primerVencimiento = primerVencimiento;
    }

    public List<MultaDTO> getMultas() {
        return multas;
    }

    public void setMultas(List<MultaDTO> multas) {
        this.multas = multas;
    }

    public List<String> getTributosAnexos() {
        return tributosAnexos;
    }

    public void setTributosAnexos(List<String> tributosAnexos) {
        this.tributosAnexos = tributosAnexos;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
}
