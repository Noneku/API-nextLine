package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StageDTO {

    private Integer id;
    private LocalDate modifDateDebutStage;
    private String objectifStage;
    private LocalDate dateValidationStage;
    private Tuteur idTuteur;
    private Utilisateur idUtilisateur;
    private Entreprise idEntreprise;
    private Session idSession;
    private LieuRealisation idLieuRealisation;
    private Activite idActivite;
}
