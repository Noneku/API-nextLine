package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository <Session, Integer> {
}
