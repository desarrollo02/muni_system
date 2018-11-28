package buil;

import dto.RolDTO;
import dto.RolListDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Rol;

public class RolDTOListBuilder {
    
    private List<RolDTO> rolListDTOs;

    public RolDTOListBuilder() {
        rolListDTOs = new ArrayList<>();
    }
    
    public RolDTOListBuilder roles(List<Rol> roles){
        RolDTO rolDTO;
        for(Rol rol : roles){
            rolDTO = new RolDTO();
            rolDTO.setIdRol(rol.getIdRol());
            rolDTO.setDescripcion(rol.getDescripcion());
            rolListDTOs.add(rolDTO);
        }
        return this;
    }
    
    public List<RolDTO> build(){
        return rolListDTOs;
    }
}
