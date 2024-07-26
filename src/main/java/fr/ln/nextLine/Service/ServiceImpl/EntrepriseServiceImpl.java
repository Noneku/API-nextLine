package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;
import fr.ln.nextLine.Model.Mapper.EntrepriseMapper;
import fr.ln.nextLine.Model.Repository.EntrepriseRepository;
import fr.ln.nextLine.Service.EntrepriseService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {

        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public ResponseEntity<List<EntrepriseDTO>> getAll() {

        List<EntrepriseDTO> entrepriseDTOs = entrepriseRepository.findAll()
                .stream()
                .map(EntrepriseMapper::toDTO)
                .toList();

        if (entrepriseDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(entrepriseDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntrepriseDTO> getById(Integer id) {

        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return entreprise.map(
                        value -> new ResponseEntity<>(EntrepriseMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<EntrepriseDTO> create(EntrepriseDTO entrepriseDTO) {

        Entreprise entreprise = EntrepriseMapper.toEntity(entrepriseDTO);
        Entreprise createdEntreprise = entrepriseRepository.save(entreprise);
        EntrepriseDTO createdEntrepriseDTO = EntrepriseMapper.toDTO(createdEntreprise);

        return new ResponseEntity<>(createdEntrepriseDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EntrepriseDTO> update(Integer id, EntrepriseDTO entrepriseDTO) {

        if (entrepriseRepository.existsById(id)) {

            Entreprise entreprise = EntrepriseMapper.toEntity(entrepriseDTO);
            entreprise.setId(id);
            Entreprise updatedEntreprise = entrepriseRepository.save(entreprise);
            EntrepriseDTO updatedEntrepriseDTO = EntrepriseMapper.toDTO(updatedEntreprise);

            return new ResponseEntity<>(updatedEntrepriseDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Entreprise> entrepriseOptional = entrepriseRepository.findById(id);

        if (entrepriseOptional.isPresent()) {

            entrepriseRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    public boolean isEntrepriseRepertoriee(String siret) {

        return true;
    }
}
