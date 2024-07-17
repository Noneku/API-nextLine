package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Stage;
import fr.ln.nextLine.Model.Repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StageService {

    private final StageRepository stageRepository;

    @Autowired
    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    public Stage getStageById(Integer id) {
        Optional<Stage> stage = stageRepository.findById(id);
        return stage.orElse(null);
    }

    public Stage createStage(Stage stage) {
        return stageRepository.save(stage);
    }

    public Stage updateStage(Integer id, Stage updatedStage) {
        return null;
    }

    public boolean deleteStage(Integer id) {
        Optional<Stage> stageOptional = stageRepository.findById(id);
        if (stageOptional.isPresent()) {
            stageRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
