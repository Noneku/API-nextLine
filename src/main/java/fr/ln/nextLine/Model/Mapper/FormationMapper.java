package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.FormationDTO;
import fr.ln.nextLine.Model.Entity.Formation;

public class FormationMapper {

    private FormationMapper() {}

    public static FormationDTO toDTO(Formation formation) {
        if (formation == null) {
            return null;
        }
        FormationDTO formationDTO = new FormationDTO();

        formationDTO.setId(formation.getId());
        formationDTO.setNomFormation(formation.getNomFormation());
        formationDTO.setCodeGrn(formation.getCodeGrn());

        return formationDTO;
    }

    public static Formation toEntity(FormationDTO formationDTO) {
        if (formationDTO == null) {
            return null;
        }
        Formation formation = new Formation();

        formation.setId(formationDTO.getId());
        formation.setNomFormation(formationDTO.getNomFormation());
        formation.setCodeGrn(formationDTO.getCodeGrn());

        return formation;
    }
}
