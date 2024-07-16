package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.HorairesStage;
import fr.ln.nextLine.Service.HorairesStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horaires-stages")
public class HorairesStageController {

    private final HorairesStageService HorairesStageService;

    @Autowired
    public HorairesStageController(HorairesStageService HorairesStageService) {
        this.HorairesStageService = HorairesStageService;
    }

    @GetMapping
    public ResponseEntity<List<HorairesStage>> getAllHorairesStages() {
        List<HorairesStage> HorairesStages = HorairesStageService.getAllHorairesStages();
        return ResponseEntity.ok(HorairesStages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorairesStage> getHorairesStageById(@PathVariable Integer id) {
        HorairesStage HorairesStage = HorairesStageService.getHorairesStageById(id);
        if (HorairesStage != null) {
            return ResponseEntity.ok(HorairesStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HorairesStage> createHorairesStage(@RequestBody HorairesStage HorairesStage) {
        HorairesStage createdHorairesStage = HorairesStageService.createHorairesStage(HorairesStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHorairesStage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorairesStage> updateHorairesStage(@PathVariable Integer id, @RequestBody HorairesStage HorairesStage) {
        HorairesStage updatedHorairesStage = HorairesStageService.updateHorairesStage(id, HorairesStage);
        if (updatedHorairesStage != null) {
            return ResponseEntity.ok(updatedHorairesStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorairesStage(@PathVariable Integer id) {
        boolean deleted = HorairesStageService.deleteHorairesStage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}