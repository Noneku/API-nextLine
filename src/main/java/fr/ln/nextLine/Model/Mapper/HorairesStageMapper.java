package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.HorairesStageDTO;
import fr.ln.nextLine.Model.Entity.HorairesStage;

public class HorairesStageMapper {

    private HorairesStageMapper() {}

    public static HorairesStageDTO toDTO(HorairesStage horairesStage) {
        if (horairesStage == null) {
            return null;
        }
        HorairesStageDTO horairesStageDTO = new HorairesStageDTO();

        horairesStageDTO.setId(horairesStage.getId());
        horairesStageDTO.setHeureDebut(horairesStage.getHeureDebut());
        horairesStageDTO.setHeureDebutPauseDej(horairesStage.getHeureDebutPauseDej());
        horairesStageDTO.setHeureFinPauseDej(horairesStage.getHeureFinPauseDej());
        horairesStageDTO.setHeureFin(horairesStage.getHeureFin());
        horairesStageDTO.setIdStage(horairesStage.getIdStage());
        horairesStageDTO.setIdJour(horairesStage.getIdJour());

        return horairesStageDTO;
    }

    public static HorairesStage toEntity(HorairesStageDTO horairesStageDTO) {
        if (horairesStageDTO == null) {
            return null;
        }
        HorairesStage horairesStage = new HorairesStage();

        horairesStage.setId(horairesStageDTO.getId());
        horairesStage.setHeureDebut(horairesStageDTO.getHeureDebut());
        horairesStage.setHeureDebutPauseDej(horairesStageDTO.getHeureDebutPauseDej());
        horairesStage.setHeureFinPauseDej(horairesStageDTO.getHeureFinPauseDej());
        horairesStage.setHeureFin(horairesStageDTO.getHeureFin());
        horairesStage.setIdStage(horairesStageDTO.getIdStage());
        horairesStage.setIdJour(horairesStageDTO.getIdJour());

        return horairesStage;
    }
}

