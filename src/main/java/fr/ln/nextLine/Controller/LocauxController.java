package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Locaux;
import fr.ln.nextLine.Service.LocauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locaux")
public class LocauxController {

    private final LocauxService locauxService;

    @Autowired
    public LocauxController(LocauxService locauxService) {
        this.locauxService = locauxService;
    }

    @GetMapping
    public ResponseEntity<List<Locaux>> getAllLocaux() {
        List<Locaux> locaux = locauxService.getAllLocaux();
        return ResponseEntity.ok(locaux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locaux> getLocalById(@PathVariable Integer id) {
        Locaux locaux = locauxService.getLocalById(id);
        if (locaux != null) {
            return ResponseEntity.ok(locaux);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Locaux> createLocal(@RequestBody Locaux locaux) {
        Locaux createdLocal = locauxService.createLocal(locaux);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLocal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locaux> updateLocal(@PathVariable Integer id, @RequestBody Locaux locaux) {
        Locaux updatedLocal = locauxService.updateLocal(id, locaux);
        if (updatedLocal != null) {
            return ResponseEntity.ok(updatedLocal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Integer id) {
        boolean deleted = locauxService.deleteLocal(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
