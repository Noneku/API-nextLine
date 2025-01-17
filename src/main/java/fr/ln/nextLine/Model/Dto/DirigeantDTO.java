package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Fonction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DirigeantDTO {

    private Integer id;
    private String nomDirigeant;
    private String prenomDirigeant;
    private String emailDirigeant;
    private Fonction idFonction;

}
