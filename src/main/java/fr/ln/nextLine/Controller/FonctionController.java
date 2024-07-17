package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Service.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fonction")
public class FonctionController {

    private final FonctionService FonctionService;

    @Autowired
    public FonctionController(FonctionService FonctionService) {
        this.FonctionService = FonctionService;
    }

    @GetMapping
    public ResponseEntity<List<Fonction>> getAllFonctions() {
        List<Fonction> Fonctions = FonctionService.getAllFonctions();
        return ResponseEntity.ok(Fonctions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fonction> getFonctionById(@PathVariable Integer id) {
        Fonction Fonction = FonctionService.getFonctionById(id);
        if (Fonction != null) {
            return ResponseEntity.ok(Fonction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Fonction> createFonction(@RequestBody Fonction Fonction) {
        Fonction createdFonction = FonctionService.createFonction(Fonction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFonction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fonction> updateFonction(@PathVariable Integer id, @RequestBody Fonction Fonction) {
        Fonction updatedFonction = FonctionService.updateFonction(id, Fonction);
        if (updatedFonction != null) {
            return ResponseEntity.ok(updatedFonction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFonction(@PathVariable Integer id) {
        boolean deleted = FonctionService.deleteFonction(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
