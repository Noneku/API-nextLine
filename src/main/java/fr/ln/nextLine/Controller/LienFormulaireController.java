package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Service.LienFormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/liens-formulaires")
public class LienFormulaireController {

    private final LienFormulaireService lienFormulaireService;

    @Autowired
    public LienFormulaireController(LienFormulaireService lienFormulaireService) {

        this.lienFormulaireService = lienFormulaireService;
    }

    @GetMapping
    public ResponseEntity<List<LienFormulaireDTO>> getAllLiensFormulaires() {

        return lienFormulaireService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LienFormulaireDTO> getLienFormulaireById(@PathVariable Integer id) {

        return lienFormulaireService.getById(id);
    }

    @PostMapping
    public ResponseEntity<LienFormulaireDTO> createLienFormulaire(@RequestBody LienFormulaireDTO lienFormulaireDTO) {

        return lienFormulaireService.create(lienFormulaireDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LienFormulaireDTO> updateLienFormulaire(@PathVariable Integer id, @RequestBody LienFormulaireDTO lienFormulaireDTO) {

        return lienFormulaireService.update(id, lienFormulaireDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLienFormulaire(@PathVariable Integer id) {

        return lienFormulaireService.delete(id);

    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateLienFormulaire(@RequestBody Map<String, String> request) {

        Integer idUtilisateur = Integer.parseInt(request.get("id_utilisateur"));
        String emailEntreprise = request.get("email_entreprise");

        return lienFormulaireService.generateAndSendLink(idUtilisateur, emailEntreprise);
    }

    @GetMapping("/verify-token")
    public ResponseEntity<Boolean> verifyToken(@RequestParam String token) {
        boolean isValid = lienFormulaireService.isTokenValid(token);

        System.out.println("isValid = " + isValid);
        return new ResponseEntity<>(isValid, isValid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }
}
