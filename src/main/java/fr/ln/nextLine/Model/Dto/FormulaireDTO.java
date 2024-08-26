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

    private UtilisateurDTO utilisateurDTO;
    private FormationDTO formationDTO;
    private SessionDTO sessionDTO;
    private ParticiperDTO participerDTO;
    private EntrepriseDTO entrepriseDTO;
    private HorairesStageDTO horairesStageDTO;
    private LieuRealisationDTO lieuRealisationDTO;
    private ActiviteDTO activiteDTO;
}