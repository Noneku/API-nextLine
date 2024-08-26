package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Service.FormulaireService;
import fr.ln.nextLine.Service.LienFormulaireService;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/formulaire")
public class FormulaireController {

    private final FormulaireService formulaireService;
    private final LienFormulaireService lienFormulaireService;
    private final UtilisateurService utilisateurService;

    @Autowired
    public FormulaireController(
            FormulaireService formulaireService,
            LienFormulaireService lienFormulaireService,
            UtilisateurService utilisateurService) {

        this.lienFormulaireService = lienFormulaireService;
        this.formulaireService = formulaireService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<String> afficherFormulaire(@RequestParam("token") String token) {
        return formulaireService.afficherFormulaire(token);
    }

    @GetMapping("/utilisateur-connecte")
    public UtilisateurDTO afficherUtilisateurConnecte() {
        return utilisateurService.recupererUtilisateurConnecte();
    }
}
