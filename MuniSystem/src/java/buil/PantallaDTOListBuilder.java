package buil;

import dto.PantallaDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.RolPantalla;

public class PantallaDTOListBuilder {
    
    private List<PantallaDTO> pantallaDTOs;

    public PantallaDTOListBuilder() {
        pantallaDTOs = new ArrayList<>();
    }
    
    public PantallaDTOListBuilder rolPantallas(List<RolPantalla> rolPantallas){
        PantallaDTO pantallaDTO;
        for(RolPantalla rolPantalla : rolPantallas){
            pantallaDTO = new PantallaDTO();
            pantallaDTO.setNombre(rolPantalla.getIdPantalla().getDescripcion());
            pantallaDTO.setAlta(rolPantalla.isAlta());
            pantallaDTO.setConsultar(rolPantalla.isConsultar());
            pantallaDTO.setEditar(rolPantalla.isEditar());
            pantallaDTO.setEliminar(rolPantalla.isEliminar());
            pantallaDTOs.add(pantallaDTO);
        }
        return this;
    }
    
    public List<PantallaDTO> build(){
        return pantallaDTOs;
    }
}
