package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Entity.Ville;
import fr.ln.nextLine.Model.Mapper.AssuranceMapper;
import fr.ln.nextLine.Model.Mapper.VilleMapper;
import fr.ln.nextLine.Model.Repository.AssuranceRepository;
import fr.ln.nextLine.Service.AssuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class AssuranceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;

    public AssuranceImpl(AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }

    @Override
    public ResponseEntity<List<AssuranceDTO>> getAll() {

        List<AssuranceDTO> assurancesDTOs = assuranceRepository.findAll()
                .stream()
                .map(AssuranceMapper::toDTO)
                .toList();

        if (assurancesDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(assurancesDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AssuranceDTO> getById(Integer id) {
        Optional<Assurance> assurance = assuranceRepository.findById(id);

        return assurance.map(
                        value -> new ResponseEntity<>(AssuranceMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<AssuranceDTO> create(AssuranceDTO assuranceDTO) {

        Assurance assurance = AssuranceMapper.toEntity(assuranceDTO);
        Assurance createdAssurance = assuranceRepository.save(assurance);
        AssuranceDTO createdAssuranceDTO = AssuranceMapper.toDTO(createdAssurance);

        return new ResponseEntity<>(assuranceDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AssuranceDTO> update(Integer id, AssuranceDTO assuranceDTO) {
        if (assuranceRepository.existsById(id)) {

            Assurance assurance = AssuranceMapper.toEntity(assuranceDTO);
            assurance.setId(id);
            Assurance updatedAssurance = assuranceRepository.save(assurance);
            AssuranceDTO updatedAssuranceDTO = AssuranceMapper.toDTO(updatedAssurance);

            return new ResponseEntity<>(updatedAssuranceDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return null;
    }
}
