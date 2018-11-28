package validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "bean.validador.ExisteCedula")
public class ExisteCedula implements Validator{
    
    private ValidadorManager manager = new ValidadorManager();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
           String cedula = o.toString();
           if(manager.existeCedula(cedula)){
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"El nro. de cedula ya existe","");
               throw new ValidatorException(message);
           }
    }
    
}
