package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.DirigeantDTO;
import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Model.Entity.Fonction;

public class DirigeantMapper {

    private DirigeantMapper() {}

    public static DirigeantDTO toDTO(Dirigeant dirigeant) {
        if (dirigeant == null) {
            return null;
        }
        FonctionDTO fonctionDTO = FonctionMapper.toDTO(dirigeant.getIdFonction());

        DirigeantDTO dirigeantDTO = new DirigeantDTO();

        dirigeantDTO.setId(dirigeant.getId());
        dirigeantDTO.setNomDirigeant(dirigeant.getNomDirigeant());
        dirigeantDTO.setPrenomDirigeant(dirigeant.getPrenomDirigeant());
        dirigeantDTO.setEmailDirigeant(dirigeant.getEmailDirigeant());

        //Foreign key
        dirigeantDTO.setIdFonction(fonctionDTO);

        return dirigeantDTO;
    }

    public static Dirigeant toEntity(DirigeantDTO dirigeantDTO) {
        if (dirigeantDTO == null) {
            return null;
        }

        Fonction fonction = FonctionMapper.toEntity(dirigeantDTO.getIdFonction());

        Dirigeant dirigeant = new Dirigeant();

        dirigeant.setId(dirigeantDTO.getId());
        dirigeant.setNomDirigeant(dirigeantDTO.getNomDirigeant());
        dirigeant.setPrenomDirigeant(dirigeantDTO.getPrenomDirigeant());
        dirigeant.setEmailDirigeant(dirigeantDTO.getEmailDirigeant());

        //Foreign key
        dirigeant.setIdFonction(fonction);

        return dirigeant;
    }
}