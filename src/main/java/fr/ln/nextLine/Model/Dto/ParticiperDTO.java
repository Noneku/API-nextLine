package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Session;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticiperDTO {

    private Session idSession;
    private Utilisateur idUtilisateur;
}
