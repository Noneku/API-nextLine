package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {
}
