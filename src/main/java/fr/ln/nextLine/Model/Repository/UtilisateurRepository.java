package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {

    Optional<Utilisateur> findByutilisateurLogin(String utilisateurLogin);
}
