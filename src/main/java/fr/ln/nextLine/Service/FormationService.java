package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Formation;
import fr.ln.nextLine.Model.Repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormationService {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    public Formation getFormationById(Integer id) {
        Optional<Formation> formation = formationRepository.findById(id);
        return formation.orElse(null);
    }

    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public Formation updateFormation(Integer id, Formation updatedFormation) {
        return null;
    }

    public boolean deleteFormation(Integer id) {
        Optional<Formation> formationOptional = formationRepository.findById(id);
        if (formationOptional.isPresent()) {
            formationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
