package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FormationDTO;
import fr.ln.nextLine.Model.Entity.Formation;
import fr.ln.nextLine.Model.Mapper.FormationMapper;
import fr.ln.nextLine.Service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {

    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        List<Formation> formations = formationService.getAllFormations();
        List<FormationDTO> formationsDTOs =
                    formations
                            .stream()
                            .map(FormationMapper::toDTO)
                            .toList();
        return ResponseEntity.ok(formationsDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Integer id) {
        Formation formation = formationService.getFormationById(id);
        if (formation != null) {
            return ResponseEntity.ok(FormationMapper.toDTO(formation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@RequestBody Formation formation) {
        Formation createdFormation = formationService.createFormation(formation);
        return ResponseEntity.status(HttpStatus.CREATED).body(FormationMapper.toDTO(createdFormation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Integer id, @RequestBody Formation formation) {
        Formation updatedFormation = formationService.updateFormation(id, formation);
        if (updatedFormation != null) {
            return ResponseEntity.ok(FormationMapper.toDTO(updatedFormation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Integer id) {
        boolean deleted = formationService.deleteFormation(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
