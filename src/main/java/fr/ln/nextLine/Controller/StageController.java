package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.StageDTO;
import fr.ln.nextLine.Model.Entity.Stage;
import fr.ln.nextLine.Model.Mapper.StageMapper;
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
    public ResponseEntity<List<StageDTO>> getAllStages() {

        List<Stage> stages = stageService.getAllStages();
        List<StageDTO> stagesDTO = stages
                .stream()
                .map(StageMapper::toDTO)
                .toList();

        return new ResponseEntity<>(stagesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageDTO> getStageById(@PathVariable Integer id) {

        Stage stage = stageService.getStageById(id);

        return new ResponseEntity<>(StageMapper.toDTO(stage), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StageDTO> createStage(@RequestBody StageDTO stageDTO) {

        Stage stage = StageMapper.toEntity(stageDTO);
        Stage createdStage = stageService.createStage(stage);
        StageDTO createdStageDTO = StageMapper.toDTO(createdStage);

        return new ResponseEntity<>(createdStageDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageDTO> updateStage(@PathVariable Integer id, @RequestBody StageDTO stageDTO) {

        Stage stage = StageMapper.toEntity(stageDTO);
        Stage updatedStage = stageService.updateStage(id, stage);

        if (updatedStage != null) {
            StageDTO updatedStageDTO = StageMapper.toDTO(updatedStage);
            return new ResponseEntity<>(updatedStageDTO, HttpStatus.OK);
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
