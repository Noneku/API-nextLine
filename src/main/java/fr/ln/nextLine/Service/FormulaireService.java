package fr.ln.nextLine.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FormulaireService {

    ResponseEntity<String> afficherFormulaire(String token);
}
