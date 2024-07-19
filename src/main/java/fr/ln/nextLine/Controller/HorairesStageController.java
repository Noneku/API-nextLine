package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.HorairesStageDTO;
import fr.ln.nextLine.Model.Entity.HorairesStage;
import fr.ln.nextLine.Model.Mapper.HorairesStageMapper;
import fr.ln.nextLine.Service.HorairesStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<HorairesStageDTO>> getAllHorairesStages() {
        List<HorairesStage> horairesStages = horairesStageService.getAllHorairesStages();
        List<HorairesStageDTO> horairesStageDTOs =
                horairesStages
                        .stream()
                        .map(HorairesStageMapper::toDTO)
                        .toList();
        return ResponseEntity.ok(horairesStageDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorairesStageDTO> getHorairesStageById(@PathVariable Integer id) {
        HorairesStage horairesStage = horairesStageService.getHorairesStageById(id);
        if (horairesStage != null) {
            return ResponseEntity.ok(HorairesStageMapper.toDTO(horairesStage));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HorairesStageDTO> createHorairesStage(@RequestBody HorairesStage horairesStage) {
        HorairesStage createdHorairesStage = horairesStageService.createHorairesStage(horairesStage);

        return ResponseEntity.status(HttpStatus.CREATED).body(HorairesStageMapper.toDTO(createdHorairesStage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorairesStageDTO> updateHorairesStage(@PathVariable Integer id, @RequestBody HorairesStage horairesStage) {
        HorairesStage updatedHorairesStage = horairesStageService.updateHorairesStage(id, horairesStage);
        if (updatedHorairesStage != null) {
            return ResponseEntity.ok(HorairesStageMapper.toDTO(updatedHorairesStage));
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