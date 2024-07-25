package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Model.Entity.Fonction;

public class FonctionMapper {

    private FonctionMapper() {}

    public static FonctionDTO toDTO(Fonction fonction) {
        if (fonction == null) {
            return null;
        }
        FonctionDTO fonctionDTO = new FonctionDTO();

        fonctionDTO.setId(fonction.getId());
        fonctionDTO.setNomFonction(fonction.getNomFonction());

        return fonctionDTO;
    }

    public static Fonction toEntity(FonctionDTO fonctionDTO) {
        if (fonctionDTO == null) {
            return null;
        }
        Fonction fonction = new Fonction();

        fonction.setId(fonctionDTO.getId());
        fonction.setNomFonction(fonctionDTO.getNomFonction());

        return fonction;
    }
}
