package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.SessionDTO;
import fr.ln.nextLine.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return sessionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable Integer id) {

        return sessionService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createSession(@RequestBody SessionDTO sessionDTO) {

        return sessionService.create(sessionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSession(@PathVariable Integer id, @RequestBody SessionDTO sessionDTO) {

        return sessionService.update(id, sessionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable Integer id) {

        return sessionService.delete(id);

    }
}
