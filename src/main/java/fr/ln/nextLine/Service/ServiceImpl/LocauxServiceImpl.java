package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.LocauxDTO;
import fr.ln.nextLine.Model.Entity.Locaux;
import fr.ln.nextLine.Model.Mapper.LocauxMapper;
import fr.ln.nextLine.Model.Repository.LocauxRepository;
import fr.ln.nextLine.Service.LocauxService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocauxServiceImpl implements LocauxService {

    private final LocauxRepository locauxRepository;

    public LocauxServiceImpl(LocauxRepository locauxRepository) {

        this.locauxRepository = locauxRepository;
    }


    @Override
    public ResponseEntity<List<LocauxDTO>> getAll() {

        List<LocauxDTO> locauxDTOS = locauxRepository.findAll()
                .stream()
                .map(LocauxMapper::toDTO)
                .toList();

        if (locauxDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(locauxDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LocauxDTO> getById(Integer id) {

        Optional<Locaux> locaux = locauxRepository.findById(id);

        return locaux.map(
                        value -> new ResponseEntity<>(LocauxMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<LocauxDTO> create(LocauxDTO locauxDTO) {

        Locaux locaux = LocauxMapper.toEntity(locauxDTO);
        Locaux createdLocaux = locauxRepository.save(locaux);
        LocauxDTO createdLocauxDTO = LocauxMapper.toDTO(createdLocaux);

        return new ResponseEntity<>(createdLocauxDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LocauxDTO> update(Integer id, LocauxDTO locauxDTO) {

        if (locauxRepository.existsById(id)) {

            Locaux locaux = LocauxMapper.toEntity(locauxDTO);
            locaux.setId(id);
            Locaux updatedLocaux = locauxRepository.save(locaux);
            LocauxDTO updatedLocauxDTO = LocauxMapper.toDTO(updatedLocaux);

            return new ResponseEntity<>(updatedLocauxDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Locaux> locauxOptional = locauxRepository.findById(id);

        if (locauxOptional.isPresent()) {

            locauxRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
