package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Service.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fonctions")
public class FonctionController {

    private final FonctionService fonctionService;

    @Autowired
    public FonctionController(FonctionService fonctionService) {
        this.fonctionService = fonctionService;
    }

    @GetMapping
    public ResponseEntity<List<Fonction>> getAllFonctions() {
        List<Fonction> fonctions = fonctionService.getAllFonctions();
        return ResponseEntity.ok(fonctions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fonction> getFonctionById(@PathVariable Integer id) {
        Fonction fonction = fonctionService.getFonctionById(id);
        if (fonction != null) {
            return ResponseEntity.ok(fonction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Fonction> createFonction(@RequestBody Fonction fonction) {
        Fonction createdFonction = fonctionService.createFonction(fonction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFonction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fonction> updateFonction(@PathVariable Integer id, @RequestBody Fonction fonction) {
        Fonction updatedFonction = fonctionService.updateFonction(id, fonction);
        if (updatedFonction != null) {
            return ResponseEntity.ok(updatedFonction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFonction(@PathVariable Integer id) {
        boolean deleted = fonctionService.deleteFonction(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
