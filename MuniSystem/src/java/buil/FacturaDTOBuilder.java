package buil;

import dto.FacturaDTO;
import dto.FacturaDetalleDTO;
import java.util.ArrayList;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;

public class FacturaDTOBuilder {
    
    private FacturaDTO facturaDTO;

    public FacturaDTOBuilder() {
        facturaDTO = new FacturaDTO();
        facturaDTO.setTotal(0.0);
        facturaDTO.setDetalles(new ArrayList<>());
    }
    
    public FacturaDTOBuilder caberera(ComprobanteCabecera cabecera){
        facturaDTO.setNroFactura(cabecera.getIdComprobanteCabecera());
        facturaDTO.setAnio(cabecera.getAnio());
        facturaDTO.setNombreTributo(cabecera.getIdTributo().getNombre());
        facturaDTO.setReferencia(cabecera.getId_ref());
        facturaDTO.setConcepto(cabecera.getIdTributo().getNombre() + " " + cabecera.getAnio());
        facturaDTO.setVencimiento(cabecera.getVencimiento());
        return this;
    }
    
    public FacturaDTOBuilder addDetalle(ComprobanteDetalle detalle){
        FacturaDetalleDTO facturaDetalleDTO = new FacturaDetalleDTO();
        if(detalle.getEsMulta()){
            facturaDetalleDTO.setConcepto("Multa " + detalle.getIdTributo().getNombre());
        }else{
            facturaDetalleDTO.setConcepto(detalle.getIdTributo().getNombre());
        }
        
        facturaDetalleDTO.setMonto(detalle.getMonto());
        facturaDetalleDTO.setReferencia(detalle.getIdComprobanteCab().getId_ref());
        facturaDTO.getDetalles().add(facturaDetalleDTO);
        facturaDTO.setTotal(facturaDTO.getTotal() + detalle.getMonto());
        return this;
    }
    
    public FacturaDTO build(){
        return facturaDTO;
    }
    
    public FacturaDTOBuilder descripcionCalculo(String descripcionCalculo){
        facturaDTO.setVariablesParaCalculo(descripcionCalculo);
        return this;
    }
}
