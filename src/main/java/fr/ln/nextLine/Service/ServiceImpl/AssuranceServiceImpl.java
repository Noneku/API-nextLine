package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Mapper.AssuranceMapper;
import fr.ln.nextLine.Model.Repository.AssuranceRepository;
import fr.ln.nextLine.Service.AssuranceService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;

    public AssuranceServiceImpl(AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }


    @Override
    public ResponseEntity<List<AssuranceDTO>> getAll() {
        List<AssuranceDTO> assuranceDTOs = assuranceRepository.findAll()
                .stream()
                .map(AssuranceMapper::toDTO)
                .toList();

        if (assuranceDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(assuranceDTOs, HttpStatus.OK);
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
        Assurance createdassurance = assuranceRepository.save(assurance);
        AssuranceDTO createdVassuranceDTO = AssuranceMapper.toDTO(createdassurance);

        return new ResponseEntity<>(createdVassuranceDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AssuranceDTO> update(Integer id, AssuranceDTO assuranceDTO) {
        if (assuranceRepository.existsById(id)) {

            Assurance assurance = AssuranceMapper.toEntity(assuranceDTO);
            assurance.setId(id);
            Assurance updatedassurance = assuranceRepository.save(assurance);
            AssuranceDTO updatedassuranceDTO = AssuranceMapper.toDTO(updatedassurance);

            return new ResponseEntity<>(updatedassuranceDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        Optional<Assurance> assuranceOptional = assuranceRepository.findById(id);

        if (assuranceOptional.isPresent()) {

            assuranceRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    // methode pour rechercher ou créer une assurance
    public AssuranceDTO findOrCreateAssurance(String nomAssurance, String numeroSocietaire) {

        Optional<Assurance> optionalAssurance = assuranceRepository.findByNomAssurance(nomAssurance);

        Assurance assurance;

        // si l'assurance est présente en bdd, récupération des informations de l'assurance
        if (optionalAssurance.isPresent()) {

            assurance = optionalAssurance.get();

            // si l'assurance n'est pas présente en bdd, persistance d'un nouvel objet assurance en bdd
        } else {

            assurance = new Assurance();
            assurance.setNomAssurance(nomAssurance);
            assurance.setNumeroSocietaire(numeroSocietaire);

            assurance = assuranceRepository.save(assurance);
        }

        // retour de l'assurance selon les données fournies en paramètres
        return AssuranceMapper.toDTO(assurance);
    }
}
