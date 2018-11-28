package buil;

import dto.MultaDTO;
import jpa.TributoMulta;

public class MultaDTOBuilder {

    private MultaDTO multaDTO;

    public MultaDTOBuilder() {
        multaDTO = new MultaDTO();
    }
    
    public MultaDTO build(){
        return multaDTO;
    }
    
    public MultaDTOBuilder idMulta(Integer idMulta){
        multaDTO.setIdMulta(idMulta);
        return this;
    }
    
    public MultaDTOBuilder keyMulta(String key){
        multaDTO.setKey(key);
        return this;
    }
    
    public MultaDTOBuilder multa(TributoMulta tributoMulta){
        multaDTO.setKey(tributoMulta.getIdTributoMulta().toString());
        multaDTO.setIdMulta(tributoMulta.getIdTributoMulta());
        multaDTO.setDiasMax(tributoMulta.getDiasMax());
        multaDTO.setDiasMin(tributoMulta.getDiasMin());
        multaDTO.setValor(tributoMulta.getValor());
        multaDTO.setUnidadMedida(tributoMulta.getIdUnidadMedida().getNombre());
        return this;
    }
}
