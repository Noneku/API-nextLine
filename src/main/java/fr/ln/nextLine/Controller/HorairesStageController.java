package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.HorairesStageDTO;
import fr.ln.nextLine.Service.HorairesStageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horaires-stages")
public class HorairesStageController {

    private final HorairesStageService horairesStageService;

    public HorairesStageController(HorairesStageService horairesStageService) {

        this.horairesStageService = horairesStageService;
    }

    @GetMapping
    public ResponseEntity<List<HorairesStageDTO>> getAllHorairesStage() {

        return horairesStageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorairesStageDTO> getHorairesStageById(@PathVariable Integer id) {

        return horairesStageService.getById(id);
    }

    @PostMapping
    public ResponseEntity<HorairesStageDTO> createHorairesStage(@RequestBody HorairesStageDTO horairesStageDTO) {

        return horairesStageService.create(horairesStageDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorairesStageDTO> updateHorairesStage(@PathVariable Integer id, @RequestBody HorairesStageDTO horairesStageDTO) {

        return horairesStageService.update(id, horairesStageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorairesStage(@PathVariable Integer id) {

        return horairesStageService.delete(id);
    }
}