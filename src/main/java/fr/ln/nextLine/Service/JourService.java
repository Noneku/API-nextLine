package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Jour;
import fr.ln.nextLine.Model.Repository.JourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JourService {

    private final JourRepository JourRepository;

    @Autowired
    public JourService(JourRepository JourRepository) {
        this.JourRepository = JourRepository;
    }

    public List<Jour> getAllJours() {
        return JourRepository.findAll();
    }

    public Jour getJourById(Integer id) {
        Optional<Jour> Jour = JourRepository.findById(id);
        return Jour.orElse(null);
    }

    public Jour createJour(Jour Jour) {
        return JourRepository.save(Jour);
    }

    public Jour updateJour(Integer id, Jour updatedJour) {
        return null;
    }

    public boolean deleteJour(Integer id) {
        Optional<Jour> JourOptional = JourRepository.findById(id);
        if (JourOptional.isPresent()) {
            JourRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
