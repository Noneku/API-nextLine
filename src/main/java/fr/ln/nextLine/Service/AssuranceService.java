package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssuranceService {

    private final AssuranceRepository AssuranceRepository;

    @Autowired
    public AssuranceService(AssuranceRepository AssuranceRepository) {
        this.AssuranceRepository = AssuranceRepository;
    }

    public List<Assurance> getAllAssurances() {
        return AssuranceRepository.findAll();
    }

    public Assurance getAssuranceById(Integer id) {
        Optional<Assurance> Assurance = AssuranceRepository.findById(id);
        return Assurance.orElse(null);
    }

    public Assurance createAssurance(Assurance Assurance) {
        return AssuranceRepository.save(Assurance);
    }

    public Assurance updateAssurance(Integer id, Assurance updatedAssurance) {
        return null;
    }

    public boolean deleteAssurance(Integer id) {
        Optional<Assurance> AssuranceOptional = AssuranceRepository.findById(id);
        if (AssuranceOptional.isPresent()) {
            AssuranceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
