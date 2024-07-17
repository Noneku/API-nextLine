package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Jour;
import fr.ln.nextLine.Service.JourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jours")
public class JourController {

    private final JourService jourService;

    @Autowired
    public JourController(JourService jourService) {
        this.jourService = jourService;
    }

    @GetMapping
    public ResponseEntity<List<Jour>> getAllJours() {
        List<Jour> jours = jourService.getAllJours();
        return ResponseEntity.ok(jours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jour> getJourById(@PathVariable Integer id) {
        Jour jour = jourService.getJourById(id);
        if (jour != null) {
            return ResponseEntity.ok(jour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Jour> createJour(@RequestBody Jour jour) {
        Jour createdJour = jourService.createJour(jour);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jour> updateJour(@PathVariable Integer id, @RequestBody Jour jour) {
        Jour updatedJour = jourService.updateJour(id, jour);
        if (updatedJour != null) {
            return ResponseEntity.ok(updatedJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJour(@PathVariable Integer id) {
        boolean deleted = jourService.deleteJour(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
