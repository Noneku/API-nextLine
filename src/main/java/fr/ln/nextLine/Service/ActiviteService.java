package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActiviteService {

    private final ActiviteRepository activiteRepository;

    @Autowired
    public ActiviteService(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public List<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }

    public Activite getActiviteById(Integer id) {
        Optional<Activite> activite = activiteRepository.findById(id);
        return activite.orElse(null);
    }

    public Activite createActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    public Activite updateActivite(Integer id, Activite updatedActivite) {
        return null;
    }

    public boolean deleteActivite(Integer id) {
        Optional<Activite> activiteOptional = activiteRepository.findById(id);
        if (activiteOptional.isPresent()) {
            activiteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
