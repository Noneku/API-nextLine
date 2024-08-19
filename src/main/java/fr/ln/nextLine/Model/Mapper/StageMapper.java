package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.*;
import fr.ln.nextLine.Model.Entity.*;

public class StageMapper {

    private StageMapper () {}

    public static StageDTO toDTO(Stage stage) {

        if (stage == null) {
            return null;
        }

        TuteurDTO tuteurDTO = TuteurMapper.toDTO(stage.getTuteur());
        UtilisateurDTO utilisateurDTO = UtilisateurMapper.toDTO(stage.getUtilisateur());
        EntrepriseDTO entrepriseDTO = EntrepriseMapper.toDTO(stage.getEntreprise());
        SessionDTO sessionDTO = SessionMapper.toDTO(stage.getSession());
        LieuRealisationDTO lieuRealisationDTO = LieuRealisationMapper.toDTO(stage.getLieuRealisation());
        ActiviteDTO activiteDTO = ActiviteMapper.toDTO(stage.getActivite());

        StageDTO stageDTO = new StageDTO();

        stageDTO.setId(stage.getId());
        stageDTO.setModifDateDebutStage(stage.getModifDateDebutStage());
        stageDTO.setObjectifStage(stage.getObjectifStage());
        stageDTO.setDateValidationStage(stage.getDateValidationStage());
        stageDTO.setTuteurDTO(tuteurDTO);
        stageDTO.setUtilisateurDTO(utilisateurDTO);
        stageDTO.setEntrepriseDTO(entrepriseDTO);
        stageDTO.setSessionDTO(sessionDTO);
        stageDTO.setLieuRealisationDTO(lieuRealisationDTO);
        stageDTO.setActiviteDTO(activiteDTO);

        return stageDTO;
    }

    public static Stage toEntity(StageDTO stageDTO) {

        if (stageDTO == null) {
            return null;
        }

        Tuteur tuteur = TuteurMapper.toEntity(stageDTO.getTuteurDTO());
        Utilisateur utilisateur = UtilisateurMapper.toEntity(stageDTO.getUtilisateurDTO());
        Entreprise entreprise = EntrepriseMapper.toEntity(stageDTO.getEntrepriseDTO());
        Session session = SessionMapper.toEntity(stageDTO.getSessionDTO());
        LieuRealisation lieuRealisation = LieuRealisationMapper.toEntity(stageDTO.getLieuRealisationDTO());
        Activite activite = ActiviteMapper.toEntity(stageDTO.getActiviteDTO());

        Stage stage = new Stage();

        stage.setId(stageDTO.getId());
        stage.setModifDateDebutStage(stageDTO.getModifDateDebutStage());
        stage.setObjectifStage(stageDTO.getObjectifStage());
        stage.setDateValidationStage(stageDTO.getDateValidationStage());
        stage.setTuteur(tuteur);
        stage.setUtilisateur(utilisateur);
        stage.setEntreprise(entreprise);
        stage.setSession(session);
        stage.setLieuRealisation(lieuRealisation);
        stage.setActivite(activite);

        return stage;
    }
}
