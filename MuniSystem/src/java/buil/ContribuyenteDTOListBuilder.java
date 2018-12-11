/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buil;

import dto.ContribuyenteDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Contribuyente;

/**
 *
 * @author desarrollo2
 */
public class ContribuyenteDTOListBuilder {
    
    private List<ContribuyenteDTO> contribuyenteDTOs;

    public ContribuyenteDTOListBuilder() {
        contribuyenteDTOs = new ArrayList<>();
    }
    
    public ContribuyenteDTOListBuilder contribuyentes(List<Contribuyente> contribuyentes){
        for(Contribuyente contribuyente : contribuyentes){
            contribuyenteDTOs.add(new ContribuyenteDTOBuilder().contribuyente(contribuyente).build());
        }
        return this;
    }
    
    public List<ContribuyenteDTO> build(){
        return contribuyenteDTOs;
    }
}
