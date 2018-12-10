package controller;

import buil.FacturaDTOBuilder;
import dao.BaseCalculoDAO;
import dao.ComprobanteDAO;
import dto.FacturaDTO;
import factura.BaseCalculo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.ComprobanteCabecera;
import jpa.ComprobanteDetalle;
import util.fabrica.Util;

/**
 *
 * @author desarrollo2
 */
public class PagarFacController {
    
    private EntityManager em;
    private ComprobanteDAO comprobanteDAO;
    private BaseCalculoDAO baseCalculoDAO;

    public PagarFacController() {
        em = Util.getEm();
        comprobanteDAO = new ComprobanteDAO(em);
        baseCalculoDAO = new BaseCalculoDAO(em);
    }
    
    public List<FacturaDTO> getFacturas(Integer nroFactura, Integer rmc, Integer anio, String nombreTributo){
        List<ComprobanteCabecera> comprobantes = comprobanteDAO.getComprobantes(nroFactura, rmc, anio, nombreTributo);
        List<FacturaDTO> facturas = new ArrayList<>();
        FacturaDTO factura;
        FacturaDTOBuilder factuaDTOBuilder;
        List<ComprobanteDetalle> compDetalles;
        BaseCalculo listaBase=null;
        for(ComprobanteCabecera compCabecera : comprobantes){
            compDetalles = comprobanteDAO.getComprobanteDetalles(compCabecera);
            factuaDTOBuilder = new FacturaDTOBuilder();
            if(compCabecera.getIdTributo().isRegistrar().equals("INMUEBLE")){
                listaBase = baseCalculoDAO.getBaseCalculoInmueble(compCabecera.getId_ref());
            }else if(compCabecera.getIdTributo().isRegistrar().equals("PATENTE")){
                listaBase = baseCalculoDAO.getBaseCalculoPatenteComercial(compCabecera.getId_ref());
            }else if(compCabecera.getIdTributo().isRegistrar().equals("CEMENTERIO")){
                listaBase = baseCalculoDAO.getBaseCalculoLoteCementerio(compCabecera.getId_ref());
            }else if(compCabecera.getIdTributo().isRegistrar().equals("VEHICULO")){
                listaBase = baseCalculoDAO.getBaseCalculoHabilitacionVehiculo(compCabecera.getId_ref());
            }else if(compCabecera.getIdTributo().isRegistrar().equals("REGISTRO")){
                 listaBase = baseCalculoDAO.getBaseCalculoRegistroConducir(compCabecera.getId_ref());
            }
            factura = factuaDTOBuilder.caberera(compCabecera).descripcionCalculo(listaBase.getDescripcionCalculo()).build();
            for(ComprobanteDetalle compDetalle : compDetalles){
                factura= factuaDTOBuilder.addDetalle(compDetalle).build();
            }
            facturas.add(factura);
        }
        return facturas;
    }
    
    public void pagar(FacturaDTO facturaDTO, String formaPago, String nroCheque)throws SQLException{
        em.getTransaction().begin();
            comprobanteDAO.pagar(facturaDTO.getNroFactura(), formaPago, nroCheque);
        em.getTransaction().commit();
    }
    
    public void rollbackTransaccion(){
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }    
    }
}
