package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.FrequenceDTO;
import fr.ln.nextLine.Model.Entity.Frequence;
import fr.ln.nextLine.Model.Mapper.FrequenceMapper;
import fr.ln.nextLine.Model.Repository.FrequenceRepository;
import fr.ln.nextLine.Service.FrequenceService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FrequenceServiceImpl implements FrequenceService {

    private final FrequenceRepository frequenceRepository;

    public FrequenceServiceImpl(FrequenceRepository frequenceRepository) {

        this.frequenceRepository = frequenceRepository;
    }

    @Override
    public ResponseEntity<List<FrequenceDTO>> getAll() {

        List<FrequenceDTO> frequenceDTOs = frequenceRepository.findAll()
                .stream()
                .map(FrequenceMapper::toDTO)
                .toList();

        if (frequenceDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(frequenceDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FrequenceDTO> getById(Integer id) {

        Optional<Frequence> frequence = frequenceRepository.findById(id);

        return frequence.map(
                        value -> new ResponseEntity<>(FrequenceMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<FrequenceDTO> create(FrequenceDTO frequenceDTO) {

        Frequence frequence = FrequenceMapper.toEntity(frequenceDTO);
        Frequence createdFrequence = frequenceRepository.save(frequence);
        FrequenceDTO createdFrequenceDTO = FrequenceMapper.toDTO(createdFrequence);

        return new ResponseEntity<>(createdFrequenceDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FrequenceDTO> update(Integer id, FrequenceDTO frequenceDTO) {

        if (frequenceRepository.existsById(id)) {

            Frequence frequence = FrequenceMapper.toEntity(frequenceDTO);
            frequence.setId(id);
            Frequence updatedFrequence = frequenceRepository.save(frequence);
            FrequenceDTO updatedFrequenceDTO = FrequenceMapper.toDTO(updatedFrequence);

            return new ResponseEntity<>(updatedFrequenceDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Frequence> frequenceOptional = frequenceRepository.findById(id);

        if (frequenceOptional.isPresent()) {

            frequenceRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
