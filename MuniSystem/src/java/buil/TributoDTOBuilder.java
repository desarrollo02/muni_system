package buil;

import dto.TributoDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Tributo;
import jpa.TributoMulta;

public class TributoDTOBuilder {
    
    private TributoDTO tributoDTO;

    public TributoDTOBuilder() {
        tributoDTO = new TributoDTO();
        tributoDTO.setMultas(new ArrayList<>());
        tributoDTO.setTributosAnexos(new ArrayList<>());
    }
    
    public TributoDTO build(){
        return tributoDTO;
    }
    
    public TributoDTOBuilder tributo(Tributo tributo){
        tributoDTO.setNombre(tributo.getNombre());
        tributoDTO.setTipo(tributo.getTipo());
        tributoDTO.setPeriodo(tributo.getIdPeriodoCobro().getDescripcion());
        tributoDTO.setPrimerVencimiento(tributo.getPrimerVencimiento());
        tributoDTO.setRegistrar(tributo.isRegistrar());
        if(tributo.getIdUnidadMedida() != null){
            tributoDTO.setUnidadMedida(tributo.getIdUnidadMedida().getNombre());
        }    
        tributoDTO.setValor(tributo.getValor());
        return this;
    }
    
    public TributoDTOBuilder emptyTributo(Tributo tributo){
        tributoDTO.setNombre(tributo.getNombre());
        tributoDTO.setTipo(tributo.getTipo());
        tributoDTO.setPeriodo(null);
        tributoDTO.setPrimerVencimiento(tributo.getPrimerVencimiento());
        return this;
    }

    public TributoDTOBuilder multas(List<TributoMulta> tributoMultas){
        tributoDTO.setMultas(new MultaDTOListBuilder().tributoMultas(tributoMultas).build());
        return this;
    }
    
    public TributoDTOBuilder tributosAnexos(List<Tributo> tributos){
        tributoDTO.setTributosAnexos(new NombreTributoDTOListBuilder().tributos(tributos).build());
        return this;
    }
}
