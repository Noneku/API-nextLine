package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Stage;
import fr.ln.nextLine.Service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stages")
public class StageController {

    private final StageService stageService;

    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping
    public ResponseEntity<List<Stage>> getAllStages() {
        List<Stage> stages = stageService.getAllStages();
        return ResponseEntity.ok(stages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> getStageById(@PathVariable Integer id) {
        Stage stage = stageService.getStageById(id);
        if (stage != null) {
            return ResponseEntity.ok(stage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Stage> createStage(@RequestBody Stage stage) {
        Stage createdStage = stageService.createStage(stage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stage> updateStage(@PathVariable Integer id, @RequestBody Stage stage) {
        Stage updatedStage = stageService.updateStage(id, stage);
        if (updatedStage != null) {
            return ResponseEntity.ok(updatedStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Integer id) {
        boolean deleted = stageService.deleteStage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
