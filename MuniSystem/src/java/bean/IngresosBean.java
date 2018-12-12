package bean;

import controller.IngresosController;
import dto.IngresoDTO;
import enumerados.TributoConRegistro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

@Named(value = "ingresosBean")
@SessionScoped
public class IngresosBean implements Serializable {
    
    private String nombreTributo;
    private Integer anio;
    private List<IngresoDTO> ingresos;
    private IngresosController controller = new IngresosController();

    public IngresosBean() {
    }
    
    private void limpiarVariables(){
        nombreTributo=null;
        anio=null;
        ingresos = new ArrayList<>();
    }
    
    public String irVista(){
        limpiarVariables();
        return "ingresos";
    }

    public void buscar(ActionEvent evento){
        ingresos = new ArrayList<>();
        IngresoDTO ingresoInmDTO;
        IngresoDTO ingresoPatDTO;
        IngresoDTO ingresoCemDTO;
        IngresoDTO ingresoVehiDTO;
        IngresoDTO ingresoRegDTO;
        if(nombreTributo==null){
            ingresoInmDTO = controller.getIngreso(anio, TributoConRegistro.INMOBILIARIO);
            ingresos.add(ingresoInmDTO);
            ingresoPatDTO = controller.getIngreso(anio, TributoConRegistro.PATENTE);
            ingresos.add(ingresoPatDTO);
            ingresoCemDTO = controller.getIngreso(anio, TributoConRegistro.CEMENTERIO);
            ingresos.add(ingresoCemDTO);
            ingresoVehiDTO = controller.getIngreso(anio, TributoConRegistro.VEHICULO);
            ingresos.add(ingresoVehiDTO);
            ingresoRegDTO = controller.getIngreso(anio, TributoConRegistro.REGISTRO);
            ingresos.add(ingresoRegDTO);
        }else{
            switch (nombreTributo) {
                case "INMOBILIARIO":
                    ingresoInmDTO = controller.getIngreso(anio, TributoConRegistro.INMOBILIARIO);
                    ingresos.add(ingresoInmDTO);
                    break;
                case "PATENTE":
                    ingresoPatDTO = controller.getIngreso(anio, TributoConRegistro.PATENTE);
                    ingresos.add(ingresoPatDTO);
                    break;
                case "CEMENTERIO":
                    ingresoCemDTO = controller.getIngreso(anio, TributoConRegistro.CEMENTERIO);
                    ingresos.add(ingresoCemDTO);
                    break;
                case "VEHICULO":
                    ingresoVehiDTO = controller.getIngreso(anio, TributoConRegistro.VEHICULO);
                    ingresos.add(ingresoVehiDTO);
                    break;
                case "REGISTRO":
                    ingresoRegDTO = controller.getIngreso(anio, TributoConRegistro.REGISTRO);
                    ingresos.add(ingresoRegDTO);
                    break;
                default:
                    break;
            }
        }    
    }

    public String getNombreTributo() {
        return nombreTributo;
    }

    public void setNombreTributo(String nombreTributo) {
        this.nombreTributo = nombreTributo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public List<IngresoDTO> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoDTO> ingresos) {
        this.ingresos = ingresos;
    }
}
