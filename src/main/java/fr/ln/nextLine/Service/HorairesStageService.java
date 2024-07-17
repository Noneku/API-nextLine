package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.HorairesStage;
import fr.ln.nextLine.Model.Repository.HorairesStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HorairesStageService {

    private final HorairesStageRepository HorairesStageRepository;

    @Autowired
    public HorairesStageService(HorairesStageRepository HorairesStageRepository) {
        this.HorairesStageRepository = HorairesStageRepository;
    }

    public List<HorairesStage> getAllHorairesStages() {
        return HorairesStageRepository.findAll();
    }

    public HorairesStage getHorairesStageById(Integer id) {
        Optional<HorairesStage> HorairesStage = HorairesStageRepository.findById(id);
        return HorairesStage.orElse(null);
    }

    public HorairesStage createHorairesStage(HorairesStage HorairesStage) {
        return HorairesStageRepository.save(HorairesStage);
    }

    public HorairesStage updateHorairesStage(Integer id, HorairesStage updatedHorairesStage) {
        return null;
    }

    public boolean deleteHorairesStage(Integer id) {
        Optional<HorairesStage> HorairesStageOptional = HorairesStageRepository.findById(id);
        if (HorairesStageOptional.isPresent()) {
            HorairesStageRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}