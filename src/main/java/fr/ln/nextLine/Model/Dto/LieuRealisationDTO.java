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
    private LocauxDTO idLocaux;
    private FrequenceDTO idFrequence;
    private ModesDeplacementDTO idModeDeplacement;

}
