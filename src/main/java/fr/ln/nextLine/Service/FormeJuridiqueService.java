package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Model.Repository.FormeJuridiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormeJuridiqueService {

    private final FormeJuridiqueRepository formeJuridiqueRepository;

    @Autowired
    public FormeJuridiqueService(FormeJuridiqueRepository formeJuridiqueRepository) {
        this.formeJuridiqueRepository = formeJuridiqueRepository;
    }

    public List<FormeJuridique> getAllFormeJuridiques() {
        return formeJuridiqueRepository.findAll();
    }

    public FormeJuridique getFormeJuridiqueById(Integer id) {
        Optional<FormeJuridique> formeJuridique = formeJuridiqueRepository.findById(id);
        return formeJuridique.orElse(null);
    }

    public FormeJuridique createFormeJuridique(FormeJuridique formeJuridique) {
        return formeJuridiqueRepository.save(formeJuridique);
    }

    public FormeJuridique updateFormeJuridique(Integer id, FormeJuridique updatedFormeJuridique) {
        return null;
    }

    public boolean deleteFormeJuridique(Integer id) {
        Optional<FormeJuridique> formeJuridiqueOptional = formeJuridiqueRepository.findById(id);
        if (formeJuridiqueOptional.isPresent()) {
            formeJuridiqueRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
