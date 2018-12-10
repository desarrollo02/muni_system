package dto;

public class TributoFacturableDTO {
    
    private Integer idRef;
    private String descripcion;
    private String lugarRegistro;
    private Integer idContribuyente;

    public Integer getIdRef() {
        return idRef;
    }

    public void setIdRef(Integer idRef) {
        this.idRef = idRef;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugarRegistro() {
        return lugarRegistro;
    }

    public void setLugarRegistro(String lugarRegistro) {
        this.lugarRegistro = lugarRegistro;
    }

    public Integer getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }
}
