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

    private final AssuranceRepository assuranceRepository;

    @Autowired
    public AssuranceService(AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }

    public List<Assurance> getAllAssurances() {
        return assuranceRepository.findAll();
    }

    public Assurance getAssuranceById(Integer id) {
        Optional<Assurance> assurance = assuranceRepository.findById(id);
        return assurance.orElse(null);
    }

    public Assurance createAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    public Assurance updateAssurance(Integer id, Assurance updatedAssurance) {
        return null;
    }

    public boolean deleteAssurance(Integer id) {
        Optional<Assurance> assuranceOptional = assuranceRepository.findById(id);
        if (assuranceOptional.isPresent()) {
            assuranceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
