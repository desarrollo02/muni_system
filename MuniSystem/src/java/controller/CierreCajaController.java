package controller;

import buil.UsuarioDTOListBuilder;
import dao.ComprobanteDAO;
import dao.UsuarioDAO;
import dto.UsuarioDTO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.Usuario;
import util.fabrica.Util;

public class CierreCajaController {
    
    private EntityManager em;
    private UsuarioDAO usuarioDAO;
    private ComprobanteDAO comprobanteDAO;

    public CierreCajaController() {
        em = Util.getEm();
        usuarioDAO = new UsuarioDAO(em);
        comprobanteDAO = new ComprobanteDAO(em);
    }
    
    public List<UsuarioDTO> getUsuarios(String usuario, String cedula,
                                        String nombres, String apellidos){
        List<Usuario> usuarios = usuarioDAO.getUsuario(usuario, cedula, nombres, apellidos);
        return new UsuarioDTOListBuilder().usuarios(usuarios).build();
    }
    
    public Double getTotalEfectivo(Date desde, Date hasta, String usuario){
        return comprobanteDAO.getTotal(desde, hasta, "E", usuario);
    }
    
    public Double getTotalCheque(Date desde, Date hasta, String usuario){
        return comprobanteDAO.getTotal(desde, hasta, "C", usuario);
    }
    
    public Double getTotalTarjetaCredito(Date desde, Date hasta, String usuario){
        return comprobanteDAO.getTotal(desde, hasta, "T", usuario);
    }
    
    public Double getTotalTarjetaDebito(Date desde, Date hasta, String usuario){
        return comprobanteDAO.getTotal(desde, hasta, "P", usuario);
    }
}
