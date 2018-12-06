package buil;

import dto.TributoFacturableDTO;
import enumerados.TributoConRegistro;
import factura.BaseCalculo;

public class TributoFacturableDTOBuilder {
    
    private TributoFacturableDTO tributoFacturableDTO;

    public TributoFacturableDTOBuilder() {
        tributoFacturableDTO = new TributoFacturableDTO();
    }
    
    public TributoFacturableDTOBuilder baseCalculo(BaseCalculo baseCalculo){
        tributoFacturableDTO.setIdRef(baseCalculo.getIdRef());
        tributoFacturableDTO.setDescripcion(baseCalculo.getDescripcionCalculo());
        return this;
    }
    
    public TributoFacturableDTOBuilder registro(TributoConRegistro tributo){
        tributoFacturableDTO.setLugarRegistro(tributo.name());
        return this;
    }
    
    public TributoFacturableDTO build(){
        return tributoFacturableDTO;
    }
}
