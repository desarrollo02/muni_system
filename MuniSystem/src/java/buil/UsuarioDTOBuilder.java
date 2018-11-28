package buil;

import dto.UsuarioDTO;
import jpa.Usuario;

public class UsuarioDTOBuilder {
    
    private UsuarioDTO usuarioDTO;

    public UsuarioDTOBuilder() {
        usuarioDTO = new UsuarioDTO();
    }
    
    public UsuarioDTO build(){
        return usuarioDTO;
    }
    
    public UsuarioDTOBuilder usuario(Usuario usuario){
        usuarioDTO.setId(usuario.getIdUsuario());
        usuarioDTO.setDesc(usuario.getDescripcion());
        usuarioDTO.setCedula(usuario.getCedula());
        usuarioDTO.setNombre(usuario.getNombres());
        usuarioDTO.setApellido(usuario.getApellidos());
        usuarioDTO.setRolDesc(usuario.getIdRol().getDescripcion());
        usuarioDTO.setRolId(usuario.getIdUsuario());
        usuarioDTO.setActivo(usuario.getActivo());
        return this;
    }
}
