package buil;

import dao.MultaDAO;
import dao.TributoAnexoDAO;
import dto.TributoDTO;
import java.util.ArrayList;
import java.util.List;
import jpa.Tributo;
import jpa.TributoMulta;
import util.fabrica.Util;

public class TributoDTOListBuilder {

    private List<TributoDTO> tributoDTOs;
    private TributoAnexoDAO anexoDAO = new TributoAnexoDAO(Util.getEm());
    private MultaDAO multasDAO = new MultaDAO(Util.getEm());

    public TributoDTOListBuilder() {
        tributoDTOs = new ArrayList<>();
    }
    
    public List<TributoDTO> build(){
        return tributoDTOs;
    }
    
    public TributoDTOListBuilder tributos(List<Tributo> tributos){
        TributoDTO tributoDTO;
        List<TributoMulta> multas;
        List<Tributo> anexos;
        for(Tributo tributo : tributos){
            multas = multasDAO.getTributoMultas(tributo);
            anexos = anexoDAO.getAnexos(tributo);
            tributoDTO = new TributoDTOBuilder().tributo(tributo).multas(multas)
                    .tributosAnexos(anexos).build();
            tributoDTOs.add(tributoDTO);
        }
        return this;
    }
}
