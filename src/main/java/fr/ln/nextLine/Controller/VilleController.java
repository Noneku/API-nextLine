package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Ville;
import fr.ln.nextLine.Service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public ResponseEntity<List<Ville>> getAllVilles() {
        List<Ville> villes = villeService.getAllVilles();
        return ResponseEntity.ok(villes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable Integer id) {
        Ville ville = villeService.getVilleById(id);
        if (ville != null) {
            return ResponseEntity.ok(ville);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville) {
        Ville createdVille = villeService.createVille(ville);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVille);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable Integer id, @RequestBody Ville ville) {
        Ville updatedVille = villeService.updateVille(id, ville);
        if (updatedVille != null) {
            return ResponseEntity.ok(updatedVille);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Integer id) {
        boolean deleted = villeService.deleteVille(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
