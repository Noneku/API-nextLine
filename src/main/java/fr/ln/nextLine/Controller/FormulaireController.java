package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Service.FormulaireService;
import fr.ln.nextLine.Service.LienFormulaireService;
import fr.ln.nextLine.Service.ServiceExt.CacheService;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/formulaire")
public class FormulaireController {

    private final FormulaireService formulaireService;
    private final LienFormulaireService lienFormulaireService;
    private final UtilisateurService utilisateurService;
    private final CacheService cacheService;

    @Autowired
    public FormulaireController(
            FormulaireService formulaireService,
            LienFormulaireService lienFormulaireService,
            UtilisateurService utilisateurService,
            CacheService cacheService) {

        this.lienFormulaireService = lienFormulaireService;
        this.formulaireService = formulaireService;
        this.utilisateurService = utilisateurService;
        this.cacheService = cacheService;
    }

    @GetMapping
    public ResponseEntity<String> afficherFormulaire(@RequestParam("token") String token) {
        return formulaireService.afficherFormulaire(token);
    }


    @GetMapping("/utilisateur-connecte")
    public UtilisateurDTO afficherUtilisateurConnecte() {
        return utilisateurService.recupererUtilisateurConnecte();
    }

    @GetMapping("/cache/entreprise/{token}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseFromCache(@PathVariable String token) {
        // Tentative de récupération de l'entreprise depuis le cache
        EntrepriseDTO entrepriseDTO = cacheService.getEntrepriseFromCache(token);

        if (entrepriseDTO != null) {

            System.out.println("Entreprise DTO : " + entrepriseDTO.getRaisonSociale());

            return new ResponseEntity<>(entrepriseDTO, HttpStatus.OK);

        } else {

            System.out.println("Affichage entreprise KO");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
