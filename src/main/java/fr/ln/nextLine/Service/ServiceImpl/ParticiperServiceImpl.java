package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.ParticiperDTO;
import fr.ln.nextLine.Model.Entity.Participer;
import fr.ln.nextLine.Model.Entity.ParticiperId;
import fr.ln.nextLine.Model.Entity.Session;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.ParticiperMapper;
import fr.ln.nextLine.Model.Repository.ParticiperRepository;
import fr.ln.nextLine.Model.Repository.SessionRepository;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.ParticiperService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParticiperServiceImpl implements ParticiperService {

    private final ParticiperRepository participerRepository;
    private final SessionRepository sessionRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ParticiperServiceImpl(
            ParticiperRepository participerRepository,
            SessionRepository sessionRepository,
            UtilisateurRepository utilisateurRepository) {

        this.participerRepository = participerRepository;
        this.sessionRepository = sessionRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public ResponseEntity<List<ParticiperDTO>> getAll() {

        List<ParticiperDTO> participerDTOS = participerRepository.findAll()
                .stream()
                .map(ParticiperMapper::toDTO)
                .toList();

        if (participerDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(participerDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ParticiperDTO> getById(Integer id) {

        Optional<Participer> participer = participerRepository.findById(id);

        return participer.map(
                        value -> new ResponseEntity<>(ParticiperMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<ParticiperDTO> create(ParticiperDTO participerDTO) {

        Participer participer = ParticiperMapper.toEntity(participerDTO);
        Participer createdParticiper = participerRepository.save(participer);
        ParticiperDTO createdParticiperDTO = ParticiperMapper.toDTO(createdParticiper);

        return new ResponseEntity<>(createdParticiperDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ParticiperDTO> update(Integer id, ParticiperDTO participerDTO) {

        if (participerRepository.existsById(id)) {

            Participer participer = ParticiperMapper.toEntity(participerDTO);
            Participer updatedParticiper = participerRepository.save(participer);
            ParticiperDTO updatedParticiperDTO = ParticiperMapper.toDTO(updatedParticiper);

            return new ResponseEntity<>(updatedParticiperDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Participer> participerOptional = participerRepository.findById(id);

        if (participerOptional.isPresent()) {

            participerRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public void ajouterUtilisateurAUneSession(Integer sessionId, Integer utilisateurId) {

        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        ParticiperId participerId = new ParticiperId();
        participerId.setIdSession(session.getId());
        participerId.setIdUtilisateur(utilisateur.getId());

        Participer participer = new Participer();
        participer.setId(participerId);
        participer.setSession(session);
        participer.setUtilisateur(utilisateur);

        participerRepository.save(participer);
    }
}

