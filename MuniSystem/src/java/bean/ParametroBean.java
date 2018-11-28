package bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Parametros;
import manager.ParametroManager;

@ManagedBean(name = "parametroBean")
@SessionScoped
public class ParametroBean implements Serializable {
    
    private String filtroNombre;
    private String filtroValor;
    private List<Parametros> resultFiltroList;
    private Parametros itemSeleccionado;
    private ParametroManager manager = new ParametroManager();
    
    
    public String guardar(){
        manager.getEm().persist(itemSeleccionado);
        return "listaParametro";
    }
    
    public String todos(){
        filtroNombre=null;
        filtroValor=null;
        resultFiltroList = manager.filtrar(filtroNombre, filtroValor);
        return "listaParametro";
    }
    
    public String filtrar(){
        resultFiltroList = manager.filtrar(filtroNombre, filtroValor);
        return "listaParametro";
    }
    
    public String irVistaLista(){
        resultFiltroList = manager.filtrar(filtroNombre, filtroValor);
        return "listaParametro";
    }

    
    public ParametroBean() {
    }

    public String getFiltroNombre() {
        return filtroNombre;
    }

    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    public String getFiltroValor() {
        return filtroValor;
    }

    public void setFiltroValor(String filtroValor) {
        this.filtroValor = filtroValor;
    }

    public List<Parametros> getResultFiltroList() {
        return resultFiltroList;
    }

    public void setResultFiltroList(List<Parametros> resultFiltroList) {
        this.resultFiltroList = resultFiltroList;
    }

    public Parametros getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(Parametros itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
    }
    
}
