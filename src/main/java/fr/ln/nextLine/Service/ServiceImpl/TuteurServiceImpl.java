package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.TuteurDTO;
import fr.ln.nextLine.Model.Entity.Tuteur;
import fr.ln.nextLine.Model.Mapper.TuteurMapper;
import fr.ln.nextLine.Model.Repository.TuteurRepository;
import fr.ln.nextLine.Service.TuteurService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TuteurServiceImpl implements TuteurService {

    private final TuteurRepository tuteurRepository;

    public TuteurServiceImpl(TuteurRepository tuteurRepository) {

        this.tuteurRepository = tuteurRepository;
    }


    @Override
    public ResponseEntity<List<TuteurDTO>> getAll() {

        List<TuteurDTO> tuteurDTOS = tuteurRepository.findAll()
                .stream()
                .map(TuteurMapper::toDTO)
                .toList();

        if (tuteurDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tuteurDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TuteurDTO> getById(Integer id) {

        Optional<Tuteur> tuteur = tuteurRepository.findById(id);

        return tuteur.map(
                        value -> new ResponseEntity<>(TuteurMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<TuteurDTO> create(TuteurDTO tuteurDTO) {

        Tuteur tuteur = TuteurMapper.toEntity(tuteurDTO);
        Tuteur createdTuteur = tuteurRepository.save(tuteur);
        TuteurDTO createdTuteurDTO = TuteurMapper.toDTO(createdTuteur);

        return new ResponseEntity<>(createdTuteurDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TuteurDTO> update(Integer id, TuteurDTO tuteurDTO) {

        if (tuteurRepository.existsById(id)) {

            Tuteur tuteur = TuteurMapper.toEntity(tuteurDTO);
            tuteur.setId(id);
            Tuteur updatedTuteur = tuteurRepository.save(tuteur);
            TuteurDTO updatedTuteurDTO = TuteurMapper.toDTO(updatedTuteur);

            return new ResponseEntity<>(updatedTuteurDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Tuteur> tuteurOptional = tuteurRepository.findById(id);

        if (tuteurOptional.isPresent()) {

            tuteurRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
