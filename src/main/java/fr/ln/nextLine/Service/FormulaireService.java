package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Dto.FormulaireDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FormulaireService {

    ResponseEntity<String> afficherFormulaire(String token);
    FormulaireDTO validationFormulaire(String token);
}
