/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import jpa.ComprobanteCabecera;
import manager.BaseManager;

/**
 *
 * @author USUARIO
 */
public class PagarFacturaManager extends BaseManager{
    private Integer nroFactura;
    private Integer rmc;
    private String cedula;
    private ComprobanteCabecera comprobante;
    private List<ComprobanteCabecera> comprobantes;
    
    public boolean isVencido(){
        Date hoy = new Date();
        Calendar hoyCal = Calendar.getInstance();
        hoyCal.setTime(hoy);
        int diaHoy = hoyCal.get(Calendar.DAY_OF_MONTH);
        int mesHoy = hoyCal.get(Calendar.MONTH);
        int anioHoy =hoyCal.get(Calendar.YEAR);
        
        Calendar venci = Calendar.getInstance();
        venci.setTime(comprobante.getVencimiento());
        int diaVen = venci.get(Calendar.DAY_OF_MONTH);
        int mesVen = venci.get(Calendar.MONTH);
        int anioVen = venci.get(Calendar.YEAR);
        LocalDate loHoy = LocalDate.of(anioHoy, mesHoy + 1, diaHoy);
        LocalDate loVen = LocalDate.of(anioVen, mesVen + 1, diaVen);
        if(loHoy.equals(loVen)){
            return false;
        }
        if(comprobante.getVencimiento().before(hoy)){
            return true;
        }
        return false;
    }
    
    public void pagar(String usuario){
        comprobante.setPagado(true);
        comprobante.setUsuarioPago(usuario);
        comprobante.setFechaPago(new Date());
        actualizar(comprobante);
    }
    
    public List<ComprobanteCabecera> filtrar(){
        String sql = "select o from ComprobanteCabecera o where o.pagado = :pagado and anulado = :anulado";
        if(nroFactura != null){
            sql = sql + " and o.idComprobanteCabecera = :nroFactura";
        }
        
        if(rmc != null){
            sql = sql + " and o.idContribuyente.idContribuyente = :rmc"; 
        }
        
        if(cedula != null){
            sql = sql + " and o.idContribuyente.cedula = :cedula"; 
        }
        
        Query query = getEm().createQuery(sql);
        query.setParameter("anulado", false);
        query.setParameter("pagado",false);
        if(nroFactura != null){
            query.setParameter("nroFactura",nroFactura);
        }
        
        if(rmc != null){
            query.setParameter("rmc",rmc); 
        }
        
        if(cedula != null){
            query.setParameter("cedula",cedula); 
        }
        
        return query.getResultList();
    }
    
    
    public void setFiltro(Integer nroFactura, Integer rmc, String cedula){
        this.nroFactura = nroFactura;
        this.rmc = rmc;
        this.cedula = cedula;
    }
        
    public ComprobanteCabecera getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteCabecera comprobante) {
        this.comprobante = comprobante;
    }
}
