package fr.ln.nextLine.Model.Dto;

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
    private VilleDTO idVille;
    private FormeJuridiqueDTO idFormeJuridique;
    private DirigeantDTO idDirigeant;
    private AssuranceDTO idAssurance;

}
