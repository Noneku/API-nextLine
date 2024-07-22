package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.LieuRealisationDTO;
import fr.ln.nextLine.Model.Entity.LieuRealisation;
import fr.ln.nextLine.Model.Mapper.LieuRealisationMapper;
import fr.ln.nextLine.Model.Repository.LieuRealisationRepository;
import fr.ln.nextLine.Service.LieuRealisationService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LieuRealisationServiceImpl implements LieuRealisationService {

    private final LieuRealisationRepository lieuRealisationRepository;

    public LieuRealisationServiceImpl(LieuRealisationRepository lieuRealisationRepository) {

        this.lieuRealisationRepository = lieuRealisationRepository;
    }


    @Override
    public ResponseEntity<List<LieuRealisationDTO>> getAll() {

        List<LieuRealisationDTO> lieuRealisationDTOS = lieuRealisationRepository.findAll()
                .stream()
                .map(LieuRealisationMapper::toDTO)
                .toList();

        if (lieuRealisationDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lieuRealisationDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LieuRealisationDTO> getById(Integer id) {

        Optional<LieuRealisation> lieuRealisation = lieuRealisationRepository.findById(id);

        return lieuRealisation.map(
                        value -> new ResponseEntity<>(LieuRealisationMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<LieuRealisationDTO> create(LieuRealisationDTO lieuRealisationDTO) {

        LieuRealisation lieuRealisation = LieuRealisationMapper.toEntity(lieuRealisationDTO);
        LieuRealisation createdLieuRealisation = lieuRealisationRepository.save(lieuRealisation);
        LieuRealisationDTO createdLieuRealisationDTO = LieuRealisationMapper.toDTO(createdLieuRealisation);

        return new ResponseEntity<>(createdLieuRealisationDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LieuRealisationDTO> update(Integer id, LieuRealisationDTO lieuRealisationDTO) {

        if (lieuRealisationRepository.existsById(id)) {

            LieuRealisation lieuRealisation = LieuRealisationMapper.toEntity(lieuRealisationDTO);
            lieuRealisation.setId(id);
            LieuRealisation updatedLieuRealisation = lieuRealisationRepository.save(lieuRealisation);
            LieuRealisationDTO updatedLieuRealisationDTO = LieuRealisationMapper.toDTO(updatedLieuRealisation);

            return new ResponseEntity<>(updatedLieuRealisationDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<LieuRealisation> lieuRealisationOptional = lieuRealisationRepository.findById(id);

        if (lieuRealisationOptional.isPresent()) {

            lieuRealisationRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
