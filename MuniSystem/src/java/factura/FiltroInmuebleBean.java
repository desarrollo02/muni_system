package factura;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Inmueble;

@ManagedBean(name = "filtroInmuebleBean")
@SessionScoped
public class FiltroInmuebleBean implements Serializable {
    
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroCtaCte;
    private Integer filtroNroFinca;
    private Integer filtroPadron;
    private String filtroRuc;
    private Inmueble inmuebleSelect;
    private List<Inmueble> inmuebles;
    private FiltroInmuebleManager manager = new FiltroInmuebleManager();
    
    public void filtrar(ActionEvent e){
        inmuebles = manager.filtrar(filtroRMC, filtroCedula, filtroRuc, filtroPadron, filtroCtaCte, filtroNroFinca);
    }
    
    public void limpiarFiltro(ActionEvent e){
        filtroRMC = null;
        filtroCedula = null;
        filtroCtaCte = null;
        filtroNroFinca = null;
        filtroPadron = null;
        filtroRuc = null;
        inmuebleSelect = null;
        inmuebles = null;
    }

    public FiltroInmuebleBean() {
    }

    public Integer getFiltroRMC() {
        return filtroRMC;
    }

    public void setFiltroRMC(Integer filtroRMC) {
        this.filtroRMC = filtroRMC;
    }

    public String getFiltroCedula() {
        return filtroCedula;
    }

    public void setFiltroCedula(String filtroCedula) {
        this.filtroCedula = filtroCedula;
    }

    public String getFiltroCtaCte() {
        return filtroCtaCte;
    }

    public void setFiltroCtaCte(String filtroCtaCte) {
        this.filtroCtaCte = filtroCtaCte;
    }

    public Integer getFiltroNroFinca() {
        return filtroNroFinca;
    }

    public void setFiltroNroFinca(Integer filtroNroFinca) {
        this.filtroNroFinca = filtroNroFinca;
    }

    public Integer getFiltroPadron() {
        return filtroPadron;
    }

    public void setFiltroPadron(Integer filtroPadron) {
        this.filtroPadron = filtroPadron;
    }

    public String getFiltroRuc() {
        return filtroRuc;
    }

    public void setFiltroRuc(String filtroRuc) {
        this.filtroRuc = filtroRuc;
    }    

    public Inmueble getInmuebleSelect() {
        return inmuebleSelect;
    }

    public void setInmuebleSelect(Inmueble inmuebleSelect) {
        this.inmuebleSelect = inmuebleSelect;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
}
