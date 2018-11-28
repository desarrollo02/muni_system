package bean;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.CementerioAjuste;
import jpa.InmuebleValuacionAjuste;
import jpa.VehiculoValuacionAjuste;
import manager.AjusteManager;

@ManagedBean(name = "ajusteBean")
@SessionScoped
public class AjusteBean extends MensajeBean implements Serializable {
    
    private String tipoAjuste;
    private Integer ajuste;
    private Integer anio;
    private AjusteManager manager = new AjusteManager();
    private List<InmuebleValuacionAjuste> ajustesImuebles;
    private boolean mostrarResultInmuebles;
    private List<CementerioAjuste> ajustesCementerios;
    private boolean mostrarResultCementerios;
    private List<VehiculoValuacionAjuste> ajustesVehiculos;
    private boolean mostrarResultVehiculos;
    
    public String irVista(){
        mostrarResultInmuebles = false;
        mostrarResultCementerios = false;
        mostrarResultVehiculos = false;
        iniciarVariables();
        return "ajuste";
    }
    
    private void iniciarVariables(){
        tipoAjuste = "SELECCIONAR";
        ajuste = null;
        anio= null;
    }
    
    public void ajustar(ActionEvent e) throws ParseException{
        if(tipoAjuste.equals("SELECCIONAR")){
            super.mensajeError("Debe seleccionar un tipo");
        }else{
            manager.setAjuste(ajuste);
            manager.setTipo(tipoAjuste);
            manager.setAnio(anio);
            manager.ajustar();
            if(tipoAjuste.equals("INMOBILIARIO")){
                ajustesImuebles = manager.getResultadoInmueblesValuaciones(anio);
                mostrarResultInmuebles = true;
                mostrarResultCementerios = false;
                mostrarResultVehiculos = false;
            }else if(tipoAjuste.equals("CEMENTERIO")){
                ajustesCementerios = manager.getResultadoCementeriosValuaicones(anio);
                mostrarResultInmuebles = false;
                mostrarResultCementerios = true;
                mostrarResultVehiculos = false;
            }else if(tipoAjuste.equals("HABILITACION")){
                ajustesVehiculos = manager.getResultadoVehiculoValuaciones(anio);
                mostrarResultInmuebles = false;
                mostrarResultCementerios = false;
                mostrarResultVehiculos = true;
            }
            super.mensajeExito("Ajuste Realizado Correctamente");
            iniciarVariables();
        }
    }

    public AjusteBean() {
    }

    public String getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(String tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }

    public Integer getAjuste() {
        return ajuste;
    }

    public void setAjuste(Integer ajuste) {
        this.ajuste = ajuste;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public List<InmuebleValuacionAjuste> getAjustesImuebles() {
        return ajustesImuebles;
    }

    public void setAjustesImuebles(List<InmuebleValuacionAjuste> ajustesImuebles) {
        this.ajustesImuebles = ajustesImuebles;
    }

    public boolean isMostrarResultInmuebles() {
        return mostrarResultInmuebles;
    }

    public void setMostrarResultInmuebles(boolean mostrarResultInmuebles) {
        this.mostrarResultInmuebles = mostrarResultInmuebles;
    }

    public List<CementerioAjuste> getAjustesCementerios() {
        return ajustesCementerios;
    }

    public void setAjustesCementerios(List<CementerioAjuste> ajustesCementerios) {
        this.ajustesCementerios = ajustesCementerios;
    }

    public boolean isMostrarResultCementerios() {
        return mostrarResultCementerios;
    }

    public void setMostrarResultCementerios(boolean mostrarResultCementerios) {
        this.mostrarResultCementerios = mostrarResultCementerios;
    }

    public List<VehiculoValuacionAjuste> getAjustesVehiculos() {
        return ajustesVehiculos;
    }

    public void setAjustesVehiculos(List<VehiculoValuacionAjuste> ajustesVehiculos) {
        this.ajustesVehiculos = ajustesVehiculos;
    }

    public boolean isMostrarResultVehiculos() {
        return mostrarResultVehiculos;
    }

    public void setMostrarResultVehiculos(boolean mostrarResultVehiculos) {
        this.mostrarResultVehiculos = mostrarResultVehiculos;
    }
    
}
