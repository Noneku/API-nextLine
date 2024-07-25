package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Model.Mapper.FonctionMapper;
import fr.ln.nextLine.Model.Repository.FonctionRepository;
import fr.ln.nextLine.Service.FonctionService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FonctionServiceImpl implements FonctionService {

    private final FonctionRepository fonctionRepository;

    public FonctionServiceImpl(FonctionRepository fonctionRepository) {

        this.fonctionRepository = fonctionRepository;
    }

    @Override
    public ResponseEntity<List<FonctionDTO>> getAll() {

        List<FonctionDTO> fonctionDTOs = fonctionRepository.findAll()
                .stream()
                .map(FonctionMapper::toDTO)
                .toList();

        if (fonctionDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fonctionDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FonctionDTO> getById(Integer id) {

        Optional<Fonction> fonction = fonctionRepository.findById(id);

        return fonction.map(
                        value -> new ResponseEntity<>(FonctionMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<FonctionDTO> create(FonctionDTO fonctionDTO) {

        Fonction fonction = FonctionMapper.toEntity(fonctionDTO);
        Fonction createdFonction = fonctionRepository.save(fonction);
        FonctionDTO createdFonctionDTO = FonctionMapper.toDTO(createdFonction);

        return new ResponseEntity<>(createdFonctionDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FonctionDTO> update(Integer id, FonctionDTO fonctionDTO) {

        if (fonctionRepository.existsById(id)) {

            Fonction fonction = FonctionMapper.toEntity(fonctionDTO);
            fonction.setId(id);
            Fonction updatedFonction = fonctionRepository.save(fonction);
            FonctionDTO updatedFonctionDTO = FonctionMapper.toDTO(updatedFonction);

            return new ResponseEntity<>(updatedFonctionDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Fonction> fonctionOptional = fonctionRepository.findById(id);

        if (fonctionOptional.isPresent()) {

            fonctionRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
