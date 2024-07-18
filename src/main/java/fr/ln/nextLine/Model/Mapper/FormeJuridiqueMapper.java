package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.FormeJuridiqueDTO;
import fr.ln.nextLine.Model.Entity.FormeJuridique;

public class FormeJuridiqueMapper {

    private FormeJuridiqueMapper() {}

    public static FormeJuridiqueDTO toDTO(FormeJuridique formeJuridique) {
        if (formeJuridique == null) {
            return null;
        }
        FormeJuridiqueDTO formeJuridiqueDTO = new FormeJuridiqueDTO();

        formeJuridiqueDTO.setId(formeJuridique.getId());
        formeJuridiqueDTO.setNomFormeJuridique(formeJuridique.getNomFormeJuridique());

        return formeJuridiqueDTO;
    }

    public static FormeJuridique toEntity(FormeJuridiqueDTO formeJuridiqueDTO) {
        if (formeJuridiqueDTO == null) {
            return null;
        }
        FormeJuridique formeJuridique = new FormeJuridique();

        formeJuridique.setId(formeJuridiqueDTO.getId());
        formeJuridique.setNomFormeJuridique(formeJuridiqueDTO.getNomFormeJuridique());

        return formeJuridique;
    }
}
