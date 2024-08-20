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

        LocauxDTO locauxDTO = LocauxMapper.toDTO(lieuRealisation.getLocaux());
        FrequenceDTO frequenceDTO = FrequenceMapper.toDTO(lieuRealisation.getFrequence());
        ModesDeplacementDTO modesDeplacementDTO = ModesDeplacementMapper.toDTO(lieuRealisation.getModeDeplacement());

        LieuRealisationDTO lieuRealisationDTO = new LieuRealisationDTO();

        lieuRealisationDTO.setId(lieuRealisation.getId());
        lieuRealisationDTO.setDeplacements(lieuRealisation.getDeplacements());
        lieuRealisationDTO.setAutresLocaux(lieuRealisation.getAutresLocaux());
        lieuRealisationDTO.setAutreFrequence(lieuRealisation.getAutreFrequence());
        lieuRealisationDTO.setAutreModeDeplacement(lieuRealisation.getAutreModeDeplacement());
        lieuRealisationDTO.setLocauxDTO(locauxDTO);
        lieuRealisationDTO.setFrequenceDTO(frequenceDTO);
        lieuRealisationDTO.setModesDeplacementDTO(modesDeplacementDTO);

        return lieuRealisationDTO;
    }

    public static LieuRealisation toEntity(LieuRealisationDTO lieuRealisationDTO) {

        if (lieuRealisationDTO == null) {
            return null;
        }

        Locaux locaux = LocauxMapper.toEntity(lieuRealisationDTO.getLocauxDTO());
        Frequence frequence = FrequenceMapper.toEntity(lieuRealisationDTO.getFrequenceDTO());
        ModesDeplacement modesDeplacement = ModesDeplacementMapper.toEntity(lieuRealisationDTO.getModesDeplacementDTO());

        LieuRealisation lieuRealisation = new LieuRealisation();

        lieuRealisation.setId(lieuRealisationDTO.getId());
        lieuRealisation.setDeplacements(lieuRealisationDTO.getDeplacements());
        lieuRealisation.setAutresLocaux(lieuRealisationDTO.getAutresLocaux());
        lieuRealisation.setAutreFrequence(lieuRealisationDTO.getAutreFrequence());
        lieuRealisation.setAutreModeDeplacement(lieuRealisationDTO.getAutreModeDeplacement());
        lieuRealisation.setLocaux(locaux);
        lieuRealisation.setFrequence(frequence);
        lieuRealisation.setModeDeplacement(modesDeplacement);

        return lieuRealisation;
    }
}
