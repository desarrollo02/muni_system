package dto;

import java.util.List;

public class RolDTO {
    
    private Integer idRol;
    private String descripcion;
    private List<PantallaDTO> pantallas;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PantallaDTO> getPantallas() {
        return pantallas;
    }

    public void setPantallas(List<PantallaDTO> pantallas) {
        this.pantallas = pantallas;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    
}
