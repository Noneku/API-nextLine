package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.DirigeantDTO;
import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Model.Mapper.DirigeantMapper;
import fr.ln.nextLine.Model.Mapper.FonctionMapper;
import fr.ln.nextLine.Model.Repository.DirigeantRepository;
import fr.ln.nextLine.Model.Repository.FonctionRepository;
import fr.ln.nextLine.Service.DirigeantService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DirigeantServiceImpl implements DirigeantService {

    DirigeantRepository dirigeantRepository;
    FonctionRepository fonctionRepository;

    public DirigeantServiceImpl(
            DirigeantRepository dirigeantRepository,
            FonctionRepository fonctionRepository) {

        this.dirigeantRepository = dirigeantRepository;
        this.fonctionRepository = fonctionRepository;
    }

    @Override
    public ResponseEntity<List<DirigeantDTO>> getAll() {
        {

            List<DirigeantDTO> dirigeantDTOs = dirigeantRepository.findAll()
                    .stream()
                    .map(DirigeantMapper::toDTO)
                    .toList();

            if (dirigeantDTOs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dirigeantDTOs, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<DirigeantDTO> getById(Integer id) {
        {

            Optional<Dirigeant> dirigeant = dirigeantRepository.findById(id);

            return dirigeant.map(
                            value -> new ResponseEntity<>(DirigeantMapper.toDTO(value), HttpStatus.FOUND))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity<DirigeantDTO> create(DirigeantDTO dirigeantDTO) {
        {
            // Définition de la fonction du nouveau dirigeant en tant que directeur car déjà en bdd
            Fonction fonction = fonctionRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Fonction non trouvée"));

            Dirigeant dirigeant = DirigeantMapper.toEntity(dirigeantDTO);
            dirigeant.setFonction(fonction);
            Dirigeant createddirigeant = dirigeantRepository.save(dirigeant);
            DirigeantDTO createdVDirigeantDTO = DirigeantMapper.toDTO(createddirigeant);

            return new ResponseEntity<>(createdVDirigeantDTO, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<DirigeantDTO> update(Integer id, DirigeantDTO dirigeantDTO) {
        if (dirigeantRepository.existsById(id)) {

            Dirigeant dirigeant = DirigeantMapper.toEntity(dirigeantDTO);
            dirigeant.setId(id);
            Dirigeant updatedDirigeant = dirigeantRepository.save(dirigeant);
            DirigeantDTO updatedDirigeantDTO = DirigeantMapper.toDTO(updatedDirigeant);

            return new ResponseEntity<>(updatedDirigeantDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        {

            Optional<Dirigeant> dirigeantOptional = dirigeantRepository.findById(id);

            if (dirigeantOptional.isPresent()) {

                dirigeantRepository.deleteById(id);

                return new ResponseEntity<>(HttpStatus.OK);

            } else {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }
}
