package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuteurRepository extends JpaRepository <Tuteur, Integer> {
}
