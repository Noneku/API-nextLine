package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Frequence;
import fr.ln.nextLine.Model.Entity.Locaux;
import fr.ln.nextLine.Model.Entity.ModesDeplacement;
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
    private Locaux idLocaux;
    private Frequence idFrequence;
    private ModesDeplacement idModeDeplacement;

}
