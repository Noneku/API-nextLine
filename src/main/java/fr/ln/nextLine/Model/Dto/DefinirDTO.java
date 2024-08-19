package fr.ln.nextLine.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DefinirDTO {

    private Integer id;
    private TypeTravauxDangereuxDTO typeTravauxDangereuxDTO;
    private ActiviteDTO activiteDTO;

}

