package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Mapper.AssuranceMapper;
import fr.ln.nextLine.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assurances")
public class AssuranceController {

    private final AssuranceService assuranceService;

    @Autowired
    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping
    public ResponseEntity<List<AssuranceDTO>> getAllAssurances() {
        List<Assurance> assurances = assuranceService.getAllAssurances();
        List<AssuranceDTO> assuranceDTOs =
                assurances
                        .stream()
                        .map(AssuranceMapper::toDTO)
                        .toList();
        return new ResponseEntity<>(assuranceDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuranceDTO> getAssuranceById(@PathVariable Integer id) {
        Assurance assurance = assuranceService.getAssuranceById(id);

        if (assurance != null) {
            return new ResponseEntity<>(AssuranceMapper.toDTO(assurance), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AssuranceDTO> createAssurance(@RequestBody Assurance assurance) {
        Assurance createdAssurance = assuranceService.createAssurance(assurance);

        return ResponseEntity.status(HttpStatus.CREATED).body(AssuranceMapper.toDTO(createdAssurance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssuranceDTO> updateAssurance(@PathVariable Integer id, @RequestBody Assurance assurance) {
        Assurance updatedAssurance = assuranceService.updateAssurance(id, assurance);

        if (updatedAssurance != null) {
            return ResponseEntity.ok(AssuranceMapper.toDTO(updatedAssurance));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssurance(@PathVariable Integer id) {
        boolean deleted = assuranceService.deleteAssurance(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
