package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Ville;
import fr.ln.nextLine.Model.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VilleService {

    private final VilleRepository villeRepository;

    @Autowired
    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    public Ville getVilleById(Integer id) {
        Optional<Ville> ville = villeRepository.findById(id);
        return ville.orElse(null);
    }

    public Ville createVille(Ville ville) {
        return villeRepository.save(ville);
    }

    public Ville updateVille(Integer id, Ville updatedVille) {
        return null;
    }

    public boolean deleteVille(Integer id) {
        Optional<Ville> villeOptional = villeRepository.findById(id);
        if (villeOptional.isPresent()) {
            villeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
