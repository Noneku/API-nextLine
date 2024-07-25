package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.LieuRealisationDTO;
import fr.ln.nextLine.Model.Entity.LieuRealisation;

public class LieuRealisationMapper {

    private LieuRealisationMapper () {}

    public static LieuRealisationDTO toDTO(LieuRealisation lieuRealisation) {

        if (lieuRealisation == null) {
            return null;
        }

        LieuRealisationDTO lieuRealisationDTO = new LieuRealisationDTO();

        lieuRealisationDTO.setId(lieuRealisation.getId());
        lieuRealisationDTO.setDeplacements(lieuRealisation.getDeplacements());
        lieuRealisationDTO.setAutresLocaux(lieuRealisation.getAutresLocaux());
        lieuRealisationDTO.setAutreFrequence(lieuRealisation.getAutreFrequence());
        lieuRealisationDTO.setAutreModeDeplacement(lieuRealisation.getAutreModeDeplacement());
        lieuRealisationDTO.setIdLocaux(lieuRealisation.getIdLocaux());
        lieuRealisationDTO.setIdFrequence(lieuRealisation.getIdFrequence());
        lieuRealisationDTO.setIdModeDeplacement(lieuRealisation.getIdModeDeplacement());

        return lieuRealisationDTO;
    }

    public static LieuRealisation toEntity(LieuRealisationDTO lieuRealisationDTO) {

        if (lieuRealisationDTO == null) {
            return null;
        }

        LieuRealisation lieuRealisation = new LieuRealisation();

        lieuRealisation.setId(lieuRealisationDTO.getId());
        lieuRealisation.setDeplacements(lieuRealisationDTO.getDeplacements());
        lieuRealisation.setAutresLocaux(lieuRealisationDTO.getAutresLocaux());
        lieuRealisation.setAutreFrequence(lieuRealisationDTO.getAutreFrequence());
        lieuRealisation.setAutreModeDeplacement(lieuRealisationDTO.getAutreModeDeplacement());
        lieuRealisation.setIdLocaux(lieuRealisationDTO.getIdLocaux());
        lieuRealisation.setIdFrequence(lieuRealisationDTO.getIdFrequence());
        lieuRealisation.setIdModeDeplacement(lieuRealisationDTO.getIdModeDeplacement());

        return lieuRealisation;
    }
}
