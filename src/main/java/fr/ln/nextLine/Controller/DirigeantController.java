package fr.ln.nextLine.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Service.DirigeantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dirigeant")

public class DirigeantController {

    private final DirigeantService DirigeantService;

    @Autowired
    public DirigeantController(DirigeantService DirigeantService) {
        this.DirigeantService = DirigeantService;
    }

    @GetMapping
    public ResponseEntity<List<Dirigeant>> getAllDirigeants() {
        List<Dirigeant> Dirigeants = DirigeantService.getAllDirigeants();
        return ResponseEntity.ok(Dirigeants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dirigeant> getDirigeantById(@PathVariable Integer id) {
        Dirigeant Dirigeant = DirigeantService.getDirigeantById(id);
        if (Dirigeant != null) {
            return ResponseEntity.ok(Dirigeant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Dirigeant> createDirigeant(@RequestBody Dirigeant Dirigeant) {
        Dirigeant createdDirigeant = DirigeantService.createDirigeant(Dirigeant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDirigeant);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Dirigeant> updateDirigeant(@PathVariable Integer id, @RequestBody Dirigeant Dirigeant) {
        Dirigeant updatedDirigeant = DirigeantService.updateDirigeant(id, Dirigeant);
        if (updatedDirigeant != null) {
            return ResponseEntity.ok(updatedDirigeant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirigeant(@PathVariable Integer id) {
        boolean deleted = DirigeantService.deleteDirigeant(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
