package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Dirigeant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirigeantRepository extends JpaRepository<Dirigeant, Integer> {
}