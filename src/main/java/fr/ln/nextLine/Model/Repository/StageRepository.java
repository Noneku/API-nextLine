package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository <Stage, Integer> {
}
