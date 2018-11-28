package bean;

import buil.TributoDTOListBuilder;
import controller.TributoController;
import dto.MultaDTO;
import dto.TributoDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;
import org.primefaces.model.DualListModel;

@Named(value = "tributoBean")
@SessionScoped
public class TributoBean extends BaseBean implements Serializable {
    
    private String nombreFiltro;
    private String tipoFiltro;
    private TributoController tributoController = new TributoController();
    private List<TributoDTO> tributoDTOList = new TributoDTOListBuilder().build();
    private TributoDTO tributoDTOSelect;
    private TributoDTO tributoDTO;
    private List<String> periodos;
    private MultaDTO multaDTOselect;
    private List<String> unidades;
    private Integer keyMulta=0;
    private DualListModel<String> anexos;
    
    public TributoBean() {
    }
    
    public String irVista(){
        nombreFiltro=null;
        tipoFiltro=null;
        periodos=tributoController.getNombrePeriodosAll();
        unidades=tributoController.getNombreUnidadMedidaAll();
        return "tributos";
    }
    
    public void filtrar(ActionEvent e){
        tributoDTOList = tributoController.getTributos(nombreFiltro, tipoFiltro);
    }
    
    public void todos(ActionEvent e){
        nombreFiltro = null;
        tipoFiltro = null;
        tributoDTOList = tributoController.getTributoAll();
    }
    
    public void addMulta(ActionEvent e){
        keyMulta++;
        tributoDTO.getMultas().add(tributoController.newMultaEmpty(keyMulta));
    }
    
    public void removeMulta(ActionEvent e){
        tributoDTO.getMultas().remove(multaDTOselect);
    }
    
    public void addMultaEdit(ActionEvent e){
        keyMulta++;
        tributoDTOSelect.getMultas().add(tributoController.newMultaEmpty(keyMulta));
    }
    
    public void removeMultaEdit(ActionEvent e){
        tributoDTOSelect.getMultas().remove(multaDTOselect);
    }
    
    public String guardar(){
        try{
            tributoDTO.setTributosAnexos(anexos.getTarget());
            tributoController.guardarTributo(tributoDTO);
            super.setMensaje("Datos guardados correctamente");
            return "tributos";
        }catch(PersistenceException ex){
            tributoController.revertirTransaccion();
            super.setMensajeError("Error al intentar guardar los datos");
            return null;
        }
    }
    
    public String actualizar(){
        try{
            tributoDTOSelect.setTributosAnexos(anexos.getTarget());
            tributoController.actualizarTributo(tributoDTOSelect);
            super.setMensaje("Datos guardados correctamente");
            return "tributos";
        }catch(PersistenceException ex){
            tributoController.revertirTransaccion();
            super.setMensajeError("Error al intentar guardar los datos");
            return null;
        }
    }
    
    public String eliminar(){
        try{
            tributoController.eliminar(tributoDTOSelect);
            super.setMensaje("Datos eliminados correctamente");
            return "tributos";
        }catch(PersistenceException ex){
            super.setMensajeError("Error al intentar eliminar los datos");
            return null;
        }
    }
    
    
    public String nuevo(){
        setTributoDTO(tributoController.getNewTributo());
        List<String> anexoSource = tributoController.getNombreTributoAll();
        List<String> anexoTarget = new ArrayList<>();
        setAnexos(new DualListModel<>(anexoSource, anexoTarget));
        return "tributoAlta";
    }
    
    public String editar(){
        keyMulta=1000;
        List<String> anexoSource = tributoController.getNombreTributoAll();
        List<String> anexoTarget = new ArrayList<>();
        for(String anexo : tributoDTOSelect.getTributosAnexos()){
            anexoTarget.add(anexo);
            anexoSource.remove(anexo);
        }
        setAnexos(new DualListModel<>(anexoSource, anexoTarget));
        return "tributoEditar";
    }
    
    public String detalle(){
        List<String> anexoSource = tributoController.getNombreTributoAll();
        List<String> anexoTarget = new ArrayList<>();
        for(String anexo : tributoDTOSelect.getTributosAnexos()){
            anexoTarget.add(anexo);
            anexoSource.remove(anexo);
        }
        setAnexos(new DualListModel<>(anexoSource, anexoTarget));
        return "tributoDetalle";
    }

    public String getNombreFiltro() {
        return nombreFiltro;
    }

    public void setNombreFiltro(String nombreFiltro) {
        this.nombreFiltro = nombreFiltro;
    }

    public String getTipoFiltro() {
        return tipoFiltro;
    }

    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }

    public List<TributoDTO> getTributoDTOList() {
        return tributoDTOList;
    }

    public void setTributoDTOList(List<TributoDTO> tributoDTOList) {
        this.tributoDTOList = tributoDTOList;
    }

    public TributoDTO getTributoDTOSelect() {
        return tributoDTOSelect;
    }

    public void setTributoDTOSelect(TributoDTO tributoDTOSelect) {
        this.tributoDTOSelect = tributoDTOSelect;
    }

    public TributoDTO getTributoDTO() {
        return tributoDTO;
    }

    public void setTributoDTO(TributoDTO tributoDTO) {
        this.tributoDTO = tributoDTO;
    }

    public List<String> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<String> periodos) {
        this.periodos = periodos;
    }

    public MultaDTO getMultaDTOselect() {
        return multaDTOselect;
    }

    public void setMultaDTOselect(MultaDTO multaDTOselect) {
        this.multaDTOselect = multaDTOselect;
    }

    public List<String> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<String> unidades) {
        this.unidades = unidades;
    }

    public DualListModel<String> getAnexos() {
        return anexos;
    }

    public void setAnexos(DualListModel<String> anexos) {
        this.anexos = anexos;
    }
}
