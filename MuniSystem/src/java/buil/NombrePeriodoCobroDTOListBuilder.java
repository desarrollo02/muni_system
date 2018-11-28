package buil;

import java.util.ArrayList;
import java.util.List;
import jpa.PeriodoCobro;

public class NombrePeriodoCobroDTOListBuilder {
    
    private List<String> nombrePeriodoCobroDTOs;

    public NombrePeriodoCobroDTOListBuilder() {
        nombrePeriodoCobroDTOs = new ArrayList<>();
    }
    
    public List<String> build(){
        return nombrePeriodoCobroDTOs;
    }
    
    public NombrePeriodoCobroDTOListBuilder periodos(List<PeriodoCobro> perdiodos){
        for(PeriodoCobro periodo : perdiodos){
            nombrePeriodoCobroDTOs.add(periodo.getDescripcion());
        }
        return this;
    }

}
