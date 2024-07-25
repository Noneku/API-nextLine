package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DefinirIdDTO implements Serializable {

    private TypeTravauxDangereux idTypeTravaux;
    private Activite idActivite;
}
