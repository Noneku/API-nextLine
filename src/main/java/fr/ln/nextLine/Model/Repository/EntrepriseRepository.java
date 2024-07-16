package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
