package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Tuteur;
import fr.ln.nextLine.Model.Repository.TuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TuteurService {

    private final TuteurRepository tuteurRepository;

    @Autowired
    public TuteurService(TuteurRepository tuteurRepository) {
        this.tuteurRepository = tuteurRepository;
    }

    public List<Tuteur> getAllTuteurs() {
        return tuteurRepository.findAll();
    }

    public Tuteur getTuteurById(Integer id) {
        Optional<Tuteur> tuteur = tuteurRepository.findById(id);
        return tuteur.orElse(null);
    }

    public Tuteur createTuteur(Tuteur tuteur) {
        return tuteurRepository.save(tuteur);
    }

    public Tuteur updateTuteur(Integer id, Tuteur updatedTuteur) {
        return null;
    }

    public boolean deleteTuteur(Integer id) {
        Optional<Tuteur> tuteurOptional = tuteurRepository.findById(id);
        if (tuteurOptional.isPresent()) {
            tuteurRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
