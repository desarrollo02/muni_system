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
        if(cabecera.getIdContribuyente().getPersonaJuridica()){
            String datos = "Empresa " + cabecera.getIdContribuyente().getRazonSocial() + ", RUC " + cabecera.getIdContribuyente().getRuc();
            facturaDTO.setContribuyente(datos);
        }else{
            String datos2 = "C.I.N°:" + cabecera.getIdContribuyente().getCedula() + 
                    ", Nombres: " +cabecera.getIdContribuyente().getNombres() +
                    ", Apellidos: " + cabecera.getIdContribuyente().getApellidos();
            facturaDTO.setContribuyente(datos2);
        }
        facturaDTO.setVencimiento(cabecera.getVencimiento());
        if(cabecera.getPagado() != null && cabecera.getPagado()){
            facturaDTO.setPagado("Si");
        }else{
            facturaDTO.setPagado("No");
        }
        
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
