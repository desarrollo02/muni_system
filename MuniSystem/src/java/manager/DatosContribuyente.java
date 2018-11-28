/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.List;
import javax.persistence.Query;
import jpa.Cementerio;
import jpa.Comercio;
import jpa.Contribuyente;
import jpa.Inmueble;
import jpa.RegistroConducir;
import jpa.Vehiculo;

/**
 *
 * @author diaz
 */
public class DatosContribuyente extends BaseManager{
    
    private Contribuyente contribuyente;
    private List<Inmueble> inmuebles;
    private List<Comercio> comercios;
    private List<Cementerio> cementerios;
    private List<Vehiculo> vehiculos;
    private List<RegistroConducir> registros;

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
        buscarDatos();
    }
    
    private void buscarDatos(){
        Query query = getEm().createQuery("select o from Inmueble o where o.idContribuyente = :contribuyente");
        query.setParameter("contribuyente", contribuyente);
        inmuebles = query.getResultList();
        query = getEm().createQuery("select o from Comercio o where o.idContribuyente = :contribuyente");
        query.setParameter("contribuyente", contribuyente);
        comercios = query.getResultList();
        query = getEm().createQuery("select o from Cementerio o where o.idContribuyente = :contribuyente");
        query.setParameter("contribuyente", contribuyente);
        cementerios = query.getResultList();
        query = getEm().createQuery("select o from Vehiculo o where o.idContribuyente = :contribuyente");
        query.setParameter("contribuyente", contribuyente);
        vehiculos = query.getResultList();
        query = getEm().createQuery("select o from RegistroConducir o where o.idContribuyente = :contribuyente");
        query.setParameter("contribuyente", contribuyente);
        registros = query.getResultList();
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public List<Comercio> getComercios() {
        return comercios;
    }

    public List<Cementerio> getCementerios() {
        return cementerios;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<RegistroConducir> getRegistros() {
        return registros;
    }
}