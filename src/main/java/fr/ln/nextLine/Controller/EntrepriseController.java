package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Entreprise;
import fr.ln.nextLine.Service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
        return ResponseEntity.ok(entreprises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Integer id) {
        Entreprise entreprise = entrepriseService.getEntrepriseById(id);
        if (entreprise != null) {
            return ResponseEntity.ok(entreprise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise createdEntreprise = entrepriseService.createEntreprise(entreprise);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntreprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Integer id, @RequestBody Entreprise entreprise) {
        Entreprise updatedEntreprise = entrepriseService.updateEntreprise(id, entreprise);
        if (updatedEntreprise != null) {
            return ResponseEntity.ok(updatedEntreprise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Integer id) {
        boolean deleted = entrepriseService.deleteEntreprise(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
