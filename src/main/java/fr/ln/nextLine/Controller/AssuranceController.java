package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import fr.ln.nextLine.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return assuranceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuranceDTO> getAssuranceById(@PathVariable Integer id) {
        return assuranceService.getById(id);
    }

    @PostMapping
    public ResponseEntity<AssuranceDTO> createAssurance(@RequestBody AssuranceDTO assuranceDTO) {
        return assuranceService.create(assuranceDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssuranceDTO> updateAssurance(@PathVariable Integer id, @RequestBody AssuranceDTO assuranceDTO) {
        return assuranceService.update(id, assuranceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssurance(@PathVariable Integer id) {
        return assuranceService.delete(id);
    }
}