package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.DirigeantDTO;
import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Model.Mapper.ActiviteMapper;
import fr.ln.nextLine.Model.Mapper.DirigeantMapper;
import fr.ln.nextLine.Model.Mapper.LienFormulaireMapper;
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
    public ResponseEntity<List<DirigeantDTO>> getAllDirigeants() {
        List<Dirigeant> dirigeants = dirigeantService.getAllDirigeants();
        List<DirigeantDTO> DirigeantsDTOs =
                dirigeants
                        .stream()
                        .map(DirigeantMapper::toDTO)
                        .toList();
        return new ResponseEntity<>(DirigeantsDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirigeantDTO> getDirigeantById(@PathVariable Integer id) {
        Dirigeant dirigeant = dirigeantService.getDirigeantById(id);

        return new ResponseEntity<>(DirigeantMapper.toDTO(dirigeant), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DirigeantDTO> createDirigeant(@RequestBody Dirigeant dirigeant) {
        Dirigeant createdDirigeant = dirigeantService.createDirigeant(dirigeant);
        return ResponseEntity.status(HttpStatus.CREATED).body(DirigeantMapper.toDTO(createdDirigeant));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DirigeantDTO> updateDirigeant(@PathVariable Integer id, @RequestBody Dirigeant dirigeant) {
        Dirigeant updatedDirigeant = dirigeantService.updateDirigeant(id, dirigeant);
        if (updatedDirigeant != null) {
            return ResponseEntity.ok(DirigeantMapper.toDTO(updatedDirigeant));
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
