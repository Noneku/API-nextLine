package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.FormeJuridiqueDTO;
import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Model.Mapper.FormeJuridiqueMapper;
import fr.ln.nextLine.Model.Repository.FormeJuridiqueRepository;
import fr.ln.nextLine.Service.FormeJuridiqueService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormeJuridiqueServiceImpl implements FormeJuridiqueService {

    private final FormeJuridiqueRepository formeJuridiqueRepository;

    public FormeJuridiqueServiceImpl(FormeJuridiqueRepository formeJuridiqueRepository) {

        this.formeJuridiqueRepository = formeJuridiqueRepository;
    }

    @Override
    public ResponseEntity<List<FormeJuridiqueDTO>> getAll() {

        List<FormeJuridiqueDTO> formeJuridiqueDTOs = formeJuridiqueRepository.findAll()
                .stream()
                .map(FormeJuridiqueMapper::toDTO)
                .toList();

        if (formeJuridiqueDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(formeJuridiqueDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FormeJuridiqueDTO> getById(Integer id) {

        Optional<FormeJuridique> formeJuridique = formeJuridiqueRepository.findById(id);

        return formeJuridique.map(
                        value -> new ResponseEntity<>(FormeJuridiqueMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<FormeJuridiqueDTO> create(FormeJuridiqueDTO formeJuridiqueDTO) {

        FormeJuridique formeJuridique = FormeJuridiqueMapper.toEntity(formeJuridiqueDTO);
        FormeJuridique createdFormeJuridique = formeJuridiqueRepository.save(formeJuridique);
        FormeJuridiqueDTO createdFormeJuridiqueDTO = FormeJuridiqueMapper.toDTO(createdFormeJuridique);

        return new ResponseEntity<>(createdFormeJuridiqueDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FormeJuridiqueDTO> update(Integer id, FormeJuridiqueDTO formeJuridiqueDTO) {

        if (formeJuridiqueRepository.existsById(id)) {

            FormeJuridique formeJuridique = FormeJuridiqueMapper.toEntity(formeJuridiqueDTO);
            formeJuridique.setId(id);
            FormeJuridique updatedFormeJuridique = formeJuridiqueRepository.save(formeJuridique);
            FormeJuridiqueDTO updatedFormeJuridiqueDTO = FormeJuridiqueMapper.toDTO(updatedFormeJuridique);

            return new ResponseEntity<>(updatedFormeJuridiqueDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<FormeJuridique> formeJuridiqueOptional = formeJuridiqueRepository.findById(id);

        if (formeJuridiqueOptional.isPresent()) {

            formeJuridiqueRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
