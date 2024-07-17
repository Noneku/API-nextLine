package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Service.FormeJuridiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formes-juridiques")
public class FormeJuridiqueController {

    private final FormeJuridiqueService formeJuridiqueService;

    @Autowired
    public FormeJuridiqueController(FormeJuridiqueService formeJuridiqueService) {
        this.formeJuridiqueService = formeJuridiqueService;
    }

    @GetMapping
    public ResponseEntity<List<FormeJuridique>> getAllFormeJuridiques() {
        List<FormeJuridique> formeJuridiques = formeJuridiqueService.getAllFormeJuridiques();
        return ResponseEntity.ok(formeJuridiques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormeJuridique> getFormeJuridiqueById(@PathVariable Integer id) {
        FormeJuridique formeJuridique = formeJuridiqueService.getFormeJuridiqueById(id);
        if (formeJuridique != null) {
            return ResponseEntity.ok(formeJuridique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FormeJuridique> createFormeJuridique(@RequestBody FormeJuridique formeJuridique) {
        FormeJuridique createdFormeJuridique = formeJuridiqueService.createFormeJuridique(formeJuridique);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFormeJuridique);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormeJuridique> updateFormeJuridique(@PathVariable Integer id, @RequestBody FormeJuridique formeJuridique) {
        FormeJuridique updatedFormeJuridique = formeJuridiqueService.updateFormeJuridique(id, formeJuridique);
        if (updatedFormeJuridique != null) {
            return ResponseEntity.ok(updatedFormeJuridique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormeJuridique(@PathVariable Integer id) {
        boolean deleted = formeJuridiqueService.deleteFormeJuridique(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
