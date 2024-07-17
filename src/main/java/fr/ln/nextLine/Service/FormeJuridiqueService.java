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

    private final FormeJuridiqueRepository FormeJuridiqueRepository;

    @Autowired
    public FormeJuridiqueService(FormeJuridiqueRepository FormeJuridiqueRepository) {
        this.FormeJuridiqueRepository = FormeJuridiqueRepository;
    }

    public List<FormeJuridique> getAllFormeJuridiques() {
        return FormeJuridiqueRepository.findAll();
    }

    public FormeJuridique getFormeJuridiqueById(Integer id) {
        Optional<FormeJuridique> FormeJuridique = FormeJuridiqueRepository.findById(id);
        return FormeJuridique.orElse(null);
    }

    public FormeJuridique createFormeJuridique(FormeJuridique FormeJuridique) {
        return FormeJuridiqueRepository.save(FormeJuridique);
    }

    public FormeJuridique updateFormeJuridique(Integer id, FormeJuridique updatedFormeJuridique) {
        return null;
    }

    public boolean deleteFormeJuridique(Integer id) {
        Optional<FormeJuridique> FormeJuridiqueOptional = FormeJuridiqueRepository.findById(id);
        if (FormeJuridiqueOptional.isPresent()) {
            FormeJuridiqueRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
