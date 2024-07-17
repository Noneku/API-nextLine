package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Service.LienFormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liens-formulaires")
public class LienFormulaireController {

    private final LienFormulaireService lienFormulaireService;

    @Autowired
    public LienFormulaireController(LienFormulaireService lienFormulaireService) {
        this.lienFormulaireService = lienFormulaireService;
    }

    @GetMapping
    public ResponseEntity<List<LienFormulaire>> getAllLiensFormulaires() {
        List<LienFormulaire> liensFormulaires = lienFormulaireService.getAllLiensFormulaires();
        return ResponseEntity.ok(liensFormulaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LienFormulaire> getLienFormulaireById(@PathVariable Integer id) {
        LienFormulaire lienFormulaire = lienFormulaireService.getLienFormulaireById(id);
        if (lienFormulaire != null) {
            return ResponseEntity.ok(lienFormulaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LienFormulaire> createLienFormulaire(@RequestBody LienFormulaire lienFormulaire) {
        LienFormulaire createdLienFormulaire = lienFormulaireService.createLienFormulaire(lienFormulaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLienFormulaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LienFormulaire> updateLienFormulaire(@PathVariable Integer id, @RequestBody LienFormulaire lienFormulaire) {
        LienFormulaire updatedLienFormulaire = lienFormulaireService.updateLienFormulaire(id, lienFormulaire);
        if (updatedLienFormulaire != null) {
            return ResponseEntity.ok(updatedLienFormulaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLienFormulaire(@PathVariable Integer id) {
        boolean deleted = lienFormulaireService.deleteLienFormulaire(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
