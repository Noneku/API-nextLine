package fr.ln.nextLine.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LieuRealisationDTO {

    private Integer id;
    private Boolean deplacements;
    private String autresLocaux;
    private String autreFrequence;
    private String autreModeDeplacement;
    private LocauxDTO locauxDTO;
    private FrequenceDTO frequenceDTO;
    private ModesDeplacementDTO modesDeplacementDTO;

}
