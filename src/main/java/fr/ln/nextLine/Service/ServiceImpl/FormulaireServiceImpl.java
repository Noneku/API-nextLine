package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.FormulaireDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Repository.LienFormulaireRepository;
import fr.ln.nextLine.Service.FormulaireService;
import fr.ln.nextLine.Service.LienFormulaireService;
import fr.ln.nextLine.Service.ServiceExt.CacheService;
import fr.ln.nextLine.Service.UtilisateurService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FormulaireServiceImpl implements FormulaireService {

    @Autowired
    private final LienFormulaireRepository lienFormulaireRepository;
    private final LienFormulaireService lienFormulaireService;
    private final CacheService cacheService;

    @Autowired
    private UtilisateurService utilisateurService;

    public FormulaireServiceImpl(
            LienFormulaireRepository lienFormulaireRepository,
            LienFormulaireService lienFormulaireService,
            CacheService cacheService) {

        this.lienFormulaireRepository = lienFormulaireRepository;
        this.lienFormulaireService = lienFormulaireService;
        this.cacheService = cacheService;
    }


    // méthode pour accéder au formulaire si l'accès à celui-ci est valide (verification du statut et du token du lien)
    @Override
    public ResponseEntity<String> afficherFormulaire(String token) {

        if (!lienFormulaireService.isTokenValid(token)) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le lien est expiré ou le formulaire a déjà été complété.");
        }

        return ResponseEntity.ok("Formulaire valide. Veuillez entrer votre numéro SIRET.");
    }



    // méthode permettant de créer l'objet formulaireDTO à l'aide des différentes entités qui le constitue
    @Override
    public FormulaireDTO validationFormulaire(String token) {

        UtilisateurDTO utilisateurDTO = utilisateurService.recupererUtilisateurConnecte();


        return null;
    }


}
