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

    private final FonctionRepository FonctionRepository;

    @Autowired
    public FonctionService(FonctionRepository FonctionRepository) {
        this.FonctionRepository = FonctionRepository;
    }

    public List<Fonction> getAllFonctions() {
        return FonctionRepository.findAll();
    }

    public Fonction getFonctionById(Integer id) {
        Optional<Fonction> Fonction = FonctionRepository.findById(id);
        return Fonction.orElse(null);
    }

    public Fonction createFonction(Fonction Fonction) {
        return FonctionRepository.save(Fonction);
    }

    public Fonction updateFonction(Integer id, Fonction updatedFonction) {
        return null;
    }

    public boolean deleteFonction(Integer id) {
        Optional<Fonction> FonctionOptional = FonctionRepository.findById(id);
        if (FonctionOptional.isPresent()) {
            FonctionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
