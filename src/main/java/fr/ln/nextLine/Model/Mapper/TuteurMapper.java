package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Model.Dto.TuteurDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;
import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Model.Entity.Tuteur;

public class TuteurMapper {

    private TuteurMapper () {}

    public static TuteurDTO toDTO(Tuteur tuteur) {

        if (tuteur == null) {
            return null;
        }

        EntrepriseDTO entrepriseDTO = EntrepriseMapper.toDTO(tuteur.getEntreprise());
        FonctionDTO fonctionDTO = FonctionMapper.toDTO(tuteur.getFonction());

        TuteurDTO tuteurDTO = new TuteurDTO();

        tuteurDTO.setId(tuteur.getId());
        tuteurDTO.setNomTuteur(tuteur.getNomTuteur());
        tuteurDTO.setPrenomTuteur(tuteur.getPrenomTuteur());
        tuteurDTO.setEmailTuteur(tuteur.getEmailTuteur());
        tuteurDTO.setTelTuteur(tuteur.getTelTuteur());
        tuteurDTO.setEntrepriseDTO(entrepriseDTO);
        tuteurDTO.setFonctionDTO(fonctionDTO);

        return tuteurDTO;
    }

    public static Tuteur toEntity(TuteurDTO tuteurDTO) {

        if (tuteurDTO == null) {
            return null;
        }

        Entreprise entreprise = EntrepriseMapper.toEntity(tuteurDTO.getEntrepriseDTO());
        Fonction fonction = FonctionMapper.toEntity(tuteurDTO.getFonctionDTO());

        Tuteur tuteur = new Tuteur();

        tuteur.setId(tuteurDTO.getId());
        tuteur.setNomTuteur(tuteurDTO.getNomTuteur());
        tuteur.setPrenomTuteur(tuteurDTO.getPrenomTuteur());
        tuteur.setEmailTuteur(tuteurDTO.getEmailTuteur());
        tuteur.setTelTuteur(tuteurDTO.getTelTuteur());
        tuteur.setEntreprise(entreprise);
        tuteur.setFonction(fonction);

        return tuteur;
    }
}
