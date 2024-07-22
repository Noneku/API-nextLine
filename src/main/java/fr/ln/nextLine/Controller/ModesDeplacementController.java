package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ModesDeplacementDTO;
import fr.ln.nextLine.Model.Entity.ModesDeplacement;
import fr.ln.nextLine.Model.Mapper.ModesDeplacementMapper;
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
    public ResponseEntity<List<ModesDeplacementDTO>> getAllModesDeplacement() {

        List<ModesDeplacement> modesDeplacements = modesDeplacementService.getAllModesDeplacements();
        List<ModesDeplacementDTO> modesDeplacementDTO = modesDeplacements
                .stream()
                .map(ModesDeplacementMapper::toDTO)
                .toList();

        return new ResponseEntity<>(modesDeplacementDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModesDeplacementDTO> getModeDeplacementById(@PathVariable Integer id) {

        ModesDeplacement modesDeplacement = modesDeplacementService.getModeDeplacementById(id);

        return new ResponseEntity<>(ModesDeplacementMapper.toDTO(modesDeplacement), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModesDeplacementDTO> createModeDeplacement(@RequestBody ModesDeplacementDTO modesDeplacementDTO) {

        ModesDeplacement modesDeplacement = ModesDeplacementMapper.toEntity(modesDeplacementDTO);
        ModesDeplacement createdModeDeplacement = modesDeplacementService.createModeDeplacement(modesDeplacement);
        ModesDeplacementDTO createdModesDeplacementDTO = ModesDeplacementMapper.toDTO(createdModeDeplacement);

        return new ResponseEntity<>(createdModesDeplacementDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModesDeplacementDTO> updateModeDeplacement(@PathVariable Integer id, @RequestBody ModesDeplacementDTO modesDeplacementDTO) {

        ModesDeplacement modesDeplacement = ModesDeplacementMapper.toEntity(modesDeplacementDTO);
        ModesDeplacement updatedModesDeplacement = modesDeplacementService.updateModeDeplacement(id, modesDeplacement);

        if (updatedModesDeplacement != null) {
            ModesDeplacementDTO updatedModesDeplacementDTO = ModesDeplacementMapper.toDTO(updatedModesDeplacement);
            return new ResponseEntity<>(updatedModesDeplacementDTO, HttpStatus.OK);
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
