package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;

public class EntrepriseMapper {

    private EntrepriseMapper() {}

    public static EntrepriseDTO toDTO(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        EntrepriseDTO entrepriseDto = new EntrepriseDTO();

        entrepriseDto.setId(entreprise.getId());
        entrepriseDto.setRaisonSociale(entreprise.getRaisonSociale());
        entrepriseDto.setAdresseEntreprise(entreprise.getAdresseEntreprise());
        entrepriseDto.setNumeroSiret(entreprise.getNumeroSiret());
        entrepriseDto.setTelephoneEntreprise(entreprise.getTelephoneEntreprise());
        entrepriseDto.setEmailEntreprise(entreprise.getEmailEntreprise());

        //Foreign key
        entrepriseDto.setIdVille(entreprise.getIdVille());
        entrepriseDto.setIdFormeJuridique(entreprise.getIdFormeJuridique());
        entrepriseDto.setIdDirigeant(entreprise.getIdDirigeant());
        entrepriseDto.setIdAssurance(entreprise.getIdAssurance());

        return entrepriseDto;
    }

    public static Entreprise toEntity(EntrepriseDTO entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();

        entreprise.setId(entrepriseDto.getId());
        entreprise.setRaisonSociale(entrepriseDto.getRaisonSociale());
        entreprise.setAdresseEntreprise(entrepriseDto.getAdresseEntreprise());
        entreprise.setNumeroSiret(entrepriseDto.getNumeroSiret());
        entreprise.setTelephoneEntreprise(entrepriseDto.getTelephoneEntreprise());
        entreprise.setEmailEntreprise(entrepriseDto.getEmailEntreprise());

        //Foreign key
        entreprise.setIdVille(entrepriseDto.getIdVille());
        entreprise.setIdFormeJuridique(entrepriseDto.getIdFormeJuridique());
        entreprise.setIdDirigeant(entrepriseDto.getIdDirigeant());
        entreprise.setIdAssurance(entrepriseDto.getIdAssurance());

        return entreprise;
    }
}
