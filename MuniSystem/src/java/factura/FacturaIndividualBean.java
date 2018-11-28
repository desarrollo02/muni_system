package factura;

import bean.FachadaBean;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import jpa.Cementerio;
import jpa.Comercio;
import jpa.ComprobanteCabecera;
import jpa.Inmueble;
import jpa.RegistroConducir;
import jpa.Vehiculo;

@ManagedBean(name = "facturaIndividualBean")
@SessionScoped
public class FacturaIndividualBean implements Serializable {
    
    private String tipoImpuesto;
    private FachadaBean fachada = new FachadaBean();
    private List<ComprobanteCabecera> comprobantes;
    
    public void iniciarVariables(){
        tipoImpuesto = "SELECCIONAR";
    }
    
    public void generarFactura(ActionEvent e){
        /*if(tipoImpuesto.equals("I")){
            Inmueble inmueble = fachada.getInmuebleSeleccionado();
            generadorFacturaInm.setInmueble(inmueble);
            generadorFacturaInm.generarFacturaInmueble();
            comprobantes = generadorFacturaInm.getComprobantes(
                    generadorFacturaInm.getImpuestoInmobiliario(), 
                    inmueble.getIdInmueble());
        }else if(tipoImpuesto.equals("P")){
            Comercio comercio = fachada.getComercioSeleccionado();
            generadorFacturaCom.setComercio(comercio);
            generadorFacturaCom.generarFacturaPatenteComercial();
            comprobantes = generadorFacturaCom.getComprobantes(
                    generadorFacturaCom.getImpuestoPatenteComercial(),
                    comercio.getIdComercio());
        }else if(tipoImpuesto.equals("C")){
            Cementerio cementerio = fachada.getCementerioSeleccionado();
            generadorFacturaCem.setCementerio(cementerio);
            generadorFacturaCem.generarFacturaCementerio();
            comprobantes = generadorFacturaCem.getComprobantes(
                    generadorFacturaCem.getImpuestoLoteCementerio(), 
                    cementerio.getIdCementerio());
        }else if(tipoImpuesto.equals("H")){
            Vehiculo vehiculo = fachada.getVehiculoSeleccionado();
            generadorFacturaHab.setVehiculo(vehiculo);
            generadorFacturaHab.generarFacturaHabilitacion();
            comprobantes = generadorFacturaHab.getComprobantes(
                    generadorFacturaHab.getImpuestoHabilitacion(), 
                    vehiculo.getIdVehiculo());
        }else if(tipoImpuesto.equals("R")){
            RegistroConducir registro = fachada.getRegistroSeleccionado();
            generadorFacturaReg.setRegistro(registro);
            generadorFacturaReg.generarFacturaRegistro();
            comprobantes = generadorFacturaReg.getComprobantes(
                    generadorFacturaReg.getImpuestoRegistroConducir(), 
                    registro.getIdRegistroConducir());
        }*/
    }

    public FacturaIndividualBean() {
    }

    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }    

    /**
     * @return the comprobantes
     */
    public List<ComprobanteCabecera> getComprobantes() {
        return comprobantes;
    }

    /**
     * @param comprobantes the comprobantes to set
     */
    public void setComprobantes(List<ComprobanteCabecera> comprobantes) {
        this.comprobantes = comprobantes;
    }
}
