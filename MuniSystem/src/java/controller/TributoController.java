package controller;

import buil.MultaDTOBuilder;
import buil.NombrePeriodoCobroDTOListBuilder;
import buil.NombreTributoDTOListBuilder;
import buil.NombreUnidadMedidaDTOListBuilder;
import buil.TributoDTOBuilder;
import buil.TributoDTOListBuilder;
import dao.MultaDAO;
import dao.PeriodoCobroDAO;
import dao.TributoDAO;
import dao.UnidadMedidaDAO;
import dto.MultaDTO;
import dao.TributoAnexoDAO;
import dto.TributoDTO;
import java.util.List;
import javax.persistence.EntityManager;
import jpa.PeriodoCobro;
import jpa.Tributo;
import jpa.TributoDetalle;
import jpa.TributoMulta;
import jpa.UnidadMedida;
import util.fabrica.Util;

public class TributoController {
    
    private EntityManager em;
    private TributoDAO tributoDAO;
    private PeriodoCobroDAO periodoCobroDAO;
    private MultaDAO multaDAO;
    private UnidadMedidaDAO unidadMedidaDAO;
    private TributoAnexoDAO tributoAnexoDAO;

    public TributoController() {
        em = Util.getEm();
        tributoDAO = new TributoDAO(em);
        periodoCobroDAO = new PeriodoCobroDAO(em);
        multaDAO = new MultaDAO(em);
        unidadMedidaDAO = new UnidadMedidaDAO(em);
        tributoAnexoDAO = new TributoAnexoDAO(em);
    }
    
    public List<TributoDTO> getTributoAll(){
        List<Tributo> tributos = tributoDAO.getTributoAll();
        return new TributoDTOListBuilder().tributos(tributos).build();
    }
    
    public TributoDTO getNewTributo(){
         return new TributoDTOBuilder().emptyTributo(new Tributo()).build();
    }
    
    public List<String> getNombrePeriodosAll(){
        List<PeriodoCobro> periodos = periodoCobroDAO.getPeriodoCobroAll();
        return new NombrePeriodoCobroDTOListBuilder().periodos(periodos).build();
    }
    
    public List<TributoDTO> getTributos(String nombre, String tipo){
        List<Tributo> tributos = tributoDAO.getTributos(nombre, tipo);
        return new TributoDTOListBuilder().tributos(tributos).build();
    }
    
    public MultaDTO newMultaEmpty(Integer key){
        return new MultaDTOBuilder().keyMulta(key.toString()).build();
    }
    
    public List<String> getNombreUnidadMedidaAll(){
        List<UnidadMedida> unidades = unidadMedidaDAO.getUnidadMedidaAll();
        return new NombreUnidadMedidaDTOListBuilder().unidades(unidades).build();
    }
    
    public List<String> getNombreTributoAll(){
        List<Tributo> tributos = tributoDAO.getTributoAnexoAll();
        return new NombreTributoDTOListBuilder().tributos(tributos).build();
    }
    
    public void guardarTributo(TributoDTO tributoDTO){
        em.getTransaction().begin();
            Tributo tributo = new Tributo();
            tributo.setNombre(tributoDTO.getNombre());
            tributo.setDescripcion(null);
            tributo.setIdPeriodoCobro(periodoCobroDAO.getPeriodoCobro(tributoDTO.getPeriodo()));
            tributo.setTipo(tributoDTO.getTipo());
            tributo.setPrimerVencimiento(tributoDTO.getPrimerVencimiento());
            tributoDAO.guardar(tributo);
            TributoMulta tributoMulta;
            for(MultaDTO multa : tributoDTO.getMultas()){
                tributoMulta = new TributoMulta();
                tributoMulta.setIdUnidadMedida(unidadMedidaDAO.getUnidadMedida(multa.getUnidadMedida()));
                tributoMulta.setValor(multa.getValor());
                tributoMulta.setDiasMin(multa.getDiasMin());
                tributoMulta.setDiasMax(multa.getDiasMax());
                tributoMulta.setIdTributo(tributo);
                multaDAO.guardar(tributoMulta);
            }
            TributoDetalle tributoAnexo;
            for(String nombreTributo : tributoDTO.getTributosAnexos()){
                tributoAnexo = new TributoDetalle();
                tributoAnexo.setIdTributoBase(tributo);
                tributoAnexo.setIdTributoAgregado(tributoDAO.getTributo(nombreTributo));
                tributoAnexoDAO.guardar(tributoAnexo);
            }
        em.getTransaction().commit();
    }
    
    public void eliminar(TributoDTO tributoDTO){
        em.getTransaction().begin();
            Tributo tributo = tributoDAO.getTributo(tributoDTO.getNombre());
            tributoAnexoDAO.eliminarAnexos(tributo);
            multaDAO.eliminarMultas(tributo);
            tributoDAO.eliminar(tributo);
        em.getTransaction().commit();
    }
    
    public void revertirTransaccion(){
        em.getTransaction().rollback();
    }
    
    public void actualizarTributo(TributoDTO tributoDTO){
        em.getTransaction().begin();
            Tributo tributo = tributoDAO.getTributo(tributoDTO.getNombre());
            tributo.setNombre(tributoDTO.getNombre());
            tributo.setDescripcion(null);
            tributo.setIdPeriodoCobro(periodoCobroDAO.getPeriodoCobro(tributoDTO.getPeriodo()));
            tributo.setTipo(tributoDTO.getTipo());
            tributo.setPrimerVencimiento(tributoDTO.getPrimerVencimiento());
            tributo.setRegistrar(tributoDTO.getRegistrar());
            tributoDAO.actualizar(tributo);
            TributoMulta tributoMulta;
            multaDAO.eliminarMultas(tributo);
            for(MultaDTO multa : tributoDTO.getMultas()){
                tributoMulta = new TributoMulta();
                tributoMulta.setIdUnidadMedida(unidadMedidaDAO.getUnidadMedida(multa.getUnidadMedida()));
                tributoMulta.setValor(multa.getValor());
                tributoMulta.setDiasMin(multa.getDiasMin());
                tributoMulta.setDiasMax(multa.getDiasMax());
                tributoMulta.setIdTributo(tributo);
                multaDAO.guardar(tributoMulta);
            }
            tributoAnexoDAO.eliminarAnexos(tributo);
            TributoDetalle tributoAnexo;
            for(String nombreTributo : tributoDTO.getTributosAnexos()){
                tributoAnexo = new TributoDetalle();
                tributoAnexo.setIdTributoBase(tributo);
                tributoAnexo.setIdTributoAgregado(tributoDAO.getTributo(nombreTributo));
                tributoAnexoDAO.guardar(tributoAnexo);
            }
        em.getTransaction().commit();
    }
}
