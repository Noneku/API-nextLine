package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.LienFormulaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LienFormulaireRepository extends JpaRepository <LienFormulaire, Integer> {

    Optional<LienFormulaire> findByTokenLien(String tokenLien);
}
