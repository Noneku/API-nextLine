package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Activite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActiviteDTO extends Activite {

    private Integer idActivite;
    private Boolean attestationReglementaire;
    private String nomAttestation;
    private Boolean visiteMedicale;
    private Boolean travauxDangereux;
    private LocalDate dateDeclarationDerogee;

}
