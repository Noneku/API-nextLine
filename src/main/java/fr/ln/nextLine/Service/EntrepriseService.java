package fr.ln.nextLine.Service;

import com.fasterxml.jackson.databind.JsonNode;
import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EntrepriseService extends GeneriqueCrudService <EntrepriseDTO> {

    EntrepriseDTO verifierEntreprise(String siret);
    ResponseEntity<EntrepriseDTO> saveEntreprise(EntrepriseDTO entrepriseDTO);
    EntrepriseDTO recupererEntreprise(String jsonData, String siret);

}
