package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ModesDeplacementDTO;
import fr.ln.nextLine.Service.ModesDeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ModesDeplacementDTO>> getAllModesDeplacement() {

        return modesDeplacementService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModesDeplacementDTO> getModesDeplacementById(@PathVariable Integer id) {

        return modesDeplacementService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ModesDeplacementDTO> createModesDeplacement(@RequestBody ModesDeplacementDTO modesDeplacementDTO) {

        return modesDeplacementService.create(modesDeplacementDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModesDeplacementDTO> updateModesDeplacement(@PathVariable Integer id, @RequestBody ModesDeplacementDTO modesDeplacementDTO) {

        return modesDeplacementService.update(id, modesDeplacementDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModesDeplacement(@PathVariable Integer id) {

        return modesDeplacementService.delete(id);

    }
}
