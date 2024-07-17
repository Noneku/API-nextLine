package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Model.Repository.LienFormulaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LienFormulaireService {

    private final LienFormulaireRepository lienFormulaireRepository;

    @Autowired
    public LienFormulaireService(LienFormulaireRepository lienFormulaireRepository) {
        this.lienFormulaireRepository = lienFormulaireRepository;
    }

    public List<LienFormulaire> getAllLiensFormulaires() {
        return lienFormulaireRepository.findAll();
    }

    public LienFormulaire getLienFormulaireById(Integer id) {
        Optional<LienFormulaire> lienFormulaire = lienFormulaireRepository.findById(id);
        return lienFormulaire.orElse(null);
    }

    public LienFormulaire createLienFormulaire(LienFormulaire lienFormulaire) {
        return lienFormulaireRepository.save(lienFormulaire);
    }

    public LienFormulaire updateLienFormulaire(Integer id, LienFormulaire updatedLienFormulaire) {
        return null;
    }

    public boolean deleteLienFormulaire(Integer id) {
        Optional<LienFormulaire> lienFormulaireOptional = lienFormulaireRepository.findById(id);
        if (lienFormulaireOptional.isPresent()) {
            lienFormulaireRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
