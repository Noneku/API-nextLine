package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.UtilisateurMapper;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.ServiceExt.EmailSenderService;
import fr.ln.nextLine.Service.ServiceExt.PasswordGeneratorService;
import fr.ln.nextLine.Service.ServiceExt.UUIDGeneratorService;
import fr.ln.nextLine.Service.UtilisateurService;
import fr.ln.nextLine.config.Security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static fr.ln.nextLine.config.Security.SecurityConfig.passwordEncoder;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UUIDGeneratorService uuidGeneratorService;
    private final PasswordGeneratorService passwordGeneratorService;
    private final EmailSenderService emailSenderService;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UUIDGeneratorService uuidGeneratorService, PasswordGeneratorService passwordGeneratorService, EmailSenderService emailSenderService) {
        this.utilisateurRepository = utilisateurRepository;
        this.uuidGeneratorService = uuidGeneratorService;
        this.passwordGeneratorService = passwordGeneratorService;
        this.emailSenderService = emailSenderService;
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
        String uniqueLogin = uuidGeneratorService.generateUUID();
        String uniquePassword = passwordGeneratorService.generatePassword(12);

        utilisateur.setIsactive(false);
        utilisateur.setUtilisateurLogin(uniqueLogin);
        utilisateur.setMdpUtilisateur(passwordEncoder().encode(uniquePassword));

        Utilisateur createdUtilisateur = utilisateurRepository.save(utilisateur);
        UtilisateurDTO createdUtilisateurDTO = UtilisateurMapper.toDTO(createdUtilisateur);

        emailSenderService.sendEmail(
                "leila.mouaci@gmail.com",
                "Identifiants de Connexion NextLine",
                "Bonjour Leila,\n\n" +
                        "Voici vos identifiants de connexion temporaires pour accéder à votre compte NextLine :\n\n" +
                        "🔹 **Login** : " + utilisateur.getUtilisateurLogin() + "\n\n" +
                        "🔹 **Mot de passe** : " + utilisateur.getMdpUtilisateur() + "\n\n" +
                        "Veuillez vous connecter dès que possible et modifier ces identifiants pour garantir la sécurité de votre compte.\n\n" +
                        "Si vous avez des questions ou rencontrez des problèmes, n'hésitez pas à contacter notre support.\n\n" +
                        "Cordialement,\n" +
                        "L'équipe NextLine"
        );


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

    // méthode pour récupérer l'utilisateur connecté et le transformer en objet UtilisateurDTO
    @Override
    public UtilisateurDTO recupererUtilisateurConnecte() {

        // Récupère les détails de l'utilisateur actuellement authentifié
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUserDetails) {

            Utilisateur utilisateur = ((CustomUserDetails) principal).getUtilisateur();

            return UtilisateurMapper.toDTO(utilisateur);

        } else {

            return null;
        }
    }

}

