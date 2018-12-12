package buil;

import dto.IngresoDTO;
import jpa.Tributo;

public class IngresoDTOBuilder {
    
    private IngresoDTO ingresoDTO;

    public IngresoDTOBuilder() {
        ingresoDTO = new IngresoDTO();
    }
    
    public IngresoDTOBuilder tributo(Tributo tributo){
        ingresoDTO.setTributo(tributo.getNombre());
        return this;
    }
    
    public IngresoDTOBuilder anio(Integer anio){
        ingresoDTO.setAnio(anio);
        return this;
    }
    
    public IngresoDTOBuilder montoEstimadio(Double monto){
        ingresoDTO.setMontoEstimado(monto);
        return this;
    }
    
    public IngresoDTOBuilder montoIngreso(Double monto){
        ingresoDTO.setMontoIngreso(monto);
        return this;
    }
    
    public IngresoDTOBuilder montoFaltante(Double monto){
        ingresoDTO.setMontoFaltante(monto);
        return this;
    }
    
    public IngresoDTO build(){
        return ingresoDTO;
    }
}
