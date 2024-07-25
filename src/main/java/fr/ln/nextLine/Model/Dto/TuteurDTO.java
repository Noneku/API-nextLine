package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TuteurDTO {

    private Integer id;
    private String nomTuteur;
    private String prenomTuteur;
    private String emailTuteur;
    private String telTuteur;
    private Entreprise idEntreprise;
    private Fonction idFonction;
}
