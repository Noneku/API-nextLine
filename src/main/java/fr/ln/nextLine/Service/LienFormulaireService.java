package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LienFormulaireService extends GeneriqueCrudService <LienFormulaireDTO> {

    public ResponseEntity<String> generateAndSendLink (Integer id_utilisateur);

}
