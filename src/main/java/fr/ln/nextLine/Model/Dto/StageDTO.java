package fr.ln.nextLine.Model.Dto;

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
    private TuteurDTO tuteurDTO;
    private UtilisateurDTO utilisateurDTO;
    private EntrepriseDTO entrepriseDTO;
    private SessionDTO sessionDTO;
    private LieuRealisationDTO lieuRealisationDTO;
    private ActiviteDTO activiteDTO;
}
