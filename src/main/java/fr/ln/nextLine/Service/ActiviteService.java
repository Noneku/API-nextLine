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

    private final ActiviteRepository ActiviteRepository;

    @Autowired
    public ActiviteService(ActiviteRepository ActiviteRepository) {
        this.ActiviteRepository = ActiviteRepository;
    }

    public List<Activite> getAllActivites() {
        return ActiviteRepository.findAll();
    }

    public Activite getActiviteById(Integer id) {
        Optional<Activite> Activite = ActiviteRepository.findById(id);
        return Activite.orElse(null);
    }

    public Activite createActivite(Activite Activite) {
        return ActiviteRepository.save(Activite);
    }

    public Activite updateActivite(Integer id, Activite updatedActivite) {
        return null;
    }

    public boolean deleteActivite(Integer id) {
        Optional<Activite> ActiviteOptional = ActiviteRepository.findById(id);
        if (ActiviteOptional.isPresent()) {
            ActiviteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
