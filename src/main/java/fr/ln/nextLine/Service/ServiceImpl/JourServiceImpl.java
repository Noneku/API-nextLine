package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.JourDTO;
import fr.ln.nextLine.Model.Entity.Jour;
import fr.ln.nextLine.Model.Mapper.JourMapper;
import fr.ln.nextLine.Model.Repository.JourRepository;
import fr.ln.nextLine.Service.JourService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JourServiceImpl implements JourService {

    private final JourRepository jourRepository;

    public JourServiceImpl(JourRepository jourRepository) {

        this.jourRepository = jourRepository;
    }

    @Override
    public ResponseEntity<List<JourDTO>> getAll() {

        List<JourDTO> jourDTOs = jourRepository.findAll()
                .stream()
                .map(JourMapper::toDTO)
                .toList();

        if (jourDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(jourDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JourDTO> getById(Integer id) {

        Optional<Jour> jour = jourRepository.findById(id);

        return jour.map(
                        value -> new ResponseEntity<>(JourMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<JourDTO> create(JourDTO jourDTO) {

        Jour jour = JourMapper.toEntity(jourDTO);
        Jour createdJour = jourRepository.save(jour);
        JourDTO createdJourDTO = JourMapper.toDTO(createdJour);

        return new ResponseEntity<>(createdJourDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<JourDTO> update(Integer id, JourDTO jourDTO) {

        if (jourRepository.existsById(id)) {

            Jour jour = JourMapper.toEntity(jourDTO);
            jour.setId(id);
            Jour updatedJour = jourRepository.save(jour);
            JourDTO updatedJourDTO = JourMapper.toDTO(updatedJour);

            return new ResponseEntity<>(updatedJourDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Jour> jourOptional = jourRepository.findById(id);

        if (jourOptional.isPresent()) {

            jourRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
