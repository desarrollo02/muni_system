/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jpa.Usuario;

/**
 *
 * @author diaz
 */
public class MensajeBean {
    
    public void mensajeExito(String mensaje){    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,  mensaje, null) );
    }
    
    public void mensajeError(String mensaje){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  mensaje, null) );
    }
    
    public Object getBean(String nombre, Class<?> clase){
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
 
        ExpressionFactory expressionFactory = application.getExpressionFactory();
 
        ValueExpression valueExpression = expressionFactory.createValueExpression
        (elContext, "#{"+nombre+"}", clase);
 
        return valueExpression.getValue(elContext);
    }
    
    public  Usuario getUsuario(){
        LoginBean login = (LoginBean) getBean("loginBean", LoginBean.class);
        return login.getUsuarioLogeado();
    }
}
