package fr.ln.nextLine.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Service.EntrepriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-nextline/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {

        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public ResponseEntity<List<EntrepriseDTO>> getAllEntreprises() {

        return entrepriseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseById(@PathVariable Integer id) {

        return entrepriseService.getById(id);
    }

    @PostMapping
    public ResponseEntity<EntrepriseDTO> createEntreprise(@RequestBody EntrepriseDTO entrepriseDTO) {

        return entrepriseService.create(entrepriseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> updateEntreprise(@PathVariable Integer id, @RequestBody EntrepriseDTO entrepriseDTO) {

        return entrepriseService.update(id, entrepriseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Integer id) {

        return entrepriseService.delete(id);

    }

    @GetMapping("/verifier/{siret}")
    public ResponseEntity<EntrepriseDTO> verifierEntreprise(@PathVariable String siret) {

        EntrepriseDTO entrepriseDTO = entrepriseService.verifierEntreprise(siret);
        return new ResponseEntity<>(entrepriseDTO, HttpStatus.OK);

    }

    @PostMapping("/save-entreprise")
    public ResponseEntity<EntrepriseDTO> saveEntreprise(@RequestBody EntrepriseDTO entrepriseDTO) {

        return entrepriseService.saveEntreprise(entrepriseDTO);
    }
}
