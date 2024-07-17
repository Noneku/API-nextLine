package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Entreprise;
import fr.ln.nextLine.Service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {

    private final EntrepriseService EntrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService EntrepriseService) {
        this.EntrepriseService = EntrepriseService;
    }

    @GetMapping
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        List<Entreprise> Entreprises = EntrepriseService.getAllEntreprises();
        return ResponseEntity.ok(Entreprises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Integer id) {
        Entreprise Entreprise = EntrepriseService.getEntrepriseById(id);
        if (Entreprise != null) {
            return ResponseEntity.ok(Entreprise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise Entreprise) {
        Entreprise createdEntreprise = EntrepriseService.createEntreprise(Entreprise);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntreprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Integer id, @RequestBody Entreprise Entreprise) {
        Entreprise updatedEntreprise = EntrepriseService.updateEntreprise(id, Entreprise);
        if (updatedEntreprise != null) {
            return ResponseEntity.ok(updatedEntreprise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Integer id) {
        boolean deleted = EntrepriseService.deleteEntreprise(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
