package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.SessionDTO;
import fr.ln.nextLine.Model.Entity.Session;
import fr.ln.nextLine.Model.Mapper.SessionMapper;
import fr.ln.nextLine.Model.Repository.SessionRepository;
import fr.ln.nextLine.Service.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {

        this.sessionRepository = sessionRepository;
    }


    @Override
    public ResponseEntity<List<SessionDTO>> getAll() {

        List<SessionDTO> sessionDTOS = sessionRepository.findAll()
                .stream()
                .map(SessionMapper::toDTO)
                .toList();

        if (sessionDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(sessionDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SessionDTO> getById(Integer id) {

        Optional<Session> session = sessionRepository.findById(id);

        return session.map(
                        value -> new ResponseEntity<>(SessionMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<SessionDTO> create(SessionDTO sessionDTO) {

        Session session = SessionMapper.toEntity(sessionDTO);
        Session createdSession = sessionRepository.save(session);
        SessionDTO createdSessionDTO = SessionMapper.toDTO(createdSession);

        return new ResponseEntity<>(createdSessionDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SessionDTO> update(Integer id, SessionDTO sessionDTO) {

        if (sessionRepository.existsById(id)) {

            Session session = SessionMapper.toEntity(sessionDTO);
            session.setId(id);
            Session updatedSession = sessionRepository.save(session);
            SessionDTO updatedSessionDTO = SessionMapper.toDTO(updatedSession);

            return new ResponseEntity<>(updatedSessionDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Session> sessionOptional = sessionRepository.findById(id);

        if (sessionOptional.isPresent()) {

            sessionRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public Integer calculNombreSemaines(LocalDate dateDebutStage, LocalDate dateFinStage) {

        // vérification que les dates saisies ne sont pas nulles
        if (dateDebutStage == null || dateFinStage == null) {
            throw new IllegalArgumentException("Les dates de début et de fin de stage ne peuvent pas être nulles");
        }

        // Vérification que la date de début est avant la date de fin
        if (dateDebutStage.isAfter(dateFinStage)) {
            throw new IllegalArgumentException("La date de début de stage doit être antérieure à la date de fin de stage");
        }

        // Calcul du nombre de jours entre les deux dates
        int nombreJours = (int) ChronoUnit.DAYS.between(dateDebutStage, dateFinStage);

        // Conversion des jours en semaines
        int nombreSemaines = (int) (nombreJours / 7);

        // Si le nombre restant ne permet pas de constituer une semaine complète, ajoute une semaine tout de même
        if (nombreJours % 7 != 0) {

            nombreSemaines++;
        }

        return nombreSemaines;
    }
}
