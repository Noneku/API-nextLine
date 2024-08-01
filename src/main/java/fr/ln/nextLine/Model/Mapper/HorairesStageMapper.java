package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.HorairesStageDTO;
import fr.ln.nextLine.Model.Dto.JourDTO;
import fr.ln.nextLine.Model.Dto.StageDTO;
import fr.ln.nextLine.Model.Entity.HorairesStage;
import fr.ln.nextLine.Model.Entity.Jour;
import fr.ln.nextLine.Model.Entity.Stage;

public class HorairesStageMapper {

    private HorairesStageMapper() {}

    public static HorairesStageDTO toDTO(HorairesStage horairesStage) {
        if (horairesStage == null) {
            return null;
        }
        HorairesStageDTO horairesStageDTO = new HorairesStageDTO();

        StageDTO stageDTO = StageMapper.toDTO(horairesStage.getIdStage());
        JourDTO jourDTO = JourMapper.toDTO(horairesStage.getIdJour());

        horairesStageDTO.setId(horairesStage.getId());
        horairesStageDTO.setHeureDebut(horairesStage.getHeureDebut());
        horairesStageDTO.setHeureDebutPauseDej(horairesStage.getHeureDebutPauseDej());
        horairesStageDTO.setHeureFinPauseDej(horairesStage.getHeureFinPauseDej());
        horairesStageDTO.setHeureFin(horairesStage.getHeureFin());
        horairesStageDTO.setIdStage(stageDTO);
        horairesStageDTO.setIdJour(jourDTO);

        return horairesStageDTO;
    }

    public static HorairesStage toEntity(HorairesStageDTO horairesStageDTO) {
        if (horairesStageDTO == null) {
            return null;
        }

        Stage stage = StageMapper.toEntity(horairesStageDTO.getIdStage());
        Jour jour = JourMapper.toEntity(horairesStageDTO.getIdJour());

        HorairesStage horairesStage = new HorairesStage();

        horairesStage.setId(horairesStageDTO.getId());
        horairesStage.setHeureDebut(horairesStageDTO.getHeureDebut());
        horairesStage.setHeureDebutPauseDej(horairesStageDTO.getHeureDebutPauseDej());
        horairesStage.setHeureFinPauseDej(horairesStageDTO.getHeureFinPauseDej());
        horairesStage.setHeureFin(horairesStageDTO.getHeureFin());
        horairesStage.setIdStage(stage);
        horairesStage.setIdJour(jour);

        return horairesStage;
    }
}

