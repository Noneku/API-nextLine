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

    private final FrequenceRepository FrequenceRepository;

    @Autowired
    public FrequenceService(FrequenceRepository FrequenceRepository) {
        this.FrequenceRepository = FrequenceRepository;
    }

    public List<Frequence> getAllFrequences() {
        return FrequenceRepository.findAll();
    }

    public Frequence getFrequenceById(Integer id) {
        Optional<Frequence> Frequence = FrequenceRepository.findById(id);
        return Frequence.orElse(null);
    }

    public Frequence createFrequence(Frequence Frequence) {
        return FrequenceRepository.save(Frequence);
    }

    public Frequence updateFrequence(Integer id, Frequence updatedFrequence) {
        return null;
    }

    public boolean deleteFrequence(Integer id) {
        Optional<Frequence> FrequenceOptional = FrequenceRepository.findById(id);
        if (FrequenceOptional.isPresent()) {
            FrequenceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
