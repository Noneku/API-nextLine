package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    Optional<Entreprise> findByNumeroSiret(String numeroSiret);
}
