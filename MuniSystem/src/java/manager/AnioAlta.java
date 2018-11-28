/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.Calendar;
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
public class AnioAlta extends BaseManager{
    
    
    public Integer getAnioAltaInmuble(Inmueble inmueble){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(inmueble.getFechaAlta());
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getAnioAltaComercio(Comercio comercio){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(comercio.getFecAlta());
        
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getAnioAltaCementerio(Cementerio cementerio){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(cementerio.getFecAlta());
        
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getAnioAltaVehiculo(Vehiculo vehiculo){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(vehiculo.getFechaAlta());
        
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getAnioAltaRegistro(RegistroConducir registro){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(registro.getFechaAlta());
        
        return fecha.get(Calendar.YEAR);
    }

    public Integer getUltimoAnioComercio(Comercio comercio){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(comercio.getFecAlta());
        
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getUltimoAnioCementerio(Cementerio cementerio){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(cementerio.getFecAlta());
        
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getUltimoAnioHabilitacion(Vehiculo vehiculo){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(vehiculo.getFechaAlta());
        
        return fecha.get(Calendar.YEAR);
    }
    
    public Integer getUltimoAnioRegistro(RegistroConducir registro){
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(registro.getFechaAlta());
        
        return fecha.get(Calendar.YEAR);
    }
}
