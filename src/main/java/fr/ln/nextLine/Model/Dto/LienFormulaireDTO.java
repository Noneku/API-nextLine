package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LienFormulaireDTO {

    private Integer id;
    private String tokenLien;
    private LocalDate dateGeneration;
    private Boolean statut;
    private Utilisateur idUtilisateur;

}
