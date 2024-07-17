package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Service.DirigeantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dirigeants")

public class DirigeantController {

    private final DirigeantService dirigeantService;

    @Autowired
    public DirigeantController(DirigeantService dirigeantService) {
        this.dirigeantService = dirigeantService;
    }

    @GetMapping
    public ResponseEntity<List<Dirigeant>> getAllDirigeants() {
        List<Dirigeant> dirigeants = dirigeantService.getAllDirigeants();
        return ResponseEntity.ok(dirigeants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dirigeant> getDirigeantById(@PathVariable Integer id) {
        Dirigeant dirigeant = dirigeantService.getDirigeantById(id);
        if (dirigeant != null) {
            return ResponseEntity.ok(dirigeant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Dirigeant> createDirigeant(@RequestBody Dirigeant dirigeant) {
        Dirigeant createdDirigeant = dirigeantService.createDirigeant(dirigeant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDirigeant);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Dirigeant> updateDirigeant(@PathVariable Integer id, @RequestBody Dirigeant dirigeant) {
        Dirigeant updatedDirigeant = dirigeantService.updateDirigeant(id, dirigeant);
        if (updatedDirigeant != null) {
            return ResponseEntity.ok(updatedDirigeant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirigeant(@PathVariable Integer id) {
        boolean deleted = dirigeantService.deleteDirigeant(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
