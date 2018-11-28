package factura;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Vehiculo;
import jpa.VehiculoValuacion;
import manager.VehiculoManager;

@ManagedBean(name = "filtroHabilitacionBean")
@SessionScoped
public class FiltroHabilitacionBean implements Serializable{
    private Integer filtroVehiculoRmc;
    private String filtroVehiculoCedula;
    private String filtroVehiculoChapa;
    private String filtroVehiculoTipo;
    private String filtroVehiculoMarca;
    private String filtroVehiculoModelo;
    private VehiculoManager manager = new VehiculoManager();
    private Vehiculo vehiculoSelect;
    private Double valuacion;
    private List<Vehiculo> vehiculos;
    
    public void filtrar(ActionEvent e){
        vehiculos = manager.filtrar(filtroVehiculoRmc, filtroVehiculoCedula, filtroVehiculoChapa, filtroVehiculoTipo, filtroVehiculoMarca, filtroVehiculoModelo);
    }
    
    public void limpiarFiltro(ActionEvent e){
        filtroVehiculoRmc=null;
        filtroVehiculoCedula=null;
        filtroVehiculoChapa=null;
        filtroVehiculoTipo=null;
        filtroVehiculoMarca=null;
        filtroVehiculoModelo=null;
    }

    public Integer getFiltroVehiculoRmc() {
        return filtroVehiculoRmc;
    }

    public void setFiltroVehiculoRmc(Integer filtroVehiculoRmc) {
        this.filtroVehiculoRmc = filtroVehiculoRmc;
    }

    public String getFiltroVehiculoCedula() {
        return filtroVehiculoCedula;
    }

    public void setFiltroVehiculoCedula(String filtroVehiculoCedula) {
        this.filtroVehiculoCedula = filtroVehiculoCedula;
    }

    public String getFiltroVehiculoChapa() {
        return filtroVehiculoChapa;
    }

    public void setFiltroVehiculoChapa(String filtroVehiculoChapa) {
        this.filtroVehiculoChapa = filtroVehiculoChapa;
    }

    public String getFiltroVehiculoTipo() {
        return filtroVehiculoTipo;
    }

    public void setFiltroVehiculoTipo(String filtroVehiculoTipo) {
        this.filtroVehiculoTipo = filtroVehiculoTipo;
    }

    public String getFiltroVehiculoMarca() {
        return filtroVehiculoMarca;
    }

    public void setFiltroVehiculoMarca(String filtroVehiculoMarca) {
        this.filtroVehiculoMarca = filtroVehiculoMarca;
    }

    public String getFiltroVehiculoModelo() {
        return filtroVehiculoModelo;
    }

    public void setFiltroVehiculoModelo(String filtroVehiculoModelo) {
        this.filtroVehiculoModelo = filtroVehiculoModelo;
    }

    public Vehiculo getVehiculoSelect() {
        return vehiculoSelect;
    }

    public void setVehiculoSelect(Vehiculo vehiculoSelect) {
        this.vehiculoSelect = vehiculoSelect;
        if(vehiculoSelect != null){
        valuacion = manager.getValuacionVehiculo(vehiculoSelect.getAnio(), 
                vehiculoSelect.getIdMarca(), 
                vehiculoSelect.getIdModelo(), 
                vehiculoSelect.getIdTipo());
        }
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * @return the valuacion
     */
    public Double getValuacion() {
        return valuacion;
    }

    /**
     * @param valuacion the valuacion to set
     */
    public void setValuacion(Double valuacion) {
        this.valuacion = valuacion;
    }
}
