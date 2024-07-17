package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    private final AssuranceService AssuranceService;

    @Autowired
    public AssuranceController(AssuranceService AssuranceService) {
        this.AssuranceService = AssuranceService;
    }

    @GetMapping
    public ResponseEntity<List<Assurance>> getAllAssurances() {
        List<Assurance> Assurances = AssuranceService.getAllAssurances();
        return ResponseEntity.ok(Assurances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assurance> getAssuranceById(@PathVariable Integer id) {
        Assurance Assurance = AssuranceService.getAssuranceById(id);
        if (Assurance != null) {
            return ResponseEntity.ok(Assurance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Assurance> createAssurance(@RequestBody Assurance Assurance) {
        Assurance createdAssurance = AssuranceService.createAssurance(Assurance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssurance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assurance> updateAssurance(@PathVariable Integer id, @RequestBody Assurance Assurance) {
        Assurance updatedAssurance = AssuranceService.updateAssurance(id, Assurance);
        if (updatedAssurance != null) {
            return ResponseEntity.ok(updatedAssurance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssurance(@PathVariable Integer id) {
        boolean deleted = AssuranceService.deleteAssurance(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
