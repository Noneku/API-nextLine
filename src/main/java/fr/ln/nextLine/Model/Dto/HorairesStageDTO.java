package fr.ln.nextLine.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HorairesStageDTO {

    private Integer id;
    private OffsetTime heureDebut;
    private OffsetTime heureDebutPauseDej;
    private OffsetTime heureFinPauseDej;
    private OffsetTime heureFin;
    private StageDTO stageDTO;
    private JourDTO jourDTO;
}
