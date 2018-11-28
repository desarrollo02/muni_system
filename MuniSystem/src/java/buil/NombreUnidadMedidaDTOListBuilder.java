package buil;

import java.util.ArrayList;
import java.util.List;
import jpa.UnidadMedida;

public class NombreUnidadMedidaDTOListBuilder {
    
    public List<String> nombreUnidadMedidaDTOs;

    public NombreUnidadMedidaDTOListBuilder() {
        nombreUnidadMedidaDTOs = new ArrayList<>();
    }
    
    public List<String> build(){
        return nombreUnidadMedidaDTOs;
    }
    
    public NombreUnidadMedidaDTOListBuilder unidades(List<UnidadMedida> unidades){
        for(UnidadMedida unidadMedida: unidades){
            nombreUnidadMedidaDTOs.add(unidadMedida.getNombre());
        }
        return this;
    }
}
