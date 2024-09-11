package fr.ln.nextLine.Service.ServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ln.nextLine.Model.Dto.*;
import fr.ln.nextLine.Model.Entity.*;
import fr.ln.nextLine.Model.Mapper.*;
import fr.ln.nextLine.Model.Repository.*;
import fr.ln.nextLine.Service.ServiceExt.ApiSirenService;
import fr.ln.nextLine.Service.EntrepriseService;
import fr.ln.nextLine.Service.ServiceExt.CacheService;
import fr.ln.nextLine.Service.VilleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;
    private final ApiSirenService apiSirenService;
    private final VilleService villeService;
    private final FormeJuridiqueRepository formeJuridiqueRepository;
    private final DirigeantRepository dirigeantRepository;
    private final AssuranceRepository assuranceRepository;
    private final VilleRepository villeRepository;
    private final ObjectMapper objectMapper;
    private final CacheService cacheService;


    // Constantes pour attribuer des valeurs par défaut temporaires
    private static final String DEFAULT_TELEPHONE = "0320887766";
    private static final String DEFAULT_EMAIL = "entreprise@mail.com";
    private static final int DEFAULT_FORME_JURIDIQUE_ID = 3;
    private static final int DEFAULT_DIRIGEANT_ID = 1;
    private static final int DEFAULT_ASSURANCE_ID = 1;

    public EntrepriseServiceImpl(
            EntrepriseRepository entrepriseRepository,
            ApiSirenService apiSirenService,
            ObjectMapper objectMapper,
            FormeJuridiqueRepository formeJuridiqueRepository,
            DirigeantRepository dirigeantRepository,
            AssuranceRepository assuranceRepository,
            VilleRepository villeRepository,
            VilleService villeService, VilleRepository villeRepository1,
            CacheService cacheService) {

        this.entrepriseRepository = entrepriseRepository;
        this.apiSirenService = apiSirenService;
        this.objectMapper = objectMapper;
        this.villeService = villeService;
        this.formeJuridiqueRepository = formeJuridiqueRepository;
        this.dirigeantRepository = dirigeantRepository;
        this.assuranceRepository = assuranceRepository;
        this.villeRepository = villeRepository1;
        this.cacheService = cacheService;
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
                        value -> new ResponseEntity<>(EntrepriseMapper.toDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<EntrepriseDTO> getByNumeroSiret(String numeroSiret) {

        Optional<Entreprise> entreprise = entrepriseRepository.findByNumeroSiret(numeroSiret);

        return entreprise.map(
                        value -> new ResponseEntity<>(EntrepriseMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<EntrepriseDTO> create(EntrepriseDTO entrepriseDTO) {

        // Vérifier si l'entreprise existe déjà
        if (entrepriseRepository.findByNumeroSiret(entrepriseDTO.getNumeroSiret()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        // Vérifiez si les entités associées ont des IDs valides
        if (entrepriseDTO.getVilleDTO() == null || entrepriseDTO.getVilleDTO().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (entrepriseDTO.getFormeJuridiqueDTO() == null || entrepriseDTO.getFormeJuridiqueDTO().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (entrepriseDTO.getDirigeantDTO() == null || entrepriseDTO.getDirigeantDTO().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (entrepriseDTO.getAssuranceDTO() == null || entrepriseDTO.getAssuranceDTO().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Convertir DTO en entité
        Entreprise entreprise = EntrepriseMapper.toEntity(entrepriseDTO);

        // Sauvegarder l'entité
        Entreprise createdEntreprise = entrepriseRepository.save(entreprise);
        EntrepriseDTO createdEntrepriseDTO = EntrepriseMapper.toDTO(createdEntreprise);

        System.out.println("Création entreprise ok !!");

        return new ResponseEntity<>(createdEntrepriseDTO, HttpStatus.OK);
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


    // méthode permettant de faire un appel au service apiSirenService pour interroger l'api et recupérer les informations de l'entreprise à partir du numéro siret saisi
    public EntrepriseDTO checkEntreprise(String token, String siret) {

        // vérification si l'entreprise saisie existe déjà en bdd, si oui, retourne l'objet entreprise correspondant depuis la bdd
        if (entrepriseRepository.findByNumeroSiret(siret).isPresent()) {

            Entreprise entreprise = entrepriseRepository.findByNumeroSiret(siret).get();

            return EntrepriseMapper.toDTO(entreprise);

        } else {



            // si non présente en bdd, création de l'objet entrepriseDTO à partir du retour des informations de l'api siren
            String jsonData = apiSirenService.verifierEntreprise(siret);
            return getEntreprise(token, jsonData, siret);
        }
    }


    // méthode qui récupère les données depuis l'api siren à partir du numero siret de l'entreprise saisi pour créer un objet entrepriseDTO
    // cet objet entrepriseDTO est mis en cache afin de pouvoir être récupéré ultérieurement à la validation du formulaire
    // la clé de récupération de l'objet entrepriseDTO situé en cache est le token du lien ayant permis d'accéder au formulaire et à la saisie du numéro SIRET
    @Override
    public EntrepriseDTO getEntreprise(String token, String jsonData, String siret) {
        try {
            JsonNode root = objectMapper.readTree(jsonData);

            EntrepriseDTO entrepriseDTO = new EntrepriseDTO();

            VilleDTO villeDTO = extractVilleDTO(root);

            VilleDTO createdVilleDTO = villeService.findOrCreateVille(
                    villeDTO.getCodePostal(),
                    villeDTO.getCodeInsee(),
                    villeDTO.getNomVille()
            );

            entrepriseDTO.setNumeroSiret(siret);
            entrepriseDTO.setRaisonSociale(getJsonText(root, "etablissement", "unite_legale", "denomination"));
            entrepriseDTO.setAdresseEntreprise(formatAddress(root));
            entrepriseDTO.setTelephoneEntreprise(DEFAULT_TELEPHONE);
            entrepriseDTO.setEmailEntreprise(DEFAULT_EMAIL);
            entrepriseDTO.setVilleDTO(createdVilleDTO);

            entrepriseDTO.setFormeJuridiqueDTO(getDefaultFormeJuridiqueDTO());
            entrepriseDTO.setDirigeantDTO(getDefaultDirigeantDTO());
            entrepriseDTO.setAssuranceDTO(getDefaultAssuranceDTO());

            System.out.println("Token: " + token);
            System.out.println("Objet EntrepriseDTO : " + entrepriseDTO.getRaisonSociale());

            // mise en cache de l'objet retourné en utilisant le cacheService
            cacheService.cacheEntrepriseDTO(token, entrepriseDTO);

            return entrepriseDTO;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    // méthode pour extraire les données de la ville à partir du retour JSON de l'api
    // et hydrater l'objet VilleDTO à partir des données récupérées
    private VilleDTO extractVilleDTO(JsonNode root) {
        VilleDTO villeDTO = new VilleDTO();
        villeDTO.setNomVille(getJsonText(root, "etablissement", "libelle_commune"));
        villeDTO.setCodePostal(getJsonText(root, "etablissement", "code_postal"));
        villeDTO.setCodeInsee(getJsonText(root, "etablissement", "code_commune"));

        return villeDTO;
    }

    // méthode pour factoriser les chemins de la structure JSON
    private String getJsonText(JsonNode root, String... fields) {
        JsonNode node = root;
        for (String field : fields) {
            node = node.path(field);
        }
        return node.asText();
    }

    // méthode pour factoriser le chemin pour accéder à l'adresse depuis la structure JSON
    private String formatAddress(JsonNode root) {
        return String.format("%s %s %s",
                getJsonText(root, "etablissement", "numero_voie"),
                getJsonText(root, "etablissement", "type_voie"),
                getJsonText(root, "etablissement", "libelle_voie")
        ).trim();
    }

    // méthodes pour attribuer des valeurs par défaut aux tables étrangères dans l'attente de récupérer les données saisies par l'entreprise depuis un formulaire
    private FormeJuridiqueDTO getDefaultFormeJuridiqueDTO() {
        FormeJuridique defaultFormeJuridique = formeJuridiqueRepository.getById(DEFAULT_FORME_JURIDIQUE_ID);
        return FormeJuridiqueMapper.toDTO(defaultFormeJuridique);
    }

    private DirigeantDTO getDefaultDirigeantDTO() {
        Dirigeant defaultDirigeant = dirigeantRepository.getById(DEFAULT_DIRIGEANT_ID);
        return DirigeantMapper.toDTO(defaultDirigeant);
    }

    private AssuranceDTO getDefaultAssuranceDTO() {
        Assurance defaultAssurance = assuranceRepository.getById(DEFAULT_ASSURANCE_ID);
        return AssuranceMapper.toDTO(defaultAssurance);
    }
}
