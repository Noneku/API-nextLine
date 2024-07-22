package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Service.ActiviteService;
import jakarta.transaction.Transactional;
import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Mapper.ActiviteMapper;
import fr.ln.nextLine.Model.Repository.ActiviteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActiviteServiceImpl implements ActiviteService {
    
    private final ActiviteRepository activiteRepository;

    public ActiviteServiceImpl(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    @Override
    public ResponseEntity<List<ActiviteDTO>> getAll() {

        List<ActiviteDTO> ActiviteDTOs = activiteRepository.findAll()
                .stream()
                .map(ActiviteMapper::toDTO)
                .toList();

        if (ActiviteDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(ActiviteDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActiviteDTO> getById(Integer id) {
        Optional<Activite> activite = activiteRepository.findById(id);

        return activite.map(
                        value -> new ResponseEntity<>(ActiviteMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Override
    public ResponseEntity<ActiviteDTO> update(Integer id, ActiviteDTO entity) {

        Optional<Activite> Activite = activiteRepository.findById(id);

        return Activite.map(
                        value -> new ResponseEntity<>(ActiviteMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<ActiviteDTO> create(ActiviteDTO ActiviteDTO) {

        Activite Activite = ActiviteMapper.toEntity(ActiviteDTO);
        Activite createdActivite = activiteRepository.save(Activite);
        ActiviteDTO createdActiviteDTO = ActiviteMapper.toDTO(createdActivite);

        return new ResponseEntity<>(createdActiviteDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Activite> ActiviteOptional = activiteRepository.findById(id);

        if (ActiviteOptional.isPresent()) {

            activiteRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
