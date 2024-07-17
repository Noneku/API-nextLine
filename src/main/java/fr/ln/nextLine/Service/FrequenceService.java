package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Frequence;
import fr.ln.nextLine.Model.Repository.FrequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FrequenceService {

    private final FrequenceRepository frequenceRepository;

    @Autowired
    public FrequenceService(FrequenceRepository frequenceRepository) {
        this.frequenceRepository = frequenceRepository;
    }

    public List<Frequence> getAllFrequences() {
        return frequenceRepository.findAll();
    }

    public Frequence getFrequenceById(Integer id) {
        Optional<Frequence> frequence = frequenceRepository.findById(id);
        return frequence.orElse(null);
    }

    public Frequence createFrequence(Frequence frequence) {
        return frequenceRepository.save(frequence);
    }

    public Frequence updateFrequence(Integer id, Frequence updatedFrequence) {
        return null;
    }

    public boolean deleteFrequence(Integer id) {
        Optional<Frequence> frequenceOptional = frequenceRepository.findById(id);
        if (frequenceOptional.isPresent()) {
            frequenceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
