package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.UtilisateurMapper;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static fr.ln.nextLine.config.Security.SecurityConfig.passwordEncoder;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public ResponseEntity<List<UtilisateurDTO>> getAll() {

        List<UtilisateurDTO> utilisateurDTOS = utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurMapper::toDTO)
                .toList();

        if (utilisateurDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(utilisateurDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UtilisateurDTO> getById(Integer id) {

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        return utilisateur.map(
                        value -> new ResponseEntity<>(UtilisateurMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<UtilisateurDTO> create(UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = UtilisateurMapper.toEntity(utilisateurDTO);
        String passwordNoEncoded = utilisateur.getMdpUtilisateur();

        utilisateur.setMdpUtilisateur(
                passwordEncoder().encode(passwordNoEncoded)
        );

        Utilisateur createdUtilisateur = utilisateurRepository.save(utilisateur);
        UtilisateurDTO createdUtilisateurDTO = UtilisateurMapper.toDTO(createdUtilisateur);

        return new ResponseEntity<>(createdUtilisateurDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UtilisateurDTO> update(Integer id, UtilisateurDTO utilisateurDTO) {

        if (utilisateurRepository.existsById(id)) {

            Utilisateur existingUtilisateur = utilisateurRepository.findById(id).orElseThrow();

            Utilisateur updatedUtilisateur = utilisateurRepository.save(existingUtilisateur);

            UtilisateurDTO updatedUtilisateurDTO = UtilisateurMapper.toDTO(updatedUtilisateur);

            return new ResponseEntity<>(updatedUtilisateurDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

        if (utilisateurOptional.isPresent()) {

            utilisateurRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

