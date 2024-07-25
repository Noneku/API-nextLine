package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FormationDTO;
import fr.ln.nextLine.Service.FormationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {

        this.formationService = formationService;
    }

    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {

        return formationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Integer id) {

        return formationService.getById(id);
    }

    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {

        return formationService.create(formationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Integer id, @RequestBody FormationDTO formationDTO) {

        return formationService.update(id, formationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Integer id) {

        return formationService.delete(id);
    }
}
