package fr.ln.nextLine.Service;

import com.fasterxml.jackson.databind.JsonNode;
import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;
import org.springframework.stereotype.Service;

@Service
public interface EntrepriseService extends GeneriqueCrudService <EntrepriseDTO> {

    public EntrepriseDTO verifierEntreprise(String siret);
    public Entreprise saveEntreprise(EntrepriseDTO entrepriseDTO);
    public EntrepriseDTO recupererEntreprise(String jsonData, String siret);

}
