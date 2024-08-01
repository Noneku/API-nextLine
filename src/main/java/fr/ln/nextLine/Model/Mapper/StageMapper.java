package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.*;
import fr.ln.nextLine.Model.Entity.*;

public class StageMapper {

    private StageMapper () {}

    public static StageDTO toDTO(Stage stage) {

        if (stage == null) {
            return null;
        }

        TuteurDTO tuteurDTO = TuteurMapper.toDTO(stage.getIdTuteur());
        UtilisateurDTO utilisateurDTO = UtilisateurMapper.toDTO(stage.getIdUtilisateur());
        EntrepriseDTO entrepriseDTO = EntrepriseMapper.toDTO(stage.getIdEntreprise());
        SessionDTO sessionDTO = SessionMapper.toDTO(stage.getIdSession());
        LieuRealisationDTO lieuRealisationDTO = LieuRealisationMapper.toDTO(stage.getIdLieuRealisation());
        ActiviteDTO activiteDTO = ActiviteMapper.toDTO(stage.getIdActivite());

        StageDTO stageDTO = new StageDTO();

        stageDTO.setId(stage.getId());
        stageDTO.setModifDateDebutStage(stage.getModifDateDebutStage());
        stageDTO.setObjectifStage(stage.getObjectifStage());
        stageDTO.setDateValidationStage(stage.getDateValidationStage());
        stageDTO.setIdTuteur(tuteurDTO);
        stageDTO.setIdUtilisateur(utilisateurDTO);
        stageDTO.setIdEntreprise(entrepriseDTO);
        stageDTO.setIdSession(sessionDTO);
        stageDTO.setIdLieuRealisation(lieuRealisationDTO);
        stageDTO.setIdActivite(activiteDTO);

        return stageDTO;
    }

    public static Stage toEntity(StageDTO stageDTO) {

        if (stageDTO == null) {
            return null;
        }

        Tuteur tuteur = TuteurMapper.toEntity(stageDTO.getIdTuteur());
        Utilisateur utilisateur = UtilisateurMapper.toEntity(stageDTO.getIdUtilisateur());
        Entreprise entreprise = EntrepriseMapper.toEntity(stageDTO.getIdEntreprise());
        Session session = SessionMapper.toEntity(stageDTO.getIdSession());
        LieuRealisation lieuRealisation = LieuRealisationMapper.toEntity(stageDTO.getIdLieuRealisation());
        Activite activite = ActiviteMapper.toEntity(stageDTO.getIdActivite());

        Stage stage = new Stage();

        stage.setId(stageDTO.getId());
        stage.setModifDateDebutStage(stageDTO.getModifDateDebutStage());
        stage.setObjectifStage(stageDTO.getObjectifStage());
        stage.setDateValidationStage(stageDTO.getDateValidationStage());
        stage.setIdTuteur(tuteur);
        stage.setIdUtilisateur(utilisateur);
        stage.setIdEntreprise(entreprise);
        stage.setIdSession(session);
        stage.setIdLieuRealisation(lieuRealisation);
        stage.setIdActivite(activite);

        return stage;
    }
}
