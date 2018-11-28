package controller;

import buil.RolDTOListBuilder;
import buil.UsuarioDTOBuilder;
import buil.UsuarioDTOListBuilder;
import dao.RolDAO;
import dao.UsuarioDAO;
import dto.RolDTO;
import dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Rol;
import jpa.Usuario;
import util.fabrica.Util;

public class UsuarioController {
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO(Util.getEm());
    private RolDAO rolDAO = new RolDAO(Util.getEm());
    
    public List<UsuarioDTO> getUsuarioAll(){
        List<Usuario> usuarios = usuarioDAO.getUsuarioAll();
        return new UsuarioDTOListBuilder().usuarios(usuarios).build();
    }
    
    public List<UsuarioDTO> getUsuarios(String desc, String cedula, String nombres, String apellidos){
        List<Usuario> usuarios = usuarioDAO.getUsuario(desc, cedula, nombres, apellidos);
        return new UsuarioDTOListBuilder().usuarios(usuarios).build();
    }
    
    public UsuarioDTO getNewUsuarioEmpty(){
        return new UsuarioDTOBuilder().build();
    }
    
    public void guardar(UsuarioDTO usuarioDTO){
        Util.getEm().getTransaction().begin();
        Usuario usuario = new Usuario();
        usuario.setDescripcion(usuarioDTO.getDesc());
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombres(usuarioDTO.getNombre());
        usuario.setApellidos(usuario.getApellidos());
        usuario.setActivo(Boolean.TRUE);
        usuario.setIdRol(rolDAO.getRolByDesc(usuarioDTO.getRolDesc()));
        usuarioDAO.guardar(usuario);
        Util.getEm().getTransaction().commit();
    }
    
    public void actualizar(UsuarioDTO usuarioDTO){
        Util.getEm().getTransaction().begin();
        Usuario usuario = usuarioDAO.getUsuario(usuarioDTO.getId());
        usuario.setDescripcion(usuarioDTO.getDesc());
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombres(usuarioDTO.getNombre());
        usuario.setApellidos(usuarioDTO.getApellido());
        usuario.setActivo(usuarioDTO.isActivo());
        usuario.setIdRol(rolDAO.getRolByDesc(usuarioDTO.getRolDesc()));
        usuarioDAO.actualizar(usuario);
        Util.getEm().getTransaction().commit();
    }
    
    public void eliminar(UsuarioDTO usuarioDTO){
        Util.getEm().getTransaction().begin();
            Usuario usuario = usuarioDAO.getUsuario(usuarioDTO.getId());
            usuarioDAO.eliminar(usuario);
        Util.getEm().getTransaction().commit();
    }
    
    public List<String> getNombresRoles(){
        List<String> nombres = new ArrayList<>();
        List<Rol> roles = rolDAO.getRolAll();
        List<RolDTO> rolDTOs = new RolDTOListBuilder().roles(roles).build();
        for(RolDTO rolDTO : rolDTOs){
            nombres.add(rolDTO.getDescripcion());
        }
        return nombres;
    }
}
