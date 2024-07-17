package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Assurance>> getAllAssurances() {
        List<Assurance> assurances = assuranceService.getAllAssurances();
        return ResponseEntity.ok(assurances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assurance> getAssuranceById(@PathVariable Integer id) {
        Assurance assurance = assuranceService.getAssuranceById(id);
        if (assurance != null) {
            return ResponseEntity.ok(assurance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Assurance> createAssurance(@RequestBody Assurance assurance) {
        Assurance createdAssurance = assuranceService.createAssurance(assurance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssurance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assurance> updateAssurance(@PathVariable Integer id, @RequestBody Assurance Assurance) {
        Assurance updatedAssurance = assuranceService.updateAssurance(id, Assurance);
        if (updatedAssurance != null) {
            return ResponseEntity.ok(updatedAssurance);
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
