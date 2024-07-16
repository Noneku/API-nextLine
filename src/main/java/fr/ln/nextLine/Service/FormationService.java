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

    private final FormationRepository FormationRepository;

    @Autowired
    public FormationService(FormationRepository FormationRepository) {
        this.FormationRepository = FormationRepository;
    }

    public List<Formation> getAllFormations() {
        return FormationRepository.findAll();
    }

    public Formation getFormationById(Integer id) {
        Optional<Formation> Formation = FormationRepository.findById(id);
        return Formation.orElse(null);
    }

    public Formation createFormation(Formation Formation) {
        return FormationRepository.save(Formation);
    }

    public Formation updateFormation(Integer id, Formation updatedFormation) {
        return null;
    }

    public boolean deleteFormation(Integer id) {
        Optional<Formation> FormationOptional = FormationRepository.findById(id);
        if (FormationOptional.isPresent()) {
            FormationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
