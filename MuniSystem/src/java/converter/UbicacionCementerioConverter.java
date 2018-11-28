/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author diaz
 */
@FacesConverter("UbicacionCementerioConverter")
public class UbicacionCementerioConverter implements Converter{
    private ConverterManager manager;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return getManager().getUbicacionCementerio(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null){
            return "Seleccione";
        }
        return o.toString();
    }
    
    public ConverterManager getManager() {
        if(manager == null){
            manager = new ConverterManager();
        }
        return manager;
    }
}
