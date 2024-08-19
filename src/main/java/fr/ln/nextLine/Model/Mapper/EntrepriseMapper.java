package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.*;
import fr.ln.nextLine.Model.Entity.*;


public class EntrepriseMapper {

    private EntrepriseMapper() {}

    public static EntrepriseDTO toDTO(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }

        VilleDTO villeDTO = VilleMapper.toDTO(entreprise.getIdVille());
        FormeJuridiqueDTO formeJuridiqueDTO = FormeJuridiqueMapper.toDTO(entreprise.getIdFormeJuridique());
        DirigeantDTO dirigeantDTO = DirigeantMapper.toDTO(entreprise.getIdDirigeant());
        AssuranceDTO assuranceDTO = AssuranceMapper.toDTO(entreprise.getIdAssurance());

        EntrepriseDTO entrepriseDto = new EntrepriseDTO();

        entrepriseDto.setId(entreprise.getId());
        entrepriseDto.setRaisonSociale(entreprise.getRaisonSociale());
        entrepriseDto.setAdresseEntreprise(entreprise.getAdresseEntreprise());
        entrepriseDto.setNumeroSiret(entreprise.getNumeroSiret());
        entrepriseDto.setTelephoneEntreprise(entreprise.getTelephoneEntreprise());
        entrepriseDto.setEmailEntreprise(entreprise.getEmailEntreprise());

        //Foreign key
        entrepriseDto.setIdVille(villeDTO);
        entrepriseDto.setIdFormeJuridique(formeJuridiqueDTO);
        entrepriseDto.setIdDirigeant(dirigeantDTO);
        entrepriseDto.setIdAssurance(assuranceDTO);

        return entrepriseDto;
    }

    public static Entreprise toEntity(EntrepriseDTO entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }

        Ville ville = VilleMapper.toEntity(entrepriseDto.getIdVille());
        FormeJuridique formeJuridique = FormeJuridiqueMapper.toEntity(entrepriseDto.getIdFormeJuridique());
        Dirigeant dirigeant = DirigeantMapper.toEntity(entrepriseDto.getIdDirigeant());
        Assurance assurance = AssuranceMapper.toEntity(entrepriseDto.getIdAssurance());

        Entreprise entreprise = new Entreprise();

        entreprise.setId(entrepriseDto.getId());
        entreprise.setRaisonSociale(entrepriseDto.getRaisonSociale());
        entreprise.setAdresseEntreprise(entrepriseDto.getAdresseEntreprise());
        entreprise.setNumeroSiret(entrepriseDto.getNumeroSiret());
        entreprise.setTelephoneEntreprise(entrepriseDto.getTelephoneEntreprise());
        entreprise.setEmailEntreprise(entrepriseDto.getEmailEntreprise());

        //Foreign key
        entreprise.setIdVille(ville);
        entreprise.setIdFormeJuridique(formeJuridique);
        entreprise.setIdDirigeant(dirigeant);
        entreprise.setIdAssurance(assurance);

        return entreprise;
    }
}