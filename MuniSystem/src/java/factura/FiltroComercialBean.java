package factura;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Comercio;
import manager.ComercioManager;


@ManagedBean(name = "filtroComercialBean")
@SessionScoped
public class FiltroComercialBean implements Serializable{
    
    private Integer filtroRMC;
    private String filtroCedula;
    private String filtroBarrio;
    private String filtroNombreComercio;
    private Integer filtroNroPatente;
    private String filtroDireccion;
    private ComercioManager manager = new ComercioManager();
    private Comercio comercioSelect;
    private List<Comercio> comercios;
    
    public void filtrar(ActionEvent e){
        comercios = manager.filtrar(filtroRMC, getFiltroCedula(), getFiltroNombreComercio(), getFiltroNroPatente(), getFiltroBarrio(), getFiltroDireccion());
    }
    
    public void limpiarFiltro(ActionEvent e){
        filtroRMC = null;
        setFiltroCedula(null);
        setFiltroBarrio(null);
        setFiltroNombreComercio(null);
        setFiltroNroPatente(null);
        setFiltroDireccion(null);
        comercioSelect = null;
        comercios = null;
    }

    public Integer getFiltroRMC() {
        return filtroRMC;
    }

    public void setFiltroRMC(Integer filtroRMC) {
        this.filtroRMC = filtroRMC;
    }   

    public Comercio getComercioSelect() {
        return comercioSelect;
    }

    public void setComercioSelect(Comercio comercioSelect) {
        this.comercioSelect = comercioSelect;
    }

    public List<Comercio> getComercios() {
        return comercios;
    }

    public void setComercios(List<Comercio> comercios) {
        this.comercios = comercios;
    }

    public String getFiltroCedula() {
        return filtroCedula;
    }
    
    public void setFiltroCedula(String filtroCedula) {
        this.filtroCedula = filtroCedula;
    }

    public String getFiltroBarrio() {
        return filtroBarrio;
    }

    public void setFiltroBarrio(String filtroBarrio) {
        this.filtroBarrio = filtroBarrio;
    }

    public String getFiltroNombreComercio() {
        return filtroNombreComercio;
    }

    public void setFiltroNombreComercio(String filtroNombreComercio) {
        this.filtroNombreComercio = filtroNombreComercio;
    }

    public Integer getFiltroNroPatente() {
        return filtroNroPatente;
    }

    public void setFiltroNroPatente(Integer filtroNroPatente) {
        this.filtroNroPatente = filtroNroPatente;
    }

    public String getFiltroDireccion() {
        return filtroDireccion;
    }

    public void setFiltroDireccion(String filtroDireccion) {
        this.filtroDireccion = filtroDireccion;
    }
}
