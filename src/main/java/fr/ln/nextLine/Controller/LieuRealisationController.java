package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.LieuRealisation;
import fr.ln.nextLine.Service.LieuRealisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lieux-realisation")
public class LieuRealisationController {

    private final LieuRealisationService lieuRealisationService;

    @Autowired
    public LieuRealisationController(LieuRealisationService lieuRealisationService) {
        this.lieuRealisationService = lieuRealisationService;
    }

    @GetMapping
    public ResponseEntity<List<LieuRealisation>> getAllLieuxRealisation() {
        List<LieuRealisation> lieuxRealisation = lieuRealisationService.getAllLieuxRealisations();
        return ResponseEntity.ok(lieuxRealisation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LieuRealisation> getLieuRealisationById(@PathVariable Integer id) {
        LieuRealisation lieuRealisation = lieuRealisationService.getLieuRealisationById(id);
        if (lieuRealisation != null) {
            return ResponseEntity.ok(lieuRealisation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LieuRealisation> createLieuRealisation(@RequestBody LieuRealisation lieuRealisation) {
        LieuRealisation createdLieuRealisation = lieuRealisationService.createLieuRealisation(lieuRealisation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLieuRealisation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LieuRealisation> updateLieuRealisation(@PathVariable Integer id, @RequestBody LieuRealisation lieuRealisation) {
        LieuRealisation updatedLieuRealisation = lieuRealisationService.updateLieuRealisation(id, lieuRealisation);
        if (updatedLieuRealisation != null) {
            return ResponseEntity.ok(updatedLieuRealisation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLieuRealisation(@PathVariable Integer id) {
        boolean deleted = lieuRealisationService.deleteLieuRealisation(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
