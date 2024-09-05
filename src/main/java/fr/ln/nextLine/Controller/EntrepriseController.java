package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Service.EntrepriseService;
import fr.ln.nextLine.Service.FormulaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;
    private final FormulaireService formulaireService;

    public EntrepriseController(EntrepriseService entrepriseService,
                                FormulaireService formulaireService) {

        this.entrepriseService = entrepriseService;
        this.formulaireService = formulaireService;
    }

    @GetMapping
    public ResponseEntity<List<EntrepriseDTO>> getAllEntreprises() {

        return entrepriseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseById(@PathVariable Integer id) {

        return entrepriseService.getById(id);
    }

    @GetMapping("/siret/{numeroSiret}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseByNumeroSiret(@PathVariable String numeroSiret) {

        return entrepriseService.getByNumeroSiret(numeroSiret);
    }

    @PostMapping("/save-entreprise")
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

    @GetMapping("/verifier/{token}/{siret}")
    public ResponseEntity<EntrepriseDTO> checkEntreprise(
            @PathVariable String token,
            @PathVariable String siret) {

        EntrepriseDTO entrepriseDTO = entrepriseService.checkEntreprise(token, siret);
        return new ResponseEntity<>(entrepriseDTO, HttpStatus.OK);

    }
}
