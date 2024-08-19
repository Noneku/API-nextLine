package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Entity.FormeJuridique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {

    Optional<Assurance> findByNomAssurance(String nomAssurance);
}
