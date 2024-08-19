package fr.ln.nextLine.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormulaireDTO {

    private UtilisateurDTO idUtilisateur;
    private EntrepriseDTO idEntreprise;
    private HorairesStageDTO idHorairesStage;
    private LieuRealisationDTO idLieuRealisation;
    private ActiviteDTO idActivite;
}