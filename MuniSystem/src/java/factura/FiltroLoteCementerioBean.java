package factura;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.Cementerio;
import manager.CementerioManager;

@ManagedBean(name = "filtroLoteCementerioBean")
@SessionScoped
public class FiltroLoteCementerioBean implements Serializable{
    private Integer filtroCementerioRmc;
    private String filtroCementerioCedula;
    private Integer filtroCementerioNroLote;
    private CementerioManager manager = new CementerioManager();
    private Cementerio cementerioSelect;
    private List<Cementerio> cementerios;
    
    public void filtrar(ActionEvent e){
        cementerios = manager.filtrar(filtroCementerioRmc, getFiltroCementerioCedula(), filtroCementerioNroLote);
    }
    
    public void limpiarFiltro(ActionEvent e){
        filtroCementerioRmc = null;
        filtroCementerioCedula = null;
        filtroCementerioNroLote = null;
        cementerioSelect = null;
        cementerioSelect = null;
    }

    public Integer getFiltroCementerioRmc() {
        return filtroCementerioRmc;
    }

    public void setFiltroCementerioRmc(Integer filtroCementerioRmc) {
        this.filtroCementerioRmc = filtroCementerioRmc;
    }

    public String getFiltroCementerioCedula() {
        return filtroCementerioCedula;
    }

    public void setFiltroCementerioCedula(String filtroCementerioCedula) {
        this.filtroCementerioCedula = filtroCementerioCedula;
    }

    public Integer getFiltroCementerioNroLote() {
        return filtroCementerioNroLote;
    }

    public void setFiltroCementerioNroLote(Integer filtroCementerioNroLote) {
        this.filtroCementerioNroLote = filtroCementerioNroLote;
    }

    public Cementerio getCementerioSelect() {
        return cementerioSelect;
    }

    public void setCementerioSelect(Cementerio cementerioSelect) {
        this.cementerioSelect = cementerioSelect;
    }

    public List<Cementerio> getCementerios() {
        return cementerios;
    }

    public void setCementerios(List<Cementerio> cementerios) {
        this.cementerios = cementerios;
    }
}
