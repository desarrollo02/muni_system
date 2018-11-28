

package validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "bean.validador.ActualizarCedula")
public class ActualizarCedula implements Validator{
    private ValidadorManager manager = new ValidadorManager();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
           String id = uic.getId();
           String[] idArray = id.split("-");
           String cedula = o.toString();
           if(manager.existeCedula(idArray[1], cedula)){
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya existe","");
               throw new ValidatorException(message);
           }
    }
}
