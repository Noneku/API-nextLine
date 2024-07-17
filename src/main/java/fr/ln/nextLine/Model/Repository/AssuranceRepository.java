package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {
}
