package bean;

import controller.GenerarAvisosController;
import dto.ContribuyenteDTO;
import enumerados.TributoConRegistro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import reporte.CobranzasDelDiaBean;
import util.JasperReportUtils;

/**
 *
 * @author desarrollo2
 */
@Named(value = "generarAvisosBean")
@SessionScoped
public class GenerarAvisosBean extends BaseBean implements Serializable {
    
    private String nombreTributo;
    private Integer idCondribuyente;
    private String cedula;
    private String ruc;
    private String nombres;
    private String apellidos;
    private Integer anio;
    private List<ContribuyenteDTO> contribuyentes;
    private GenerarAvisosController controller = new GenerarAvisosController();

    public GenerarAvisosBean() {
    }
    
    private void limpiarVariables(){
        nombreTributo=null;
        idCondribuyente=null;
        cedula=null;
        ruc=null;
        nombres=null;
        apellidos=null;
        contribuyentes=null;
    }
    
    public String irVista(){
        limpiarVariables();
        return "generarAvisos";
    }
    
    public void buscar(ActionEvent evento){
        switch (nombreTributo) {
            case "INMOBILIARIO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.INMOBILIARIO,anio);
                break;
            case "PATENTE":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.PATENTE, anio);
                break;
            case "CEMENTERIO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.CEMENTERIO, anio);
                break;
            case "VEHICULO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.VEHICULO, anio);
                break;
            case "REGISTRO":
                contribuyentes = controller.getContribuyentes(TributoConRegistro.REGISTRO, anio);
                break;
            default:
                break;
        }
    }
    
    public String descargarReporte(){
        try {
            Integer idTributo=0;
            String descTributo="";
            switch (nombreTributo) {
                case "INMOBILIARIO":
                    idTributo = controller.getIdTributo(TributoConRegistro.INMOBILIARIO);
                    descTributo = "Impuesto inmobiliario";
                    break;
                case "PATENTE":
                    idTributo = controller.getIdTributo(TributoConRegistro.PATENTE);
                    descTributo = "Patente Comercial";
                    break;
                case "CEMENTERIO":
                    idTributo = controller.getIdTributo(TributoConRegistro.CEMENTERIO);
                    descTributo = "Lote en Cementerio";
                    break;
                case "VEHICULO":
                    idTributo = controller.getIdTributo(TributoConRegistro.VEHICULO);
                    descTributo = "Habilitacion de Vehiculo";
                    break;
                case "REGISTRO":
                    idTributo = controller.getIdTributo(TributoConRegistro.REGISTRO);
                    descTributo = "Registro de Conducir";
                    break;
                default:
                    break;
            }
            if(contribuyentes == null || contribuyentes.isEmpty()){
                super.setMensajeError("No se encontraron contribuyentes para el aviso");
                return null;
            }
            
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("FECHA_ACTUAL",new Date());
            parametros.put("DESC_TRIBUTO", descTributo);
            parametros.put("ANULADO", false);
            parametros.put("PAGADO", false);
            parametros.put("ID_TRIBUTO", idTributo);
            parametros.put("ANIO", anio);
            JasperReportUtils.runReportB("avisos","/seguro/reporte/avisos.jasper",parametros);
            return null;
        }catch(Exception ex){
            Logger.getLogger(CobranzasDelDiaBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String getNombreTributo() {
        return nombreTributo;
    }

    public void setNombreTributo(String nombreTributo) {
        this.nombreTributo = nombreTributo;
    }

    public Integer getIdCondribuyente() {
        return idCondribuyente;
    }

    public void setIdCondribuyente(Integer idCondribuyente) {
        this.idCondribuyente = idCondribuyente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<ContribuyenteDTO> getContribuyentes() {
        return contribuyentes;
    }

    public void setContribuyentes(List<ContribuyenteDTO> contribuyentes) {
        this.contribuyentes = contribuyentes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
