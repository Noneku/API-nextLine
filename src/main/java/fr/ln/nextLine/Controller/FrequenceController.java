package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Frequence;
import fr.ln.nextLine.Service.FrequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frequences")
public class FrequenceController {

    private final FrequenceService frequenceService;

    @Autowired
    public FrequenceController(FrequenceService frequenceService) {
        this.frequenceService = frequenceService;
    }

    @GetMapping
    public ResponseEntity<List<Frequence>> getAllFrequences() {
        List<Frequence> frequences = frequenceService.getAllFrequences();
        return ResponseEntity.ok(frequences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frequence> getFrequenceById(@PathVariable Integer id) {
        Frequence frequence = frequenceService.getFrequenceById(id);
        if (frequence != null) {
            return ResponseEntity.ok(frequence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Frequence> createFrequence(@RequestBody Frequence frequence) {
        Frequence createdFrequence = frequenceService.createFrequence(frequence);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFrequence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frequence> updateFrequence(@PathVariable Integer id, @RequestBody Frequence frequence) {
        Frequence updatedFrequence = frequenceService.updateFrequence(id, frequence);
        if (updatedFrequence != null) {
            return ResponseEntity.ok(updatedFrequence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrequence(@PathVariable Integer id) {
        boolean deleted = frequenceService.deleteFrequence(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
