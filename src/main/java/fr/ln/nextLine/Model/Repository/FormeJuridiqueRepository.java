package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Model.Entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormeJuridiqueRepository extends JpaRepository<FormeJuridique, Integer> {

    Optional<FormeJuridique> findByNomFormeJuridique(String nom_forme_juridique);
}
