package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.SessionDTO;
import fr.ln.nextLine.Model.Entity.Session;
import fr.ln.nextLine.Model.Mapper.SessionMapper;
import fr.ln.nextLine.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> getAllSessions() {

        List<Session> sessions = sessionService.getAllSessions();
        List<SessionDTO> sessionDTOS = sessions
                .stream()
                .map(SessionMapper::toDTO)
                .toList();

        return new ResponseEntity<>(sessionDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable Integer id) {

        Session session = sessionService.getSessionById(id);

        return new ResponseEntity<>(SessionMapper.toDTO(session), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@RequestBody SessionDTO sessionDTO) {

        Session session = SessionMapper.toEntity(sessionDTO);
        Session createdSession = sessionService.createSession(session);
        SessionDTO createdSessionDTO = SessionMapper.toDTO(createdSession);

        return new ResponseEntity<>(createdSessionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionDTO> updateSession(@PathVariable Integer id, @RequestBody SessionDTO sessionDTO) {

        Session session = SessionMapper.toEntity(sessionDTO);
        Session updatedSession = sessionService.updateSession(id, session);

        if (updatedSession != null) {
            SessionDTO updatedSessionDTO = SessionMapper.toDTO(updatedSession);
            return new ResponseEntity<>(updatedSessionDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Integer id) {
        boolean deleted = sessionService.deleteSession(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
