package factura;

import jpa.Tributo;

public interface TributoFacturable {
    
    public String getDescripcionTributo();
    public Integer getIdRef();
    public Tributo getTributoFacturado();
}
