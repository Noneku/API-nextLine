package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;

public interface UtilisateurService extends GeneriqueCrudService <UtilisateurDTO> {

    UtilisateurDTO recupererUtilisateurConnecte();

}
