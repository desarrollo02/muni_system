/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.util.ArrayList;
import java.util.List;
import jpa.ComprobanteCabecera;
import manager.BaseManager;

/**
 *
 * @author USUARIO
 */
public class AnularFacturaManager extends BaseManager{
    
    private ComprobanteCabecera comprobante;
    private List<ComprobanteCabecera> comprobantes;
    
    public void anular(){
        comprobante.setAnulado(true);
        actualizar(comprobante);
    }
    
    public List<ComprobanteCabecera> getComprobantes(){
        comprobantes = new ArrayList<>();
        comprobantes.add(comprobante);
        return comprobantes;
    }
    
    public void setNroFactura(Integer nroFactura){
        comprobante = getEm().find(ComprobanteCabecera.class, nroFactura);
    }

    /**
     * @return the comprobante
     */
    public ComprobanteCabecera getComprobante() {
        return comprobante;
    }

    /**
     * @param comprobante the comprobante to set
     */
    public void setComprobante(ComprobanteCabecera comprobante) {
        this.comprobante = comprobante;
    }
    
}
