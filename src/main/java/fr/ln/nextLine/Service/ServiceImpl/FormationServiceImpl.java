package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.FormationDTO;
import fr.ln.nextLine.Model.Entity.Formation;
import fr.ln.nextLine.Model.Mapper.FormationMapper;
import fr.ln.nextLine.Model.Repository.FormationRepository;
import fr.ln.nextLine.Service.FormationService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    public FormationServiceImpl(FormationRepository formationRepository) {

        this.formationRepository = formationRepository;
    }

    @Override
    public ResponseEntity<List<FormationDTO>> getAll() {

        List<FormationDTO> formationDTOs = formationRepository.findAll()
                .stream()
                .map(FormationMapper::toDTO)
                .toList();

        if (formationDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(formationDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FormationDTO> getById(Integer id) {

        Optional<Formation> formation = formationRepository.findById(id);

        return formation.map(
                        value -> new ResponseEntity<>(FormationMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<FormationDTO> create(FormationDTO formationDTO) {

        Formation formation = FormationMapper.toEntity(formationDTO);
        Formation createdFormation = formationRepository.save(formation);
        FormationDTO createdFormationDTO = FormationMapper.toDTO(createdFormation);

        return new ResponseEntity<>(createdFormationDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FormationDTO> update(Integer id, FormationDTO formationDTO) {

        if (formationRepository.existsById(id)) {

            Formation formation = FormationMapper.toEntity(formationDTO);
            formation.setId(id);
            Formation updatedFormation = formationRepository.save(formation);
            FormationDTO updatedFormationDTO = FormationMapper.toDTO(updatedFormation);

            return new ResponseEntity<>(updatedFormationDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Formation> formationOptional = formationRepository.findById(id);

        if (formationOptional.isPresent()) {

            formationRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
