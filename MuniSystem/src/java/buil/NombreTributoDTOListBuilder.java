package buil;

import java.util.ArrayList;
import java.util.List;
import jpa.Tributo;

public class NombreTributoDTOListBuilder {

    private List<String> nombreTributoDTOs;

    public NombreTributoDTOListBuilder() {
        nombreTributoDTOs = new ArrayList<>();
    }
    
    public List<String> build(){
        return nombreTributoDTOs;
    }
    
    public NombreTributoDTOListBuilder tributos(List<Tributo> tributos){
        for(Tributo tributo : tributos){
            nombreTributoDTOs.add(tributo.getNombre());
        }
        return this;
    }
}
