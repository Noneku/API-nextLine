package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.ModesDeplacement;
import fr.ln.nextLine.Model.Repository.ModesDeplacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModesDeplacementService {

    private final ModesDeplacementRepository modesDeplacementRepository;

    @Autowired
    public ModesDeplacementService(ModesDeplacementRepository modesDeplacementRepository) {
        this.modesDeplacementRepository = modesDeplacementRepository;
    }

    public List<ModesDeplacement> getAllModesDeplacements() {
        return modesDeplacementRepository.findAll();
    }

    public ModesDeplacement getModeDeplacementById(Integer id) {
        Optional<ModesDeplacement> modesDeplacement = modesDeplacementRepository.findById(id);
        return modesDeplacement.orElse(null);
    }

    public ModesDeplacement createModeDeplacement(ModesDeplacement modesDeplacement) {
        return modesDeplacementRepository.save(modesDeplacement);
    }

    public ModesDeplacement updateModeDeplacement(Integer id, ModesDeplacement updatedModeDeplacement) {
        return null;
    }

    public boolean deleteModeDeplacement(Integer id) {
        Optional<ModesDeplacement> modesDeplacementOptional = modesDeplacementRepository.findById(id);
        if (modesDeplacementOptional.isPresent()) {
            modesDeplacementRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
