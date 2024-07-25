package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Ville;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface VilleRepository extends JpaRepository<Ville, Integer> {
}
