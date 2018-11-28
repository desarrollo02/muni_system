package bean;

import factura.FiltroComercialBean;
import factura.FiltroHabilitacionBean;
import factura.FiltroInmuebleBean;
import factura.FiltroLoteCementerioBean;
import factura.FiltroRegistrioBean;
import java.io.Serializable;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jpa.Cementerio;
import jpa.Comercio;
import jpa.Inmueble;
import jpa.RegistroConducir;
import jpa.Vehiculo;


@ManagedBean(name = "fachadaBean")
@SessionScoped
public class FachadaBean implements Serializable {

    public Object getBean(String nombre, Class<?> clase){
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
 
        ExpressionFactory expressionFactory = application.getExpressionFactory();
 
        ValueExpression valueExpression = expressionFactory.createValueExpression
        (elContext, "#{"+nombre+"}", clase);
 
        return valueExpression.getValue(elContext);
    }
    
    public Inmueble getInmuebleSeleccionado(){
        FiltroInmuebleBean filtroInmuebleBean = (FiltroInmuebleBean) getBean("filtroInmuebleBean", FiltroInmuebleBean.class);
        return filtroInmuebleBean.getInmuebleSelect();
    }
    
    public Comercio getComercioSeleccionado(){
        FiltroComercialBean filtroComercialBean = (FiltroComercialBean) getBean("filtroComercialBean", FiltroComercialBean.class);
        return filtroComercialBean.getComercioSelect();
    }
    
    public Cementerio getCementerioSeleccionado(){
        FiltroLoteCementerioBean filtroLoteCementerioBean = (FiltroLoteCementerioBean) getBean("filtroLoteCementerioBean", FiltroLoteCementerioBean.class);
        return filtroLoteCementerioBean.getCementerioSelect();
    }
    
    public Vehiculo getVehiculoSeleccionado(){
        FiltroHabilitacionBean filtroHabilitacionBean = (FiltroHabilitacionBean) getBean("filtroHabilitacionBean", FiltroHabilitacionBean.class);
        return filtroHabilitacionBean.getVehiculoSelect();
    }
    
    public RegistroConducir getRegistroSeleccionado(){
        FiltroRegistrioBean filtroRegistrioBean = (FiltroRegistrioBean) getBean("filtroRegistroBean", FiltroRegistrioBean.class);
        return filtroRegistrioBean.getRegistroSelect();
    }
    
    public FachadaBean() {
    }
    
}
