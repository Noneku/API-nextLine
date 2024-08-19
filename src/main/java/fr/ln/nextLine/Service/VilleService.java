package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface VilleService extends GeneriqueCrudService<VilleDTO> {

    ResponseEntity<VilleDTO> findByCodePostalAndCodeInsee(String codePostal, String codeInsee);
    VilleDTO findOrCreateVille(String codePostal, String codeInsee, String nomVille);

}
