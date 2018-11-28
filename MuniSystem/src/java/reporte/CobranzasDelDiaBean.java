package reporte;

import bean.MensajeBean;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import reporte.manager.CobranzasDelDiaManager;
import util.JasperReportUtils;

@ManagedBean(name = "cobranzasDelDiaBean")
@SessionScoped
public class CobranzasDelDiaBean extends MensajeBean implements Serializable {

    private String filtroUsuario;
    private Date fechaDesde;
    private Date fechaHasta;
    private CobranzasDelDiaManager manager = new CobranzasDelDiaManager();
    
    
    public String descargarReporte(){
        try {
            Double totalEfectivo = manager.getTotal(fechaDesde, fechaHasta,"E", filtroUsuario);
            Double totalCheque = manager.getTotal(fechaDesde, fechaHasta,"C", filtroUsuario);
            Double totalTarjetaCredito = manager.getTotal(fechaDesde, fechaHasta,"T", filtroUsuario);
            Double totalTarjetaDebito = manager.getTotal(fechaDesde, fechaHasta,"P", filtroUsuario);
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("FECHA_ACTUAL",new Date());
            parametros.put("USUARIO", super.getUsuario().getDescripcion());
            parametros.put("NOMBRE_COMPLETO", super.getUsuario().getDescripcion());
            parametros.put("TOTAL_EFECTIVO", totalEfectivo);
            parametros.put("TOTAL_CHEQUE", totalCheque);
            parametros.put("TOTAL_TARJETA_DEBITO", totalTarjetaDebito);
            parametros.put("TOTAL_TARJETA_CREDITO", totalTarjetaCredito);
            JasperReportUtils.runReportB("cierre_caja","/seguro/reporte/cierre_caja.jasper",parametros);
            return null;
        }catch(Exception ex){
            Logger.getLogger(CobranzasDelDiaBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String irVista(){
        return "cobranzas_del_dia";
    }
    
    public CobranzasDelDiaBean() {
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

    public String getFiltroUsuario() {
        return filtroUsuario;
    }

    public void setFiltroUsuario(String filtroUsuario) {
        this.filtroUsuario = filtroUsuario;
    }    
}
