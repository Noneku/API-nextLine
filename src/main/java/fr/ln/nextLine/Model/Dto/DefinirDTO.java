package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;
import fr.ln.nextLine.Model.Entity.Activite;
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
    private TypeTravauxDangereux idTypeTravaux;
    private Activite idActivite;

}

