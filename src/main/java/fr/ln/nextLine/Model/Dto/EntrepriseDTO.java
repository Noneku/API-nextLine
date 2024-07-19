package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Model.Entity.Ville;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntrepriseDTO {

    private Integer id;
    private String raisonSociale;
    private String adresseEntreprise;
    private String numeroSiret;
    private String telephoneEntreprise;
    private String emailEntreprise;
    private Ville idVille;
    private FormeJuridique idFormeJuridique;
    private Dirigeant idDirigeant;
    private Assurance idAssurance;

}
