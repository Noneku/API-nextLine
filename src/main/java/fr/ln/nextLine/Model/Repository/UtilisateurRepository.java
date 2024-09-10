package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {

    @Transactional
    Optional<Utilisateur> findByutilisateurLogin(String utilisateurLogin);
    boolean existsByEmailUtilisateur(String emailUtilisateur);
}
