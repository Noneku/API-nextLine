package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import fr.ln.nextLine.Model.Entity.Assurance;

public class AssuranceMapper {

    private AssuranceMapper () {}

    public static AssuranceDTO toDTO(Assurance assurance) {
        if (assurance == null) {
            return null;
        }
        AssuranceDTO assuranceDTO = new AssuranceDTO();

        assuranceDTO.setId(assurance.getId());
        assuranceDTO.setNomAssurance(assurance.getNomAssurance());
        assuranceDTO.setNumeroSocietaire(assurance.getNumeroSocietaire());

        return assuranceDTO;
    }

    public static Assurance toEntity(AssuranceDTO assuranceDto) {
        if (assuranceDto == null) {
            return null;
        }
        Assurance assurance = new Assurance();

        assurance.setId(assuranceDto.getId());
        assurance.setNomAssurance(assuranceDto.getNomAssurance());
        assurance.setNumeroSocietaire(assuranceDto.getNumeroSocietaire());

        return assurance;
    }
}
