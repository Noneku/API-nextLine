package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Tuteur;
import fr.ln.nextLine.Service.TuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuteurs")
public class TuteurController {

    private final TuteurService tuteurService;

    @Autowired
    public TuteurController(TuteurService tuteurService) {
        this.tuteurService = tuteurService;
    }

    @GetMapping
    public ResponseEntity<List<Tuteur>> getAllTuteurs() {
        List<Tuteur> tuteurs = tuteurService.getAllTuteurs();
        return ResponseEntity.ok(tuteurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tuteur> getTuteurById(@PathVariable Integer id) {
        Tuteur tuteur = tuteurService.getTuteurById(id);
        if (tuteur != null) {
            return ResponseEntity.ok(tuteur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Tuteur> createTuteur(@RequestBody Tuteur tuteur) {
        Tuteur createdTuteur = tuteurService.createTuteur(tuteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTuteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tuteur> updateTuteur(@PathVariable Integer id, @RequestBody Tuteur tuteur) {
        Tuteur updatedTuteur = tuteurService.updateTuteur(id, tuteur);
        if (updatedTuteur != null) {
            return ResponseEntity.ok(updatedTuteur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTuteur(@PathVariable Integer id) {
        boolean deleted = tuteurService.deleteTuteur(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
