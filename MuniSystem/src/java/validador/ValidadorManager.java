/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validador;

import jpa.Contribuyente;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author diaz
 */
public class ValidadorManager {
    
    private EntityManager em = Persistence.createEntityManagerFactory("MuniSystemPU").createEntityManager();
    
    public boolean existeCedula(String cedula){
        Query query = em.createQuery("select o from Contribuyente o where o.cedula = :cedula");
        query.setParameter("cedula", cedula);
        
        return !query.getResultList().isEmpty();
    }
    
    public boolean existeCedula(String id, String cedula){
        Query query = em.createQuery("select o from Contribuyente o where o.cedula = :cedula");
        query.setParameter("cedula", cedula);
        if(query.getResultList().isEmpty()){
            return false;
        }else{
           Contribuyente contribuyente = (Contribuyente) query.getSingleResult();
           if(contribuyente.getIdContribuyente() ==  Integer.parseInt(id)){
               return false;
           }else{
               return true;
           }
        }
    }
    
}
