package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteRepository extends JpaRepository<Activite, Integer> {
}
