package factura;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import jpa.RegistroConducir;
import manager.RegistroConducirManager;

@ManagedBean(name = "filtroRegistroBean")
@SessionScoped
public class FiltroRegistrioBean implements Serializable{
    private Integer filtroRegistroConducirRmc;
    private String filtroRegistroConducirCedula;
    private Integer filtroRegistroConducirNro;
    private RegistroConducirManager manager = new RegistroConducirManager();
    private RegistroConducir registroSelect;
    private List<RegistroConducir> registros;
    
    public void filtrar(ActionEvent e){
        registros = manager.filtrar(filtroRegistroConducirRmc, filtroRegistroConducirCedula, filtroRegistroConducirNro, null);
    }
    
    public void limpiarFiltro(ActionEvent e){
        filtroRegistroConducirRmc = null;
        filtroRegistroConducirCedula = null;
        filtroRegistroConducirNro = null;
        registroSelect = null;
        registros = null;
    }

    public Integer getFiltroRegistroConducirRmc() {
        return filtroRegistroConducirRmc;
    }

    public void setFiltroRegistroConducirRmc(Integer filtroRegistroConducirRmc) {
        this.filtroRegistroConducirRmc = filtroRegistroConducirRmc;
    }

    public String getFiltroRegistroConducirCedula() {
        return filtroRegistroConducirCedula;
    }

    public void setFiltroRegistroConducirCedula(String filtroRegistroConducirCedula) {
        this.filtroRegistroConducirCedula = filtroRegistroConducirCedula;
    }

    public Integer getFiltroRegistroConducirNro() {
        return filtroRegistroConducirNro;
    }

    public void setFiltroRegistroConducirNro(Integer filtroRegistroConducirNro) {
        this.filtroRegistroConducirNro = filtroRegistroConducirNro;
    }

    public RegistroConducir getRegistroSelect() {
        return registroSelect;
    }

    public void setRegistroSelect(RegistroConducir registroSelect) {
        this.registroSelect = registroSelect;
    }

    public List<RegistroConducir> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroConducir> registros) {
        this.registros = registros;
    }
}
