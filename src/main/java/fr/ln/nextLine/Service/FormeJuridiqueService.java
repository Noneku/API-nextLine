package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.FormeJuridiqueDTO;
import org.springframework.stereotype.Service;

@Service
public interface FormeJuridiqueService extends GeneriqueCrudService <FormeJuridiqueDTO> {

    FormeJuridiqueDTO findOrCreateFormeJuridique(String nom_forme_juridique);

}
