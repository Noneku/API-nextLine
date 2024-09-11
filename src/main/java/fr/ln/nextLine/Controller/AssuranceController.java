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
    public ResponseEntity<?> createAssurance(@RequestBody AssuranceDTO assuranceDTO) {

        return assuranceService.create(assuranceDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAssurance(@PathVariable Integer id, @RequestBody AssuranceDTO assuranceDTO) {

        return assuranceService.update(id, assuranceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssurance(@PathVariable Integer id) {

        return assuranceService.delete(id);
    }

    // méthode qui permet de vérifier si une assurance existe en bdd ou de la créer dans le cas contraire
    @PostMapping("/find-or-create")
    public AssuranceDTO findOrCreateAssurance(@RequestParam String nomAssurance, @RequestParam String numeroBeneficiaire) {

        return assuranceService.findOrCreateAssurance(nomAssurance, numeroBeneficiaire);
    }
}

