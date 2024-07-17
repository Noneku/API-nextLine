package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.ModesDeplacement;
import fr.ln.nextLine.Service.ModesDeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modes-deplacement")
public class ModesDeplacementController {

    private final ModesDeplacementService modesDeplacementService;

    @Autowired
    public ModesDeplacementController(ModesDeplacementService modesDeplacementService) {
        this.modesDeplacementService = modesDeplacementService;
    }

    @GetMapping
    public ResponseEntity<List<ModesDeplacement>> getAllModesDeplacement() {
        List<ModesDeplacement> modesDeplacement = modesDeplacementService.getAllModesDeplacements();
        return ResponseEntity.ok(modesDeplacement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModesDeplacement> getModeDeplacementById(@PathVariable Integer id) {
        ModesDeplacement modesDeplacement = modesDeplacementService.getModeDeplacementById(id);
        if (modesDeplacement != null) {
            return ResponseEntity.ok(modesDeplacement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ModesDeplacement> createModeDeplacement(@RequestBody ModesDeplacement modesDeplacement) {
        ModesDeplacement createdModeDeplacement = modesDeplacementService.createModeDeplacement(modesDeplacement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModeDeplacement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModesDeplacement> updateModeDeplacement(@PathVariable Integer id, @RequestBody ModesDeplacement modesDeplacement) {
        ModesDeplacement updatedModeDeplacement = modesDeplacementService.updateModeDeplacement(id, modesDeplacement);
        if (updatedModeDeplacement != null) {
            return ResponseEntity.ok(updatedModeDeplacement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModeDeplacement(@PathVariable Integer id) {
        boolean deleted = modesDeplacementService.deleteModeDeplacement(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
