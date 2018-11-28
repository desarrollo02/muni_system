package buil;

import dto.MultaDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.TributoMulta;

public class MultaDTOListBuilder {
    
    private List<MultaDTO> multaDTOs;

    public MultaDTOListBuilder() {
        multaDTOs = new ArrayList<>();
    }
    
    public List<MultaDTO> build(){
        return multaDTOs;
    }
    
    public MultaDTOListBuilder tributoMultas(List<TributoMulta> tributoMultas){
        for(TributoMulta tributoMulta : tributoMultas){
            multaDTOs.add(new MultaDTOBuilder().multa(tributoMulta).build());
        }
        return this;
    }
}
