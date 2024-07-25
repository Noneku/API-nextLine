package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.HorairesStageDTO;
import fr.ln.nextLine.Model.Entity.HorairesStage;
import fr.ln.nextLine.Model.Mapper.HorairesStageMapper;
import fr.ln.nextLine.Model.Repository.HorairesStageRepository;
import fr.ln.nextLine.Service.HorairesStageService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HorairesStageServiceImpl implements HorairesStageService {

    private final HorairesStageRepository horairesStageRepository;

    public HorairesStageServiceImpl(HorairesStageRepository horairesStageRepository) {

        this.horairesStageRepository = horairesStageRepository;
    }

    @Override
    public ResponseEntity<List<HorairesStageDTO>> getAll() {

        List<HorairesStageDTO> horairesStageDTOs = horairesStageRepository.findAll()
                .stream()
                .map(HorairesStageMapper::toDTO)
                .toList();

        if (horairesStageDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(horairesStageDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HorairesStageDTO> getById(Integer id) {

        Optional<HorairesStage> horairesStage = horairesStageRepository.findById(id);

        return horairesStage.map(
                        value -> new ResponseEntity<>(HorairesStageMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<HorairesStageDTO> create(HorairesStageDTO horairesStageDTO) {

        HorairesStage horairesStage = HorairesStageMapper.toEntity(horairesStageDTO);
        HorairesStage createdHorairesStage = horairesStageRepository.save(horairesStage);
        HorairesStageDTO createdHorairesStageDTO = HorairesStageMapper.toDTO(createdHorairesStage);

        return new ResponseEntity<>(createdHorairesStageDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HorairesStageDTO> update(Integer id, HorairesStageDTO horairesStageDTO) {

        if (horairesStageRepository.existsById(id)) {

            HorairesStage horairesStage = HorairesStageMapper.toEntity(horairesStageDTO);
            horairesStage.setId(id);
            HorairesStage updatedHorairesStage = horairesStageRepository.save(horairesStage);
            HorairesStageDTO updatedHorairesStageDTO = HorairesStageMapper.toDTO(updatedHorairesStage);

            return new ResponseEntity<>(updatedHorairesStageDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<HorairesStage> horairesStageOptional = horairesStageRepository.findById(id);

        if (horairesStageOptional.isPresent()) {

            horairesStageRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
