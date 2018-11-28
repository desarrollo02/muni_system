package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Comercio;
import jpa.Contribuyente;

public class ComercioManager extends BaseManager{
    
    public boolean existeNroPatente(Comercio comercio){
        Query query = getEm().createQuery("select o from Comercio o where o.nroPatente = :nroPatente");
        query.setParameter("nroPatente", comercio.getNroPatente());
        List<Comercio> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdComercio().equals(comercio.getIdComercio())){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean existeNombreComercio(Comercio comercio){
        Query query = getEm().createQuery("select o from Comercio o where o.nombreFantasia = :nombre");
        query.setParameter("nombre", comercio.getNombreFantasia());
        List<Comercio> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdComercio().equals(comercio.getIdComercio())){
            return false;
        }else{
            return true;
        }
    }
    
    public List<String> getDescripcionComercioRubroList(){
        return super.getEm().createQuery("select o.descripcion from ComercioRubro o").getResultList();
    }
    
    public List<Comercio> filtrar(Integer rmc, String cedula, String nombreComercio, 
            Integer nroPatente, String barrio, String direccion){
        
        String sql = "Select o from Comercio o where 1=1";
        
        if(rmc != null && rmc > 0){
            sql = sql + " and o.idContribueyten.idContribuyente = :rmc"; 
        }
        
        if(cedula != null && !cedula.equals("0")){
            sql = sql + " and o.idContribuyente.cedula = :cedula"; 
        }
        
        if(nombreComercio != null && !nombreComercio.equals("")){
            sql = sql + " and upper(o.nombreFantasia) like :nombreCompleto";
        }
        
        if(nroPatente != null && nroPatente > 0){
            sql = sql + " and o.nroPatente = :nroPatente";
        }
        
        if(barrio != null && !barrio.equals("")){
            sql = sql + " and upper(o.idBarrio.descripcion) like :barrio";
        }
        
        if(direccion != null && !direccion.equals("")){
            sql = sql + " and upper(o.direccion) like :direccion";
        }
        
        Query query = super.getEm().createQuery(sql);
        
        if(rmc != null && rmc > 0){
            query.setParameter("rmc", rmc);
        }
        
        if(cedula != null && !cedula.equals("0")){
            query.setParameter("cedula", cedula);
        }
        
        if(nombreComercio != null && !nombreComercio.equals("")){
            query.setParameter("nombreComercio", "%" + nombreComercio.toUpperCase() + "%");
        }
        
        if(nroPatente != null && nroPatente > 0){
            query.setParameter("nroPatente", nroPatente);
        }
        
        if(barrio != null && !barrio.equals("")){
            query.setParameter("barrio", "%"+barrio.toUpperCase()+"%");
        }
        
        if(direccion != null && !direccion.equals("")){
            query.setParameter("direccion", "%"+ direccion.toUpperCase()+"%");
        }

        return query.getResultList();
    }
    
    public List<Contribuyente> getContribuyenteAll(){
        Query query = getEm().createQuery("select o from Contribuyente o");
        return query.getResultList();
    }
    
    public List<String> getDescripcionBarrioList(){
        return super.getEm().createQuery("select o.descripcion from Barrio o").getResultList();
    }
    
}
