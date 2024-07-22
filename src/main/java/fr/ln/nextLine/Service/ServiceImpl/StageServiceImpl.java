package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.StageDTO;
import fr.ln.nextLine.Model.Entity.Stage;
import fr.ln.nextLine.Model.Mapper.StageMapper;
import fr.ln.nextLine.Model.Repository.StageRepository;
import fr.ln.nextLine.Service.StageService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StageServiceImpl implements StageService {

    private final StageRepository stageRepository;

    public StageServiceImpl(StageRepository stageRepository) {

        this.stageRepository = stageRepository;
    }


    @Override
    public ResponseEntity<List<StageDTO>> getAll() {

        List<StageDTO> stageDTOS = stageRepository.findAll()
                .stream()
                .map(StageMapper::toDTO)
                .toList();

        if (stageDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(stageDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StageDTO> getById(Integer id) {

        Optional<Stage> stage = stageRepository.findById(id);

        return stage.map(
                        value -> new ResponseEntity<>(StageMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<StageDTO> create(StageDTO stageDTO) {

        Stage stage = StageMapper.toEntity(stageDTO);
        Stage createdStage = stageRepository.save(stage);
        StageDTO createdStageDTO = StageMapper.toDTO(createdStage);

        return new ResponseEntity<>(createdStageDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StageDTO> update(Integer id, StageDTO stageDTO) {

        if (stageRepository.existsById(id)) {

            Stage stage = StageMapper.toEntity(stageDTO);
            stage.setId(id);
            Stage updatedStage = stageRepository.save(stage);
            StageDTO updatedStageDTO = StageMapper.toDTO(updatedStage);

            return new ResponseEntity<>(updatedStageDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Stage> stageOptional = stageRepository.findById(id);

        if (stageOptional.isPresent()) {

            stageRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
