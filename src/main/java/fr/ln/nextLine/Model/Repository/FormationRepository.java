package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
}
