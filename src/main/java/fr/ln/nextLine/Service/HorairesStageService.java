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

    private final HorairesStageRepository horairesStageRepository;

    @Autowired
    public HorairesStageService(HorairesStageRepository horairesStageRepository) {
        this.horairesStageRepository = horairesStageRepository;
    }

    public List<HorairesStage> getAllHorairesStages() {
        return horairesStageRepository.findAll();
    }

    public HorairesStage getHorairesStageById(Integer id) {
        Optional<HorairesStage> horairesStage = horairesStageRepository.findById(id);
        return horairesStage.orElse(null);
    }

    public HorairesStage createHorairesStage(HorairesStage horairesStage) {
        return horairesStageRepository.save(horairesStage);
    }

    public HorairesStage updateHorairesStage(Integer id, HorairesStage updatedHorairesStage) {
        return null;
    }

    public boolean deleteHorairesStage(Integer id) {
        Optional<HorairesStage> horairesStageOptional = horairesStageRepository.findById(id);
        if (horairesStageOptional.isPresent()) {
            horairesStageRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}