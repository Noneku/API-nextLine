package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.UtilisateurMapper;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.UtilisateurService;
import fr.ln.nextLine.config.Security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

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
        Utilisateur createdUtilisateur = utilisateurRepository.save(utilisateur);
        UtilisateurDTO createdUtilisateurDTO = UtilisateurMapper.toDTO(createdUtilisateur);

        return new ResponseEntity<>(createdUtilisateurDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UtilisateurDTO> update(Integer id, UtilisateurDTO utilisateurDTO) {

        if (utilisateurRepository.existsById(id)) {

            Utilisateur utilisateur = UtilisateurMapper.toEntity(utilisateurDTO);
            utilisateur.setId(id);
            Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateurFoundByLogin = utilisateurRepository.findByutilisateurLogin(login);

        if (utilisateurFoundByLogin.isPresent()) {
            return new CustomUserDetails(utilisateurFoundByLogin.get());
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}
