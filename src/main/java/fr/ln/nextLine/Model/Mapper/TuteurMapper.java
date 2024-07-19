package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.TuteurDTO;
import fr.ln.nextLine.Model.Entity.Tuteur;

public class TuteurMapper {

    private TuteurMapper () {}

    public static TuteurDTO toDTO(Tuteur tuteur) {

        if (tuteur == null) {
            return null;
        }

        TuteurDTO tuteurDTO = new TuteurDTO();

        tuteurDTO.setId(tuteur.getId());
        tuteurDTO.setNomTuteur(tuteur.getNomTuteur());
        tuteurDTO.setPrenomTuteur(tuteur.getPrenomTuteur());
        tuteurDTO.setEmailTuteur(tuteur.getEmailTuteur());
        tuteurDTO.setTelTuteur(tuteur.getTelTuteur());
        tuteurDTO.setIdEntreprise(tuteur.getIdEntreprise());
        tuteurDTO.setIdFonction(tuteur.getIdFonction());

        return tuteurDTO;
    }

    public static Tuteur toEntity(TuteurDTO tuteurDTO) {

        if (tuteurDTO == null) {
            return null;
        }

        Tuteur tuteur = new Tuteur();

        tuteur.setId(tuteurDTO.getId());
        tuteur.setNomTuteur(tuteurDTO.getNomTuteur());
        tuteur.setPrenomTuteur(tuteurDTO.getPrenomTuteur());
        tuteur.setEmailTuteur(tuteurDTO.getEmailTuteur());
        tuteur.setTelTuteur(tuteurDTO.getTelTuteur());
        tuteur.setIdEntreprise(tuteurDTO.getIdEntreprise());
        tuteur.setIdFonction(tuteurDTO.getIdFonction());

        return tuteur;
    }
}
