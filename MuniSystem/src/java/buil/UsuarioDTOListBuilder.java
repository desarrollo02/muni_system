package buil;

import dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Usuario;

public class UsuarioDTOListBuilder {
    
    private List<UsuarioDTO> usuarioDTOs;

    public UsuarioDTOListBuilder() {
        usuarioDTOs = new ArrayList<>();
    }
    
    public List<UsuarioDTO> build(){
        return usuarioDTOs;
    }
    
    public UsuarioDTOListBuilder usuarios(List<Usuario> usuarios){
        UsuarioDTO usuarioDTO;
        for(Usuario usuario : usuarios){
            usuarioDTO = new UsuarioDTOBuilder().usuario(usuario).build();
            usuarioDTOs.add(usuarioDTO);
        }
        return this;
    }
}
