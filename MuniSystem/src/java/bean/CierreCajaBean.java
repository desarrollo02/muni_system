package bean;

import controller.CierreCajaController;
import dto.UsuarioDTO;
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

@Named(value = "cierreCajaBean")
@SessionScoped
public class CierreCajaBean extends BaseBean implements Serializable {

    private String usuario;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Date fechaDesde;
    private Date fechaHasta;
    private CierreCajaController controller = new CierreCajaController();
    private List<UsuarioDTO> usuarios;
    private UsuarioDTO usuarioSelect;
    
    public CierreCajaBean() {
    }
    
    public void buscar(ActionEvent evento){
        usuarios = controller.getUsuarios(usuario, cedula, nombres, apellidos);
    }
    
     public String descargarReporte(){
        try {
            if(usuarioSelect == null){
                super.setMensajeError("Debe seleccionar un usuario");
                return null;
            }
            if(fechaDesde == null){
                super.setMensajeError("Debe seleccionar fecha desde");
                return null;
            }
            if(fechaHasta == null){
                super.setMensajeError("Debe seleccionar fecha hasta");
                return null;
            }
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("FECHA_ACTUAL",new Date());
            parametros.put("USUARIO", usuarioSelect.getDesc());
            parametros.put("NOMBRE_COMPLETO", usuarioSelect.getNombre() +" "+ usuarioSelect.getApellido());
            parametros.put("TOTAL_EFECTIVO", controller.getTotalEfectivo(fechaDesde, fechaHasta, usuario));
            parametros.put("TOTAL_CHEQUE", controller.getTotalCheque(fechaDesde, fechaHasta, usuario));
            parametros.put("TOTAL_TARJETA_DEBITO", controller.getTotalTarjetaDebito(fechaDesde, fechaHasta, usuario));
            parametros.put("TOTAL_TARJETA_CREDITO", controller.getTotalTarjetaCredito(fechaDesde, fechaHasta, usuario));
            parametros.put("FECHA_DESDE", fechaDesde);
            parametros.put("FECHA_HASTA", fechaHasta);
            JasperReportUtils.runReportB("cierre_caja","/seguro/reporte/cierre_caja.jasper",parametros);
            return null;
        }catch(Exception ex){
            Logger.getLogger(CobranzasDelDiaBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private void limpiarVariables(){
        usuario=null;
        nombres=null;
        apellidos=null;
        fechaDesde=null;
        fechaHasta=null;
    }
    
    public String irVista(){
        limpiarVariables();
        return "cierreCaja";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioDTO getUsuarioSelect() {
        return usuarioSelect;
    }

    public void setUsuarioSelect(UsuarioDTO usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}
