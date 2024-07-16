package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Model.Repository.DirigeantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DirigeantService {

    private final DirigeantRepository DirigeantRepository;

    @Autowired
    public DirigeantService(DirigeantRepository DirigeantRepository) {
        this.DirigeantRepository = DirigeantRepository;
    }

    public List<Dirigeant> getAllDirigeants() {
        return DirigeantRepository.findAll();
    }

    public Dirigeant getDirigeantById(Integer id) {
        Optional<Dirigeant> Dirigeant = DirigeantRepository.findById(id);
        return Dirigeant.orElse(null);
    }

    public Dirigeant createDirigeant(Dirigeant Dirigeant) {
        return DirigeantRepository.save(Dirigeant);
    }

    public Dirigeant updateDirigeant(Integer id, Dirigeant updatedDirigeant) {
        return null;
    }

    public boolean deleteDirigeant(Integer id) {
        Optional<Dirigeant> DirigeantOptional = DirigeantRepository.findById(id);
        if (DirigeantOptional.isPresent()) {
            DirigeantRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
