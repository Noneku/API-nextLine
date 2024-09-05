package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.LienFormulaireMapper;
import fr.ln.nextLine.Model.Repository.LienFormulaireRepository;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.ServiceExt.EmailSenderService;
import fr.ln.nextLine.Service.LienFormulaireService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class LienFormulaireServiceImpl implements LienFormulaireService {

    private final LienFormulaireRepository lienFormulaireRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final EmailSenderService emailSenderService;

    public LienFormulaireServiceImpl(
            LienFormulaireRepository lienFormulaireRepository,
            UtilisateurRepository utilisateurRepository,
            EmailSenderService emailSenderService) {

        this.lienFormulaireRepository = lienFormulaireRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.emailSenderService = emailSenderService;
    }


    @Override
    public ResponseEntity<List<LienFormulaireDTO>> getAll() {

        List<LienFormulaireDTO> lienFormulaireDTOs = lienFormulaireRepository.findAll()
                .stream()
                .map(LienFormulaireMapper::toDTO)
                .toList();

        if (lienFormulaireDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lienFormulaireDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LienFormulaireDTO> getById(Integer id) {

        Optional<LienFormulaire> lienFormulaire = lienFormulaireRepository.findById(id);

        return lienFormulaire.map(
                        value -> new ResponseEntity<>(LienFormulaireMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<LienFormulaireDTO> create(LienFormulaireDTO lienFormulaireDTO) {

        LienFormulaire lienFormulaire = LienFormulaireMapper.toEntity(lienFormulaireDTO);
        LienFormulaire createdLienFormulaire = lienFormulaireRepository.save(lienFormulaire);
        LienFormulaireDTO createdVLienFormulaireDTO = LienFormulaireMapper.toDTO(createdLienFormulaire);

        return new ResponseEntity<>(createdVLienFormulaireDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LienFormulaireDTO> update(Integer id, LienFormulaireDTO lienFormulaireDTO) {

        if (lienFormulaireRepository.existsById(id)) {

            LienFormulaire lienFormulaire = LienFormulaireMapper.toEntity(lienFormulaireDTO);
            lienFormulaire.setId(id);
            LienFormulaire updatedLienFormulaire = lienFormulaireRepository.save(lienFormulaire);
            LienFormulaireDTO updatedLienFormulaireDTO = LienFormulaireMapper.toDTO(updatedLienFormulaire);

            return new ResponseEntity<>(updatedLienFormulaireDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<LienFormulaire> lienFormulaireOptional = lienFormulaireRepository.findById(id);

        if (lienFormulaireOptional.isPresent()) {

            lienFormulaireRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // méthode permettant de générer et envoyer un lien à une entreprise pour remplir un formulaire
    public ResponseEntity<String> generateAndSendLink(Integer idUtilisateur, String emailEntreprise) {

        // a corriger ensuite une fois les sessions et la connexion effectuée
        Utilisateur utilisateur = getUtilisateurById(idUtilisateur);

        String token = generateToken();

        LienFormulaire lienFormulaire = createLienFormulaire(token, utilisateur);
        lienFormulaireRepository.save(lienFormulaire);

        String emailContent = createEmailContent(token);
        emailSenderService.sendEmail(emailEntreprise, "Complétez le formulaire", emailContent);

        return ResponseEntity.ok("Le lien a bien été envoyé");
    }

    // méthode pour récupérer l'utilisateur à partir de son id
    private Utilisateur getUtilisateurById(Integer idUtilisateur) {
        return utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new RuntimeException("Pas d'utilisateur trouvé avec l'id " + idUtilisateur));
    }

    // méthode pour générer un token
    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    // méthode pour enregistrer le lien selon les paramètres attribués
    private LienFormulaire createLienFormulaire(String token, Utilisateur utilisateur) {

        LienFormulaire lienFormulaire = new LienFormulaire();

        lienFormulaire.setTokenLien(token);
        lienFormulaire.setDateGeneration(LocalDate.now());
        lienFormulaire.setStatut(false);
        lienFormulaire.setUtilisateur(utilisateur);

        return lienFormulaire;
    }

    // méthode pour paramétrer le contenu du mail envoyé
    private String createEmailContent(String token) {

        return "Veuillez compléter le formulaire à l'adresse suivante :  http://localhost:4200/formulaire-siret?token=" + token;
    }


    // méthode qui vérifie la validité du token : si le lien est en statut "true" (formulaire complété) ou que le token a été généré il y a moins de
    // 24h alors le token n'est plus valide
    public boolean isTokenValid(String token) {
        return lienFormulaireRepository.findLienByTokenLien(token)
                .map(lienFormulaire -> {
                    LocalDateTime dateGeneration = lienFormulaire.getDateGeneration()
                            .atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
                    LocalDateTime now = LocalDateTime.now();
                    return !dateGeneration.plusHours(1).isBefore(now) && !lienFormulaire.getStatut();
                })
                .orElse(false);
    }
}

