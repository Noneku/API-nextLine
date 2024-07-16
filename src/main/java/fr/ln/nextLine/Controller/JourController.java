package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Jour;
import fr.ln.nextLine.Service.JourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jour")
public class JourController {

    private final JourService JourService;

    @Autowired
    public JourController(JourService JourService) {
        this.JourService = JourService;
    }

    @GetMapping
    public ResponseEntity<List<Jour>> getAllJours() {
        List<Jour> Jours = JourService.getAllJours();
        return ResponseEntity.ok(Jours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jour> getJourById(@PathVariable Integer id) {
        Jour Jour = JourService.getJourById(id);
        if (Jour != null) {
            return ResponseEntity.ok(Jour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Jour> createJour(@RequestBody Jour Jour) {
        Jour createdJour = JourService.createJour(Jour);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jour> updateJour(@PathVariable Integer id, @RequestBody Jour Jour) {
        Jour updatedJour = JourService.updateJour(id, Jour);
        if (updatedJour != null) {
            return ResponseEntity.ok(updatedJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJour(@PathVariable Integer id) {
        boolean deleted = JourService.deleteJour(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
