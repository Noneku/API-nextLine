package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Frequence;
import fr.ln.nextLine.Service.FrequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frequence")
public class FrequenceController {

    private final FrequenceService FrequenceService;

    @Autowired
    public FrequenceController(FrequenceService FrequenceService) {
        this.FrequenceService = FrequenceService;
    }

    @GetMapping
    public ResponseEntity<List<Frequence>> getAllFrequences() {
        List<Frequence> Frequences = FrequenceService.getAllFrequences();
        return ResponseEntity.ok(Frequences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frequence> getFrequenceById(@PathVariable Integer id) {
        Frequence Frequence = FrequenceService.getFrequenceById(id);
        if (Frequence != null) {
            return ResponseEntity.ok(Frequence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Frequence> createFrequence(@RequestBody Frequence Frequence) {
        Frequence createdFrequence = FrequenceService.createFrequence(Frequence);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFrequence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frequence> updateFrequence(@PathVariable Integer id, @RequestBody Frequence Frequence) {
        Frequence updatedFrequence = FrequenceService.updateFrequence(id, Frequence);
        if (updatedFrequence != null) {
            return ResponseEntity.ok(updatedFrequence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrequence(@PathVariable Integer id) {
        boolean deleted = FrequenceService.deleteFrequence(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
