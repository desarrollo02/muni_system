package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Contribuyente;
import jpa.RegistroConducir;

public class RegistroConducirManager extends BaseManager {
    
    public boolean existeNroRegistro(RegistroConducir registroConducir){
        Query query = getEm().createQuery("select o from RegistroConducir o where o.licenciaNro = :licencia");
        query.setParameter("licencia", registroConducir.getLicenciaNro());
        List<RegistroConducir> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return false;
        }else if(resultado.get(0).getIdRegistroConducir().equals(registroConducir.getIdRegistroConducir())){
            return false;
        }else{
            return true;
        }
    }
    
    
    public List<String> getDescripcionCategoriaList(){
        return super.getEm().createQuery("select o.descripcion from RegistroCategoria o").getResultList();
    }
    
    public List<RegistroConducir> filtrar(Integer rmc, String cedula, Integer registroNro, 
            String categoria){
        
        String sql = "Select o from RegistroConducir o where 1=1";
        
        if(rmc != null && rmc > 0){
            sql = sql + " and o.idContribueyten.idContribuyente = :rmc"; 
        }
        
        if(cedula != null && !cedula.equals("0")){
            sql = sql + " and o.idContribuyente.cedula = :cedula"; 
        }
        
        if(registroNro != null && registroNro > 0){
            sql = sql + " and o.licenciaNro = :registroNro";
        }
        
        if(categoria != null && !categoria.equals("")){
            sql = sql + " and upper(o.idCategoria.descripcion) like :categoria";
        }
        
        Query query = super.getEm().createQuery(sql);
        
        if(rmc != null && rmc > 0){
            query.setParameter("rmc", rmc);
        }
        
        if(cedula != null && !cedula.equals("0")){
            query.setParameter("cedula", cedula);
        }
        
        if(registroNro != null && registroNro > 0){
            query.setParameter("registroNro", registroNro);
        }
        
        if(categoria != null && !categoria.equals("")){
            query.setParameter("categoria", "%" + categoria.toUpperCase() + "%");
        }

        return query.getResultList();
    }
    
    
    public List<Contribuyente> getContribuyenteAll(){
        Query query = getEm().createQuery("select o from Contribuyente o");
        return query.getResultList();
    }
    
}
