package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Participer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticiperRepository extends JpaRepository <Participer, Integer> {
}