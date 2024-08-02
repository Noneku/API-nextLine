package fr.ln.nextLine.Service;

import com.fasterxml.jackson.databind.JsonNode;
import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EntrepriseService extends GeneriqueCrudService <EntrepriseDTO> {

    EntrepriseDTO checkEntreprise(String siret);
    EntrepriseDTO getEntreprise(String jsonData, String siret);
    ResponseEntity<EntrepriseDTO> getByNumeroSiret (String numeroSiret);

}
