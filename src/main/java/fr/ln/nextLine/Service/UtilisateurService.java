package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import org.springframework.stereotype.Service;


@Service
public interface UtilisateurService extends GeneriqueCrudService <UtilisateurDTO> {

    UtilisateurDTO recupererUtilisateurConnecte();

}
