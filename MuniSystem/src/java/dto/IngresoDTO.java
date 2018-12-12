/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

public class IngresoDTO {
    
    private String tributo;
    private Integer anio;
    private Double montoEstimado;
    private Double montoIngreso;
    private Double montoFaltante;

    public String getTributo() {
        return tributo;
    }

    public void setTributo(String tributo) {
        this.tributo = tributo;
    }

    public Double getMontoEstimado() {
        return montoEstimado;
    }

    public void setMontoEstimado(Double montoEstimado) {
        this.montoEstimado = montoEstimado;
    }

    public Double getMontoIngreso() {
        return montoIngreso;
    }

    public void setMontoIngreso(Double montoIngreso) {
        this.montoIngreso = montoIngreso;
    }

    public Double getMontoFaltante() {
        return montoFaltante;
    }

    public void setMontoFaltante(Double montoFaltante) {
        this.montoFaltante = montoFaltante;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
