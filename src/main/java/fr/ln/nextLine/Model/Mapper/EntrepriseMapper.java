package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.*;
import fr.ln.nextLine.Model.Entity.*;


public class EntrepriseMapper {

    private EntrepriseMapper() {}

    public static EntrepriseDTO toDTO(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }

        VilleDTO villeDTO = VilleMapper.toDTO(entreprise.getVille());
        FormeJuridiqueDTO formeJuridiqueDTO = FormeJuridiqueMapper.toDTO(entreprise.getFormeJuridique());
        DirigeantDTO dirigeantDTO = DirigeantMapper.toDTO(entreprise.getDirigeant());
        AssuranceDTO assuranceDTO = AssuranceMapper.toDTO(entreprise.getAssurance());

        EntrepriseDTO entrepriseDto = new EntrepriseDTO();

        entrepriseDto.setId(entreprise.getId());
        entrepriseDto.setRaisonSociale(entreprise.getRaisonSociale());
        entrepriseDto.setAdresseEntreprise(entreprise.getAdresseEntreprise());
        entrepriseDto.setNumeroSiret(entreprise.getNumeroSiret());
        entrepriseDto.setTelephoneEntreprise(entreprise.getTelephoneEntreprise());
        entrepriseDto.setEmailEntreprise(entreprise.getEmailEntreprise());

        //Foreign key
        entrepriseDto.setVilleDTO(villeDTO);
        entrepriseDto.setFormeJuridiqueDTO(formeJuridiqueDTO);
        entrepriseDto.setDirigeantDTO(dirigeantDTO);
        entrepriseDto.setAssuranceDTO(assuranceDTO);

        return entrepriseDto;
    }

    public static Entreprise toEntity(EntrepriseDTO entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }

        Ville ville = VilleMapper.toEntity(entrepriseDto.getVilleDTO());
        FormeJuridique formeJuridique = FormeJuridiqueMapper.toEntity(entrepriseDto.getFormeJuridiqueDTO());
        Dirigeant dirigeant = DirigeantMapper.toEntity(entrepriseDto.getDirigeantDTO());
        Assurance assurance = AssuranceMapper.toEntity(entrepriseDto.getAssuranceDTO());

        Entreprise entreprise = new Entreprise();

        entreprise.setId(entrepriseDto.getId());
        entreprise.setRaisonSociale(entrepriseDto.getRaisonSociale());
        entreprise.setAdresseEntreprise(entrepriseDto.getAdresseEntreprise());
        entreprise.setNumeroSiret(entrepriseDto.getNumeroSiret());
        entreprise.setTelephoneEntreprise(entrepriseDto.getTelephoneEntreprise());
        entreprise.setEmailEntreprise(entrepriseDto.getEmailEntreprise());

        //Foreign key
        entreprise.setVille(ville);
        entreprise.setFormeJuridique(formeJuridique);
        entreprise.setDirigeant(dirigeant);
        entreprise.setAssurance(assurance);

        return entreprise;
    }
}