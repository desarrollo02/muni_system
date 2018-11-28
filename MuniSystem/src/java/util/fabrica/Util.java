/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.fabrica;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author diaz
 */
public class Util {
    
    private static EntityManager em = Persistence.createEntityManagerFactory("MuniSystemPU").createEntityManager();

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager aEm) {
        em = aEm;
    }
    
}
