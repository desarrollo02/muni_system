package controller;

import buil.RolDTOListBuilder;
import buil.PantallaDTOListBuilder;
import buil.RolDTOBuilder;
import dao.PantallaDAO;
import dao.RolDAO;
import dao.RolPantallaDAO;
import dto.PantallaDTO;
import dto.RolDTO;
import java.util.List;
import jpa.Rol;
import jpa.RolPantalla;
import util.fabrica.Util;

public class RolController {
    
    private RolDAO rolDAO = new RolDAO(Util.getEm());
    private PantallaDAO pantallaDAO = new PantallaDAO(Util.getEm());
    private RolPantallaDAO rolPantallaDAO = new RolPantallaDAO(Util.getEm());
    
    public List<RolDTO> getRolAll(){
        List<Rol> roles = rolDAO.getRolAll();
        return new RolDTOListBuilder().roles(roles).build();
    }
    
    public List<RolDTO> getRoles(String filtro){
        List<Rol> roles = rolDAO.getRol(filtro);
        return new RolDTOListBuilder().roles(roles).build();
    }
    
    public List<PantallaDTO> getRolPantallas(RolDTO rolDTO){
        Rol rol = rolDAO.getRol(rolDTO.getIdRol());
        List<RolPantalla> rolPantallas = rolPantallaDAO.getRolPantalla(rol);
        return new PantallaDTOListBuilder().rolPantallas(rolPantallas).build();
    }
    
    public void guardar(RolDTO rolDTO){
        Util.getEm().getTransaction().begin();
        Rol rol = new Rol();
        rol.setDescripcion(rolDTO.getDescripcion());
        rolDAO.guardar(rol);
        RolPantalla rolPantalla;
        for(PantallaDTO pantallaDTO : rolDTO.getPantallas()){
            rolPantalla = new RolPantalla();
            rolPantalla.setIdRol(rol);
            rolPantalla.setIdPantalla(pantallaDAO.getPantalla(pantallaDTO.getNombre()));
            rolPantalla.setAlta(pantallaDTO.isAlta());
            rolPantalla.setEditar(pantallaDTO.isEditar());
            rolPantalla.setConsultar(pantallaDTO.isConsultar());
            rolPantalla.setEliminar(pantallaDTO.isEliminar());
            rolPantallaDAO.guardar(rolPantalla);
        }
        Util.getEm().getTransaction().commit();
    }
    
    public void actualizar(RolDTO rolDTO){
        Util.getEm().getTransaction().begin();
        Rol rol = rolDAO.getRol(rolDTO.getIdRol());
        rol.setDescripcion(rolDTO.getDescripcion());
        rolDAO.actualizar(rol);
        rolPantallaDAO.eliminar(rol);
        RolPantalla rolPantalla;
        for(PantallaDTO pantallaDTO : rolDTO.getPantallas()){
            rolPantalla = new RolPantalla();
            rolPantalla.setIdRol(rol);
            rolPantalla.setIdPantalla(pantallaDAO.getPantalla(pantallaDTO.getNombre()));
            rolPantalla.setAlta(pantallaDTO.isAlta());
            rolPantalla.setEditar(pantallaDTO.isEditar());
            rolPantalla.setConsultar(pantallaDTO.isConsultar());
            rolPantalla.setEliminar(pantallaDTO.isEliminar());
            rolPantallaDAO.guardar(rolPantalla);
        }
        Util.getEm().getTransaction().commit();
    }
    
    public void eliminar(RolDTO rolDTO){
        Util.getEm().getTransaction().begin();
            Rol rol = rolDAO.getRol(rolDTO.getIdRol());
            rolPantallaDAO.eliminar(rol);
            rolDAO.eliminar(rol);
        Util.getEm().getTransaction().commit();
    }    
    
    public RolDTO getNewRolEmpty(){
         return new RolDTOBuilder().buil();
    }
    
    public RolDTO getNewRolPantallasAll(){
         return new RolDTOBuilder().rol(new Rol()).pantallasAll(pantallaDAO.getPantallaAll()).buil();
    }
}
