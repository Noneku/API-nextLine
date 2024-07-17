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

    private final HorairesStageService horairesStageService;

    @Autowired
    public HorairesStageController(HorairesStageService horairesStageService) {
        this.horairesStageService = horairesStageService;
    }

    @GetMapping
    public ResponseEntity<List<HorairesStage>> getAllHorairesStages() {
        List<HorairesStage> horairesStages = horairesStageService.getAllHorairesStages();
        return ResponseEntity.ok(horairesStages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorairesStage> getHorairesStageById(@PathVariable Integer id) {
        HorairesStage horairesStage = horairesStageService.getHorairesStageById(id);
        if (horairesStage != null) {
            return ResponseEntity.ok(horairesStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HorairesStage> createHorairesStage(@RequestBody HorairesStage horairesStage) {
        HorairesStage createdHorairesStage = horairesStageService.createHorairesStage(horairesStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHorairesStage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorairesStage> updateHorairesStage(@PathVariable Integer id, @RequestBody HorairesStage horairesStage) {
        HorairesStage updatedHorairesStage = horairesStageService.updateHorairesStage(id, horairesStage);
        if (updatedHorairesStage != null) {
            return ResponseEntity.ok(updatedHorairesStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorairesStage(@PathVariable Integer id) {
        boolean deleted = horairesStageService.deleteHorairesStage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}