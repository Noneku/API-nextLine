package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EntrepriseService extends GeneriqueCrudService <EntrepriseDTO> {

    EntrepriseDTO checkEntreprise(String token, String siret);
    EntrepriseDTO getEntreprise(String token, String jsonData, String siret);
    ResponseEntity<EntrepriseDTO> getByNumeroSiret (String numeroSiret);

}
