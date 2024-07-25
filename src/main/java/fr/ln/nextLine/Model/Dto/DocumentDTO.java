package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentDTO {

    private Integer id;
    private String nomPdf;
    private LocalDate dateGenerationDocument;
    private Stage idStage;

}
