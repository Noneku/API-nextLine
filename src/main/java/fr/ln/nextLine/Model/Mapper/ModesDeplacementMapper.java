package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.ModesDeplacementDTO;
import fr.ln.nextLine.Model.Entity.ModesDeplacement;

public class ModesDeplacementMapper {

    private ModesDeplacementMapper () {}

    public static ModesDeplacementDTO toDTO(ModesDeplacement modesDeplacement) {

        if (modesDeplacement == null) {
            return null;
        }

        ModesDeplacementDTO modesDeplacementDTO = new ModesDeplacementDTO();

        modesDeplacementDTO.setId(modesDeplacement.getId());
        modesDeplacementDTO.setNomDeplacement(modesDeplacement.getNomDeplacement());

        return modesDeplacementDTO;
    }

    public static ModesDeplacement toEntity(ModesDeplacementDTO modesDeplacementDTO) {

        if (modesDeplacementDTO == null) {
            return null;
        }

        ModesDeplacement modesDeplacement = new ModesDeplacement();

        modesDeplacement.setId(modesDeplacementDTO.getId());
        modesDeplacement.setNomDeplacement(modesDeplacement.getNomDeplacement());

        return modesDeplacement;
    }
}
