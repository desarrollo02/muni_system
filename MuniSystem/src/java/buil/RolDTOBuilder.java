package buil;

import dto.PantallaDTO;
import dto.RolDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Pantalla;
import jpa.Rol;
import jpa.RolPantalla;

public class RolDTOBuilder {

    private RolDTO rolDto;

    public RolDTOBuilder() {
        rolDto = new RolDTO();
    }
    
    public RolDTOBuilder rol(Rol rol){
        rolDto.setIdRol(rol.getIdRol());
        rolDto.setDescripcion(rol.getDescripcion());
        return this;
    }
    
    public RolDTOBuilder pantallas(List<RolPantalla> rolPantallas){
        List<PantallaDTO> pantallas = new ArrayList<>();
        PantallaDTO pantallaDTO;
        for(RolPantalla rolPantalla : rolPantallas){
            pantallaDTO = new PantallaDTO();
            pantallaDTO.setNombre(rolPantalla.getIdPantalla().getDescripcion());
            pantallaDTO.setAlta(rolPantalla.isAlta());
            pantallaDTO.setEditar(rolPantalla.isEditar());
            pantallaDTO.setConsultar(rolPantalla.isConsultar());
            pantallaDTO.setEliminar(rolPantalla.isEliminar());
            pantallas.add(pantallaDTO);
        }
        rolDto.setPantallas(pantallas);
        return this;
    }
    
    public RolDTOBuilder pantallasAll(List<Pantalla> pantallas){
        List<PantallaDTO> pantallasDTOs = new ArrayList<>();
        PantallaDTO pantallaDTO;
        for(Pantalla pantalla : pantallas){
            pantallaDTO = new PantallaDTO();
            pantallaDTO.setNombre(pantalla.getDescripcion());
            pantallaDTO.setAlta(false);
            pantallaDTO.setEditar(false);
            pantallaDTO.setConsultar(false);
            pantallaDTO.setEliminar(false);
            pantallasDTOs.add(pantallaDTO);
        }
        rolDto.setPantallas(pantallasDTOs);
        return this;
    }
    
    public RolDTO buil(){
        return rolDto;
    }
}
