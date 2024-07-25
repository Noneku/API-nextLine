package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.StageDTO;
import fr.ln.nextLine.Model.Entity.Stage;

public class StageMapper {

    private StageMapper () {}

    public static StageDTO toDTO(Stage stage) {

        if (stage == null) {
            return null;
        }

        StageDTO stageDTO = new StageDTO();

        stageDTO.setId(stage.getId());
        stageDTO.setModifDateDebutStage(stage.getModifDateDebutStage());
        stageDTO.setObjectifStage(stage.getObjectifStage());
        stageDTO.setDateValidationStage(stage.getDateValidationStage());
        stageDTO.setIdTuteur(stage.getIdTuteur());
        stageDTO.setIdUtilisateur(stage.getIdUtilisateur());
        stageDTO.setIdEntreprise(stage.getIdEntreprise());
        stageDTO.setIdSession(stage.getIdSession());
        stageDTO.setIdLieuRealisation(stage.getIdLieuRealisation());
        stageDTO.setIdActivite(stage.getIdActivite());

        return stageDTO;
    }

    public static Stage toEntity(StageDTO stageDTO) {

        if (stageDTO == null) {
            return null;
        }

        Stage stage = new Stage();

        stage.setId(stageDTO.getId());
        stage.setModifDateDebutStage(stage.getModifDateDebutStage());
        stage.setObjectifStage(stage.getObjectifStage());
        stage.setDateValidationStage(stage.getDateValidationStage());
        stage.setIdTuteur(stage.getIdTuteur());
        stage.setIdUtilisateur(stage.getIdUtilisateur());
        stage.setIdEntreprise(stage.getIdEntreprise());
        stage.setIdSession(stage.getIdSession());
        stage.setIdLieuRealisation(stage.getIdLieuRealisation());
        stage.setIdActivite(stage.getIdActivite());

        return stage;
    }
}
