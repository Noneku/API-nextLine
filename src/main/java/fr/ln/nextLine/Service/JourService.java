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

    private final JourRepository jourRepository;

    @Autowired
    public JourService(JourRepository jourRepository) {
        this.jourRepository = jourRepository;
    }

    public List<Jour> getAllJours() {
        return jourRepository.findAll();
    }

    public Jour getJourById(Integer id) {
        Optional<Jour> jour = jourRepository.findById(id);
        return jour.orElse(null);
    }

    public Jour createJour(Jour jour) {
        return jourRepository.save(jour);
    }

    public Jour updateJour(Integer id, Jour updatedJour) {
        return null;
    }

    public boolean deleteJour(Integer id) {
        Optional<Jour> jourOptional = jourRepository.findById(id);
        if (jourOptional.isPresent()) {
            jourRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
