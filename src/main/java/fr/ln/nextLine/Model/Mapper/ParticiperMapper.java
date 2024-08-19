package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.ParticiperDTO;
import fr.ln.nextLine.Model.Dto.SessionDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Participer;
import fr.ln.nextLine.Model.Entity.Session;
import fr.ln.nextLine.Model.Entity.Utilisateur;

public class ParticiperMapper {

    private ParticiperMapper () {}

    public static ParticiperDTO toDTO(Participer participer) {

        if (participer == null) {
            return null;
        }

        SessionDTO sessionDTO = SessionMapper.toDTO(participer.getSession());
        UtilisateurDTO utilisateurDTO = UtilisateurMapper.toDTO(participer.getUtilisateur());

        ParticiperDTO participerDTO = new ParticiperDTO();

        participerDTO.setSessionDTO(sessionDTO);
        participerDTO.setUtilisateurDTO(utilisateurDTO);

        return participerDTO;
    }

    public static Participer toEntity(ParticiperDTO participerDTO) {

        if (participerDTO == null) {
            return null;
        }

        Session session = SessionMapper.toEntity(participerDTO.getSessionDTO());
        Utilisateur utilisateur = UtilisateurMapper.toEntity(participerDTO.getUtilisateurDTO());

        Participer participer = new Participer();

        participer.setSession(session);
        participer.setUtilisateur(utilisateur);

        return participer;
    }
}
