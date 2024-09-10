package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.StageDTO;
import fr.ln.nextLine.Service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<StageDTO>> getAllStages() {

        return stageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageDTO> getStageById(@PathVariable Integer id) {

        return stageService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createStage(@RequestBody StageDTO stageDTO) {

        return stageService.create(stageDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStage(@PathVariable Integer id, @RequestBody StageDTO stageDTO) {

        return stageService.update(id, stageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStage(@PathVariable Integer id) {

        return stageService.delete(id);

    }
}
