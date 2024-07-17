package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Service.FormeJuridiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forme-juridique")
public class FormeJuridiqueController {

    private final FormeJuridiqueService FormeJuridiqueService;

    @Autowired
    public FormeJuridiqueController(FormeJuridiqueService FormeJuridiqueService) {
        this.FormeJuridiqueService = FormeJuridiqueService;
    }

    @GetMapping
    public ResponseEntity<List<FormeJuridique>> getAllFormeJuridiques() {
        List<FormeJuridique> FormeJuridiques = FormeJuridiqueService.getAllFormeJuridiques();
        return ResponseEntity.ok(FormeJuridiques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormeJuridique> getFormeJuridiqueById(@PathVariable Integer id) {
        FormeJuridique FormeJuridique = FormeJuridiqueService.getFormeJuridiqueById(id);
        if (FormeJuridique != null) {
            return ResponseEntity.ok(FormeJuridique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FormeJuridique> createFormeJuridique(@RequestBody FormeJuridique FormeJuridique) {
        FormeJuridique createdFormeJuridique = FormeJuridiqueService.createFormeJuridique(FormeJuridique);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFormeJuridique);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormeJuridique> updateFormeJuridique(@PathVariable Integer id, @RequestBody FormeJuridique FormeJuridique) {
        FormeJuridique updatedFormeJuridique = FormeJuridiqueService.updateFormeJuridique(id, FormeJuridique);
        if (updatedFormeJuridique != null) {
            return ResponseEntity.ok(updatedFormeJuridique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormeJuridique(@PathVariable Integer id) {
        boolean deleted = FormeJuridiqueService.deleteFormeJuridique(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
