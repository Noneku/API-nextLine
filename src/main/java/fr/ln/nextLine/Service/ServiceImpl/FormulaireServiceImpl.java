package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Model.Repository.LienFormulaireRepository;
import fr.ln.nextLine.Service.FormulaireService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Transactional
public class FormulaireServiceImpl implements FormulaireService {

    @Autowired
    private LienFormulaireRepository lienFormulaireRepository;


    @Override
    public ResponseEntity<String> afficherFormulaire(String token) {
        Optional<LienFormulaire> optionalLienFormulaire = lienFormulaireRepository.findByTokenLien(token);

        if (!optionalLienFormulaire.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token invalide ou expiré.");
        }

        if (!isTokenValid(token)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le token est expiré ou le formulaire a déjà été complété.");
        }

        return ResponseEntity.ok("Formulaire valide. Veuillez compléter les informations.");
    }

    @Override
    public boolean isTokenValid(String token) {
        Optional<LienFormulaire> optionalLienFormulaire = lienFormulaireRepository.findByTokenLien(token);
        if (!optionalLienFormulaire.isPresent()) {
            return false;
        }

        LienFormulaire lienFormulaire = optionalLienFormulaire.get();
        LocalDateTime dateGeneration = lienFormulaire.getDateGeneration().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
        return !dateGeneration.plusHours(24).isBefore(now) && !lienFormulaire.getStatut();
    }
}
