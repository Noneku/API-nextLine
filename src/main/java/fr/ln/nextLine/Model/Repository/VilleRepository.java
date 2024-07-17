package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository <Ville, Integer> {
}
