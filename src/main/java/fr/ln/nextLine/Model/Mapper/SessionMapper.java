package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.FormationDTO;
import fr.ln.nextLine.Model.Dto.SessionDTO;
import fr.ln.nextLine.Model.Entity.Formation;
import fr.ln.nextLine.Model.Entity.Session;

public class SessionMapper {

    private SessionMapper () {}

    public static SessionDTO toDTO(Session session) {

        if (session == null) {
            return null;
        }

        FormationDTO formationDTO = FormationMapper.toDTO(session.getFormation());

        SessionDTO sessionDTO = new SessionDTO();

        sessionDTO.setId(session.getId());
        sessionDTO.setDateDebutSession(session.getDateDebutSession());
        sessionDTO.setDateFinSession(session.getDateFinSession());
        sessionDTO.setNumeroOffre(session.getNumeroOffre());
        sessionDTO.setDateDebutStage(session.getDateDebutStage());
        sessionDTO.setDateFinStage(session.getDateFinStage());
        sessionDTO.setFormationDTO(formationDTO);

        return sessionDTO;
    }

    public static Session toEntity(SessionDTO sessionDTO) {

        if (sessionDTO == null) {
            return null;
        }

        Formation formation = FormationMapper.toEntity(sessionDTO.getFormationDTO());

        Session session = new Session();

        session.setId(sessionDTO.getId());
        session.setDateDebutSession(sessionDTO.getDateDebutSession());
        session.setDateFinSession(sessionDTO.getDateFinSession());
        session.setNumeroOffre(sessionDTO.getNumeroOffre());
        session.setDateDebutStage(sessionDTO.getDateDebutStage());
        session.setDateFinStage(sessionDTO.getDateFinStage());
        session.setFormation(formation);

        return session;
    }
}
