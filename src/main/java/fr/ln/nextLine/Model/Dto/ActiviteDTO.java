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
public class ActiviteDTO {

    private Integer id;
    private Boolean attestationReglementaire;
    private String nomAttestation;
    private Boolean visiteMedicale;
    private Boolean travauxDangereux;
    private LocalDate dateDeclarationDerogee;

}
