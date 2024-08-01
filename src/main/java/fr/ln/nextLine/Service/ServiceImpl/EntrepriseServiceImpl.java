package fr.ln.nextLine.Service.ServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ln.nextLine.Model.Dto.*;
import fr.ln.nextLine.Model.Entity.*;
import fr.ln.nextLine.Model.Mapper.*;
import fr.ln.nextLine.Model.Repository.*;
import fr.ln.nextLine.Service.ApiSirenService;
import fr.ln.nextLine.Service.EntrepriseService;
import fr.ln.nextLine.Service.VilleService;
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
    private final ApiSirenService apiSirenService;
    private final VilleService villeService;
    private final FormeJuridiqueRepository formeJuridiqueRepository;
    private final DirigeantRepository dirigeantRepository;
    private final AssuranceRepository assuranceRepository;
    private ObjectMapper objectMapper;

    public EntrepriseServiceImpl(
            EntrepriseRepository entrepriseRepository,
            ApiSirenService apiSirenService,
            ObjectMapper objectMapper,
            FormeJuridiqueRepository formeJuridiqueRepository,
            DirigeantRepository dirigeantRepository,
            AssuranceRepository assuranceRepository,
            VilleService villeService) {

        this.entrepriseRepository = entrepriseRepository;
        this.apiSirenService = apiSirenService;
        this.objectMapper = objectMapper;
        this.villeService = villeService;
        this.formeJuridiqueRepository = formeJuridiqueRepository;
        this.dirigeantRepository = dirigeantRepository;
        this.assuranceRepository = assuranceRepository;
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


    // méthode permettant de faire un appel au service apiSirenService pour interroger l'api et recupérer les informations de l'entreprise à partir du numéro siret saisi
    public EntrepriseDTO verifierEntreprise(String siret) {

        String jsonData = apiSirenService.verifierEntreprise(siret);
        return recupererEntreprise(jsonData, siret);
    }


    // méthode qui récupère les données depuis l'api siren à partir du numero siret de l'entreprise saisie pour créer un objet entrepriseDTO
    @Override
    public EntrepriseDTO recupererEntreprise(String jsonData, String siret) {

        try {
            JsonNode root = objectMapper.readTree(jsonData);

            EntrepriseDTO entrepriseDTO = new EntrepriseDTO();
            VilleDTO villeDTO = new VilleDTO();

            entrepriseDTO.setNumeroSiret(siret);
            entrepriseDTO.setRaisonSociale(root.path("etablissement").path("unite_legale").path("denomination").asText());
            entrepriseDTO.setAdresseEntreprise(root.path("etablissement").path("numero_voie").asText()
                    + " " + root.path("etablissement").path("type_voie").asText()
                    + " " + root.path("etablissement").path("libelle_voie").asText());

            // valeurs par defaut en attendant de pouvoir connecter le front pour récupérer les données saisies par l'entreprise depuis un formulaire
            entrepriseDTO.setTelephoneEntreprise("0320887766");
            entrepriseDTO.setEmailEntreprise("entreprise@mail.com");


            // récupération des informations concernant la ville depuis le retour de l'api siren
            villeDTO.setNomVille(root.path("etablissement").path("libelle_commune").asText());
            villeDTO.setCodePostal(root.path("etablissement").path("code_postal").asText());
            villeDTO.setCodeInsee(root.path("etablissement").path("code_commune").asText());

            // appel de la méthode permettant de vérifier si la ville est déjà existante en bdd ou s'il faut la persister
            VilleDTO createdVilleDTO = villeService.findOrCreateVille(
                    villeDTO.getCodePostal(),
                    villeDTO.getCodeInsee(),
                    villeDTO.getNomVille()
            );

            entrepriseDTO.setIdVille(createdVilleDTO);

            // récupération des tables etrangeres liées à entreprise déjà présentes en bdd afin de les affecter a mon nouvel objet pour pouvoir par la suite persister en bdd
            FormeJuridique defaultFormeJuridique = formeJuridiqueRepository.getById(1);
            FormeJuridiqueDTO defaultFormeJuridiqueDTO = FormeJuridiqueMapper.toDTO(defaultFormeJuridique);
            entrepriseDTO.setIdFormeJuridique(defaultFormeJuridiqueDTO);

            Dirigeant defaultDirigeant = dirigeantRepository.getById(1);
            DirigeantDTO defaultDirigeantDTO = DirigeantMapper.toDTO(defaultDirigeant);
            entrepriseDTO.setIdDirigeant(defaultDirigeantDTO);

            Assurance defaultAssurance = assuranceRepository.getById(1);
            AssuranceDTO defaultAssuranceDTO = AssuranceMapper.toDTO(defaultAssurance);
            entrepriseDTO.setIdAssurance(defaultAssuranceDTO);

            // retour de l'objet entrepriseDTO construit à partir des différentes données
            return entrepriseDTO;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }


    // méthode permettant d'enregistrer l'entreprise en bdd à partir de l'objet entrepriseDTO récupéré précédemment
    @Override
    public ResponseEntity<EntrepriseDTO> saveEntreprise(EntrepriseDTO entrepriseDTO) {

        try {

            Entreprise entreprise = new Entreprise();
            entreprise.setNumeroSiret(entrepriseDTO.getNumeroSiret());
            entreprise.setRaisonSociale(entrepriseDTO.getRaisonSociale());
            entreprise.setAdresseEntreprise(entrepriseDTO.getAdresseEntreprise());
            entreprise.setTelephoneEntreprise(entrepriseDTO.getTelephoneEntreprise());
            entreprise.setEmailEntreprise(entrepriseDTO.getEmailEntreprise());

            Ville ville = VilleMapper.toEntity(entrepriseDTO.getIdVille());
            entreprise.setIdVille(ville);

            FormeJuridique formeJuridique = FormeJuridiqueMapper.toEntity(entrepriseDTO.getIdFormeJuridique());
            entreprise.setIdFormeJuridique(formeJuridique);

            Dirigeant dirigeant = DirigeantMapper.toEntity(entrepriseDTO.getIdDirigeant());
            entreprise.setIdDirigeant(dirigeant);

            Assurance assurance = AssuranceMapper.toEntity(entrepriseDTO.getIdAssurance());
            entreprise.setIdAssurance(assurance);

            Entreprise createdEntreprise = entrepriseRepository.save(entreprise);
            EntrepriseDTO createdEntrepriseDTO = EntrepriseMapper.toDTO(createdEntreprise);

            return new ResponseEntity<>(createdEntrepriseDTO, HttpStatus.CREATED);

        } catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
