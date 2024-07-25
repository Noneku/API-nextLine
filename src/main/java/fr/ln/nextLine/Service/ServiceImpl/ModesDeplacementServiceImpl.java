package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.ModesDeplacementDTO;
import fr.ln.nextLine.Model.Entity.ModesDeplacement;
import fr.ln.nextLine.Model.Mapper.ModesDeplacementMapper;
import fr.ln.nextLine.Model.Repository.ModesDeplacementRepository;
import fr.ln.nextLine.Service.ModesDeplacementService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModesDeplacementServiceImpl implements ModesDeplacementService {

    private final ModesDeplacementRepository modesDeplacementRepository;

    public ModesDeplacementServiceImpl(ModesDeplacementRepository modesDeplacementRepository) {

        this.modesDeplacementRepository = modesDeplacementRepository;
    }


    @Override
    public ResponseEntity<List<ModesDeplacementDTO>> getAll() {

        List<ModesDeplacementDTO> modesDeplacementDTOS = modesDeplacementRepository.findAll()
                .stream()
                .map(ModesDeplacementMapper::toDTO)
                .toList();

        if (modesDeplacementDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(modesDeplacementDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModesDeplacementDTO> getById(Integer id) {

        Optional<ModesDeplacement> modesDeplacement = modesDeplacementRepository.findById(id);

        return modesDeplacement.map(
                        value -> new ResponseEntity<>(ModesDeplacementMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<ModesDeplacementDTO> create(ModesDeplacementDTO modesDeplacementDTO) {

        ModesDeplacement modesDeplacement = ModesDeplacementMapper.toEntity(modesDeplacementDTO);
        ModesDeplacement createdModesDeplacement = modesDeplacementRepository.save(modesDeplacement);
        ModesDeplacementDTO createdModesDeplacementDTO = ModesDeplacementMapper.toDTO(createdModesDeplacement);

        return new ResponseEntity<>(createdModesDeplacementDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ModesDeplacementDTO> update(Integer id, ModesDeplacementDTO modesDeplacementDTO) {

        if (modesDeplacementRepository.existsById(id)) {

            ModesDeplacement modesDeplacement = ModesDeplacementMapper.toEntity(modesDeplacementDTO);
            modesDeplacement.setId(id);
            ModesDeplacement updatedModesDeplacement = modesDeplacementRepository.save(modesDeplacement);
            ModesDeplacementDTO updatedModesDeplacementDTO = ModesDeplacementMapper.toDTO(updatedModesDeplacement);

            return new ResponseEntity<>(updatedModesDeplacementDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<ModesDeplacement> modesDeplacementOptional = modesDeplacementRepository.findById(id);

        if (modesDeplacementOptional.isPresent()) {

            modesDeplacementRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
