package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Model.Repository.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FonctionService {

    private final FonctionRepository fonctionRepository;

    @Autowired
    public FonctionService(FonctionRepository fonctionRepository) {
        this.fonctionRepository = fonctionRepository;
    }

    public List<Fonction> getAllFonctions() {
        return fonctionRepository.findAll();
    }

    public Fonction getFonctionById(Integer id) {
        Optional<Fonction> fonction = fonctionRepository.findById(id);
        return fonction.orElse(null);
    }

    public Fonction createFonction(Fonction fonction) {
        return fonctionRepository.save(fonction);
    }

    public Fonction updateFonction(Integer id, Fonction updatedFonction) {
        return null;
    }

    public boolean deleteFonction(Integer id) {
        Optional<Fonction> fonctionOptional = fonctionRepository.findById(id);
        if (fonctionOptional.isPresent()) {
            fonctionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
