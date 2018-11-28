package bean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class BaseBean {
    
    public void setMensaje(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
        getFC().getFlash().setKeepMessages(true);
    }

    public void setMensajeError(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
        getFC().getFlash().setKeepMessages(true);
    }
    
    public ExternalContext getFC(){
        return FacesContext.getCurrentInstance().getExternalContext();
    }
    
    public HttpServletRequest getR(){
        return (HttpServletRequest)getFC().getRequest();
    }
    
    public String getValor(String parametro){
        return (String) getR().getParameter(parametro);
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
}
