package fr.ln.nextLine.Model.Dto;

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
    private EntrepriseDTO idEntreprise;
    private FonctionDTO idFonction;
}
