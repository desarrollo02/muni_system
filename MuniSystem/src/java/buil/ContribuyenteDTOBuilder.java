package buil;

import dto.ContribuyenteDTO;
import jpa.Contribuyente;

/**
 *
 * @author desarrollo2
 */
public class ContribuyenteDTOBuilder {

    private ContribuyenteDTO contribuyenteDTO;

    public ContribuyenteDTOBuilder() {
        contribuyenteDTO = new ContribuyenteDTO();
    }
    
    public ContribuyenteDTOBuilder contribuyente(Contribuyente contribuyente){
        contribuyenteDTO.setId(contribuyente.getIdContribuyente());
        contribuyenteDTO.setCedula(contribuyente.getCedula());
        contribuyenteDTO.setRuc(contribuyente.getRuc());
        contribuyenteDTO.setNombres(contribuyente.getNombres());
        contribuyenteDTO.setApellidos(contribuyente.getApellidos());
        contribuyenteDTO.setRazonSocial(contribuyente.getRazonSocial());
        return this;
    }
    
    public ContribuyenteDTO build(){
        return contribuyenteDTO;
    }
}
