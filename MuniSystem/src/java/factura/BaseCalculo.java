package factura;

import jpa.Contribuyente;

public interface BaseCalculo {

    public Double getValorBase();
    public Integer getIdRef();
    public Contribuyente getTitular();
    public String getDescripcionCalculo();
    public Integer getAnioRegistro();
}
