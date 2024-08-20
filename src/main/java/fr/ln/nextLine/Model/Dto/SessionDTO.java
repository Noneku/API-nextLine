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
public class SessionDTO {

    private Integer id;
    private LocalDate dateDebutSession;
    private LocalDate dateFinSession;
    private String numeroOffre;
    private LocalDate dateDebutStage;
    private LocalDate dateFinStage;
    private FormationDTO formationDTO;
}
