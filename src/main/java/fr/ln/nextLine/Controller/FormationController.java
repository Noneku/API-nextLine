package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Formation;
import fr.ln.nextLine.Service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {

    private final FormationService FormationService;

    @Autowired
    public FormationController(FormationService FormationService) {
        this.FormationService = FormationService;
    }

    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> Formations = FormationService.getAllFormations();
        return ResponseEntity.ok(Formations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable Integer id) {
        Formation Formation = FormationService.getFormationById(id);
        if (Formation != null) {
            return ResponseEntity.ok(Formation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Formation> createFormation(@RequestBody Formation Formation) {
        Formation createdFormation = FormationService.createFormation(Formation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFormation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable Integer id, @RequestBody Formation Formation) {
        Formation updatedFormation = FormationService.updateFormation(id, Formation);
        if (updatedFormation != null) {
            return ResponseEntity.ok(updatedFormation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Integer id) {
        boolean deleted = FormationService.deleteFormation(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
