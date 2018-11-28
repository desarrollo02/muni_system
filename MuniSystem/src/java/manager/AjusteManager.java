package manager;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import jpa.Cementerio;
import jpa.CementerioAjuste;
import jpa.Inmueble;
import jpa.InmuebleValuacionAjuste;
import jpa.VehiculoValuacion;
import jpa.VehiculoValuacionAjuste;

public class AjusteManager extends BaseManager{
    
    private Integer ajuste;
    private String tipo;
    private Integer anio;
    
    public void ajustar(){
        if(tipo.equals("INMOBILIARIO")){
            ajustarInmobiliario();
        }else if(tipo.equals("CEMENTERIO")){
            ajustarCementerio();
        }else if(tipo.equals("HABILITACION")){
            ajustarValuacionVehiculos();
        }
    }
    
    public List<InmuebleValuacionAjuste> getResultadoInmueblesValuaciones(Integer anio){
        Query query = getEm().createQuery("select o from InmuebleValuacionAjuste o where o.anio = :anio");
        query.setParameter("anio", anio);
        return query.getResultList();
    }
    
    public List<CementerioAjuste> getResultadoCementeriosValuaicones(Integer anio){
        Query query = getEm().createQuery("select o from CementerioAjuste o where o.anio = :anio");
        query.setParameter("anio", anio);
        return query.getResultList();
    }
    
    public List<VehiculoValuacionAjuste> getResultadoVehiculoValuaciones(Integer anio){
        Query query = getEm().createQuery("select o from VehiculoValuacionAjuste o where o.anio = :anio");
        query.setParameter("anio", anio);
        return query.getResultList();
    }
    
    private void ajustarInmobiliario(){
        Query query = getEm().createQuery("select o from Inmueble o");
        List<Inmueble> inmuebles = query.getResultList();
        Double nuevaValuacion = 0.0;
        InmuebleValuacionAjuste ajusteValuacion;
        getEm().getTransaction().begin();
        for(Inmueble inmueble : inmuebles){
            ajusteValuacion = new InmuebleValuacionAjuste();
            nuevaValuacion = inmueble.getValuacionFiscal() + inmueble.getValuacionFiscal() * ajuste/100;
            ajusteValuacion.setValorViejoMonto(inmueble.getValuacionFiscal());
            inmueble.setValuacionFiscal(nuevaValuacion);
            ajusteValuacion.setAnio(anio);
            ajusteValuacion.setFechaAlta(new Date());
            ajusteValuacion.setIdInmueble(inmueble);
            ajusteValuacion.setPorcentajeAjuste(ajuste);
            ajusteValuacion.setValorNuevoMonto(nuevaValuacion);
            getEm().persist(ajusteValuacion);
            getEm().merge(inmueble);
        }
        getEm().getTransaction().commit();
    }
    
    private void ajustarCementerio(){
        Query query = getEm().createQuery("select o from Cementerio o");
        List<Cementerio> cementerios = query.getResultList();
        Double nuevaValuacion = 0.0;
        CementerioAjuste ajusteCementerio;
        getEm().getTransaction().begin();
        for(Cementerio cementerio : cementerios){
            ajusteCementerio = new CementerioAjuste();
            ajusteCementerio.setValorViejoMonto(cementerio.getValuacion());
            nuevaValuacion = cementerio.getValuacion() + cementerio.getValuacion() * ajuste/100;
            cementerio.setValuacion(nuevaValuacion);
            getEm().merge(cementerio);
            ajusteCementerio.setAnio(anio);
            ajusteCementerio.setFechaAlta(new Date());
            ajusteCementerio.setIdCementerio(cementerio);
            ajusteCementerio.setPorcentajeAjuste(ajuste);
            ajusteCementerio.setValorNeuvoMonto(nuevaValuacion);
            getEm().persist(ajusteCementerio);
            getEm().merge(cementerio);
        }
        getEm().getTransaction().commit();
    }
    
    private void ajustarValuacionVehiculos(){
        Query query = getEm().createQuery("select o from VehiculoValuacion o");
        List<VehiculoValuacion> vehiculos = query.getResultList();
        Double nuevaValuacion = 0.0;
        VehiculoValuacionAjuste vehiculoValuacionAjuste;
        getEm().getTransaction().begin();
        for(VehiculoValuacion vehiculo : vehiculos){
            vehiculoValuacionAjuste = new VehiculoValuacionAjuste();
            vehiculoValuacionAjuste.setValorViejoMonto(vehiculo.getMonto());
            nuevaValuacion = vehiculo.getMonto() + vehiculo.getMonto() * ajuste/100;
            vehiculo.setMonto(nuevaValuacion);
            getEm().merge(vehiculo);
            vehiculoValuacionAjuste.setPorcentajeAjuste(ajuste);
            vehiculoValuacionAjuste.setAnio(anio);
            vehiculoValuacionAjuste.setFechaAlta(new Date());
            vehiculoValuacionAjuste.setIdVehiculoValuacion(vehiculo);
            vehiculoValuacionAjuste.setValorNuevoMonto(nuevaValuacion);
            getEm().persist(vehiculoValuacionAjuste);
        }
        getEm().getTransaction().commit();
    }

    public Integer getAjuste() {
        return ajuste;
    }

    public void setAjuste(Integer ajuste) {
        this.ajuste = ajuste;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }
    
}
