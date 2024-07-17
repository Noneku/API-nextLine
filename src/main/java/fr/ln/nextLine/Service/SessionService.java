package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Session;
import fr.ln.nextLine.Model.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Integer id) {
        Optional<Session> session = sessionRepository.findById(id);
        return session.orElse(null);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(Integer id, Session updatedSession) {
        return null;
    }

    public boolean deleteSession(Integer id) {
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        if (sessionOptional.isPresent()) {
            sessionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
