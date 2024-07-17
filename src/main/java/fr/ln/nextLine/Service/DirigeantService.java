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

    private final DirigeantRepository dirigeantRepository;

    @Autowired
    public DirigeantService(DirigeantRepository dirigeantRepository) {
        this.dirigeantRepository = dirigeantRepository;
    }

    public List<Dirigeant> getAllDirigeants() {
        return dirigeantRepository.findAll();
    }

    public Dirigeant getDirigeantById(Integer id) {
        Optional<Dirigeant> dirigeant = dirigeantRepository.findById(id);
        return dirigeant.orElse(null);
    }

    public Dirigeant createDirigeant(Dirigeant dirigeant) {
        return dirigeantRepository.save(dirigeant);
    }

    public Dirigeant updateDirigeant(Integer id, Dirigeant updatedDirigeant) {
         Dirigeant existingDirigeant = dirigeantRepository.getReferenceById(updatedDirigeant.getId());

        existingDirigeant.setEmailDirigeant(updatedDirigeant.getEmailDirigeant());
        existingDirigeant.setNomDirigeant(updatedDirigeant.getNomDirigeant());
        existingDirigeant.setPrenomDirigeant(updatedDirigeant.getPrenomDirigeant());

        return dirigeantRepository.save(updatedDirigeant);
    }

    public boolean deleteDirigeant(Integer id) {
        Optional<Dirigeant> dirigeantOptional = dirigeantRepository.findById(id);
        if (dirigeantOptional.isPresent()) {
            dirigeantRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
