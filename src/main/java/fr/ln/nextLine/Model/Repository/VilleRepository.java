package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Model.Entity.Ville;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface VilleRepository extends JpaRepository<Ville, Integer> {

    Optional<Ville> findByCodePostalAndCodeInsee(String codePostal, String codeInsee);
}
