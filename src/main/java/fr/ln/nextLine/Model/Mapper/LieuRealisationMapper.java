package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.FrequenceDTO;
import fr.ln.nextLine.Model.Dto.LieuRealisationDTO;
import fr.ln.nextLine.Model.Dto.LocauxDTO;
import fr.ln.nextLine.Model.Dto.ModesDeplacementDTO;
import fr.ln.nextLine.Model.Entity.Frequence;
import fr.ln.nextLine.Model.Entity.LieuRealisation;
import fr.ln.nextLine.Model.Entity.Locaux;
import fr.ln.nextLine.Model.Entity.ModesDeplacement;

public class LieuRealisationMapper {

    private LieuRealisationMapper () {}

    public static LieuRealisationDTO toDTO(LieuRealisation lieuRealisation) {

        if (lieuRealisation == null) {
            return null;
        }

        LocauxDTO locauxDTO = LocauxMapper.toDTO(lieuRealisation.getIdLocaux());
        FrequenceDTO frequenceDTO = FrequenceMapper.toDTO(lieuRealisation.getIdFrequence());
        ModesDeplacementDTO modesDeplacementDTO = ModesDeplacementMapper.toDTO(lieuRealisation.getIdModeDeplacement());

        LieuRealisationDTO lieuRealisationDTO = new LieuRealisationDTO();

        lieuRealisationDTO.setId(lieuRealisation.getId());
        lieuRealisationDTO.setDeplacements(lieuRealisation.getDeplacements());
        lieuRealisationDTO.setAutresLocaux(lieuRealisation.getAutresLocaux());
        lieuRealisationDTO.setAutreFrequence(lieuRealisation.getAutreFrequence());
        lieuRealisationDTO.setAutreModeDeplacement(lieuRealisation.getAutreModeDeplacement());
        lieuRealisationDTO.setIdLocaux(locauxDTO);
        lieuRealisationDTO.setIdFrequence(frequenceDTO);
        lieuRealisationDTO.setIdModeDeplacement(modesDeplacementDTO);

        return lieuRealisationDTO;
    }

    public static LieuRealisation toEntity(LieuRealisationDTO lieuRealisationDTO) {

        if (lieuRealisationDTO == null) {
            return null;
        }

        Locaux locaux = LocauxMapper.toEntity(lieuRealisationDTO.getIdLocaux());
        Frequence frequence = FrequenceMapper.toEntity(lieuRealisationDTO.getIdFrequence());
        ModesDeplacement modesDeplacement = ModesDeplacementMapper.toEntity(lieuRealisationDTO.getIdModeDeplacement());

        LieuRealisation lieuRealisation = new LieuRealisation();

        lieuRealisation.setId(lieuRealisationDTO.getId());
        lieuRealisation.setDeplacements(lieuRealisationDTO.getDeplacements());
        lieuRealisation.setAutresLocaux(lieuRealisationDTO.getAutresLocaux());
        lieuRealisation.setAutreFrequence(lieuRealisationDTO.getAutreFrequence());
        lieuRealisation.setAutreModeDeplacement(lieuRealisationDTO.getAutreModeDeplacement());
        lieuRealisation.setIdLocaux(locaux);
        lieuRealisation.setIdFrequence(frequence);
        lieuRealisation.setIdModeDeplacement(modesDeplacement);

        return lieuRealisation;
    }
}
