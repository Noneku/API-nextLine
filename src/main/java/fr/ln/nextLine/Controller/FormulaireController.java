package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Service.FormulaireService;
import fr.ln.nextLine.Service.LienFormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/formulaire")
public class FormulaireController {

    private final FormulaireService formulaireService;
    private final LienFormulaireService lienFormulaireService;

    @Autowired
    public FormulaireController(
            FormulaireService formulaireService,
            LienFormulaireService lienFormulaireService) {

        this.lienFormulaireService = lienFormulaireService;
        this.formulaireService = formulaireService;
    }

    @GetMapping
    public ResponseEntity<String> afficherFormulaire(@RequestParam("token") String token) {
        return formulaireService.afficherFormulaire(token);
    }
}
