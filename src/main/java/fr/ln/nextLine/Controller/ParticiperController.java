package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ParticiperDTO;
import fr.ln.nextLine.Service.ParticiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participer")
public class ParticiperController {

    private final ParticiperService participerService;

    @Autowired
    public ParticiperController(ParticiperService participerService) {

        this.participerService = participerService;
    }

    @GetMapping
    public ResponseEntity<List<ParticiperDTO>> getAllParticiper() {

        return participerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticiperDTO> getParticiperById(@PathVariable Integer id) {

        return participerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createParticiper(@RequestBody ParticiperDTO participerDTO) {

        return participerService.create(participerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateParticiper(@PathVariable Integer id, @RequestBody ParticiperDTO participerDTO) {

        return participerService.update(id, participerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticiper(@PathVariable Integer id) {

        return participerService.delete(id);

    }

    @PostMapping("/ajouter-utilisateur")
    public void addUtilisateurToSession(
            @RequestParam Integer sessionId,
            @RequestParam Integer utilisateurId) {
        participerService.ajouterUtilisateurAUneSession(sessionId, utilisateurId);
    }
}
