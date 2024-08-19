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

        SessionDTO sessionDTO = SessionMapper.toDTO(participer.getIdSession());
        UtilisateurDTO utilisateurDTO = UtilisateurMapper.toDTO(participer.getIdUtilisateur());

        ParticiperDTO participerDTO = new ParticiperDTO();

        participerDTO.setIdSession(sessionDTO);
        participerDTO.setIdUtilisateur(utilisateurDTO);

        return participerDTO;
    }

    public static Participer toEntity(ParticiperDTO participerDTO) {

        if (participerDTO == null) {
            return null;
        }

        Session session = SessionMapper.toEntity(participerDTO.getIdSession());
        Utilisateur utilisateur = UtilisateurMapper.toEntity(participerDTO.getIdUtilisateur());

        Participer participer = new Participer();

        participer.setIdSession(session);
        participer.setIdUtilisateur(utilisateur);

        return participer;
    }
}
