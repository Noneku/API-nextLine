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

        StageDTO stageDTO = StageMapper.toDTO(horairesStage.getStage());
        JourDTO jourDTO = JourMapper.toDTO(horairesStage.getJour());

        horairesStageDTO.setId(horairesStage.getId());
        horairesStageDTO.setHeureDebut(horairesStage.getHeureDebut());
        horairesStageDTO.setHeureDebutPauseDej(horairesStage.getHeureDebutPauseDej());
        horairesStageDTO.setHeureFinPauseDej(horairesStage.getHeureFinPauseDej());
        horairesStageDTO.setHeureFin(horairesStage.getHeureFin());
        horairesStageDTO.setStageDTO(stageDTO);
        horairesStageDTO.setJourDTO(jourDTO);

        return horairesStageDTO;
    }

    public static HorairesStage toEntity(HorairesStageDTO horairesStageDTO) {
        if (horairesStageDTO == null) {
            return null;
        }

        Stage stage = StageMapper.toEntity(horairesStageDTO.getStageDTO());
        Jour jour = JourMapper.toEntity(horairesStageDTO.getJourDTO());

        HorairesStage horairesStage = new HorairesStage();

        horairesStage.setId(horairesStageDTO.getId());
        horairesStage.setHeureDebut(horairesStageDTO.getHeureDebut());
        horairesStage.setHeureDebutPauseDej(horairesStageDTO.getHeureDebutPauseDej());
        horairesStage.setHeureFinPauseDej(horairesStageDTO.getHeureFinPauseDej());
        horairesStage.setHeureFin(horairesStageDTO.getHeureFin());
        horairesStage.setStage(stage);
        horairesStage.setJour(jour);

        return horairesStage;
    }
}

