package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Contribuyente;
import jpa.Marcas;
import jpa.Modelos;
import jpa.Vehiculo;
import jpa.VehiculoTipo;
import jpa.VehiculoValuacion;

public class VehiculoManager extends BaseManager{
    
    public boolean existeChapa(Vehiculo vehiculo){
        Query query = getEm().createQuery("select o from Vehiculo o where o.chapa = :chapa");
        query.setParameter("chapa", vehiculo.getChapa());
        List<Vehiculo> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdVehiculo().equals(vehiculo.getIdVehiculo())){
            return false;
        }else{
            return true;
        }
    }
    
    
    public List<String> getDescripcionTipoList(){
        return super.getEm().createQuery("select o.descripcion from VehiculoTipo o").getResultList();
    }
    
    public Double getValuacionVehiculo(Integer anio, Marcas marca, Modelos modelo, VehiculoTipo tipo){
        Query query = getEm().createQuery("select o from VehiculoValuacion o "
                + "where o.anio = :anio and o.idMarca = :marca and "
                + "o.idModelo = :modelo and o.idTipo = :tipo");
        query.setParameter("anio", anio);
        query.setParameter("marca", marca);
        query.setParameter("modelo", modelo);
        query.setParameter("tipo", tipo);
        VehiculoValuacion valuacion = (VehiculoValuacion) query.getSingleResult();
        return valuacion.getMonto();
    }
    
    public List<Vehiculo> filtrar(Integer rmc, String cedula, String chapa, 
            String tipo, String marca, String modelo){
        
        String sql = "Select o from Vehiculo o where 1=1";
        
        if(rmc != null && rmc > 0){
            sql = sql + " and o.idContribueyten.idContribuyente = :rmc"; 
        }
        
        if(cedula != null && !cedula.equals("0")){
            sql = sql + " and o.idContribuyente.cedula = :cedula"; 
        }
        
        if(chapa != null && !chapa.equals("")){
            sql = sql + " and upper(o.chapa) like :chapa";
        }
        
        if(tipo != null && !tipo.equals("")){
            sql = sql + " and upper(o.idVehiculoTipo.descripcion) like :tipo";
        }
        
        if(marca != null && !marca.equals("")){
            sql = sql + " and upper(o.idMarca.descripcion) like :marca";
        }
        
        if(modelo != null && !modelo.equals("")){
            sql = sql + " and upper(o.idModelo.descripcion) like :modelo";
        }
        
        Query query = super.getEm().createQuery(sql);
        
        if(rmc != null && rmc > 0){
            query.setParameter("rmc", rmc);
        }
        
        if(cedula != null && !cedula.equals("0")){
            query.setParameter("cedula", cedula);
        }
        
        if(chapa != null && !chapa.equals("")){
            query.setParameter("chapa", "%" + chapa.toUpperCase() + "%");
        }
        
        if(tipo != null && !tipo.equals("")){
            query.setParameter("tipo", "%" + tipo.toUpperCase() + "%");
        }
        
        if(marca != null && !marca.equals("")){
            query.setParameter("marca", "%"+marca.toUpperCase()+"%");
        }
        
        if(modelo != null && !modelo.equals("")){
            query.setParameter("modelo", "%"+ modelo.toUpperCase()+"%");
        }

        return query.getResultList();
    }
    
    public List<Contribuyente> getContribuyenteAll(){
        Query query = getEm().createQuery("select o from Contribuyente o");
        return query.getResultList();
    }
    
    public List<String> getDescripcionMarcaList(){
        return super.getEm().createQuery("select o.descripcion from Marcas o").getResultList();
    }
    
    public List<String> getDescripcionModeloList(){
        return super.getEm().createQuery("select o.descripcion from Modelos o").getResultList();
    }
    
    public void actualizar(Vehiculo entidad){
        super.getEm().getTransaction().begin();
        entidad.setIdValuacion(getValuacionVehiculo(entidad));
        super.getEm().merge(entidad);
        super.getEm().getTransaction().commit();
    }
    
    public VehiculoValuacion getValuacionVehiculo(Vehiculo vehiculo){
        Query query = getEm().createQuery("select o from VehiculoValuacion o "
                + "where o.anio = :anio and o.idMarca = :marca and "
                + "o.idModelo = :modelo and o.idTipo = :tipo");
        query.setParameter("anio", vehiculo.getAnio());
        query.setParameter("marca", vehiculo.getIdMarca());
        query.setParameter("modelo", vehiculo.getIdModelo());
        query.setParameter("tipo", vehiculo.getIdTipo());
        return (VehiculoValuacion) query.getSingleResult();
    }
    
    public void guardar(Vehiculo entidad){
        super.getEm().getTransaction().begin();
        entidad.setIdValuacion(getValuacionVehiculo(entidad));
        super.getEm().persist(entidad);
        super.getEm().getTransaction().commit();
     } 
}
