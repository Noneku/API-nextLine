package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Model.Entity.Ville;
import fr.ln.nextLine.Model.Mapper.VilleMapper;
import fr.ln.nextLine.Model.Repository.VilleRepository;
import fr.ln.nextLine.Service.VilleService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VilleServiceImpl implements VilleService {

    private final VilleRepository villeRepository;

    public VilleServiceImpl(VilleRepository villeRepository) {

        this.villeRepository = villeRepository;
    }

    @Override
    public ResponseEntity<List<VilleDTO>> getAll() {

        List<VilleDTO> villeDTOs = villeRepository.findAll()
                .stream()
                .map(VilleMapper::toDTO)
                .toList();

        if (villeDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(villeDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VilleDTO> getById(Integer id) {

        Optional<Ville> ville = villeRepository.findById(id);

        return ville.map(
                        value -> new ResponseEntity<>(VilleMapper.toDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<VilleDTO> create(VilleDTO villeDTO) {

        Ville ville = VilleMapper.toEntity(villeDTO);
        Ville createdVille = villeRepository.save(ville);
        VilleDTO createdVilleDTO = VilleMapper.toDTO(createdVille);

        return new ResponseEntity<>(createdVilleDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<VilleDTO> update(Integer id, VilleDTO villeDTO) {

        if (villeRepository.existsById(id)) {

            Ville ville = VilleMapper.toEntity(villeDTO);
            ville.setId(id);
            Ville updatedVille = villeRepository.save(ville);
            VilleDTO updatedVilleDTO = VilleMapper.toDTO(updatedVille);

            return new ResponseEntity<>(updatedVilleDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Ville> villeOptional = villeRepository.findById(id);

        if (villeOptional.isPresent()) {

            villeRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    // methode permettant de rechercher la présence d'une ville en bdd à partir de la présence du code postal + du code insee de la ville
    public ResponseEntity<VilleDTO> findByCodePostalAndCodeInsee(String codePostal, String codeInsee) {

        Optional<Ville> ville = villeRepository.findByCodePostalAndCodeInsee(codePostal,codeInsee);

        return ville.map(
                        value -> new ResponseEntity<>(VilleMapper.toDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // méthode permettant de verifier en bdd si les données de la ville passée en paramètre sont déjà présentes en bdd
    public VilleDTO findOrCreateVille(String codePostal, String codeInsee, String nomVille) {

        Optional<Ville> optionalVille = villeRepository.findByCodePostalAndCodeInsee(codePostal, codeInsee);

        Ville ville;

        // si la ville est présente en bdd, récupération des informations de la ville
        if (optionalVille.isPresent()) {

            ville = optionalVille.get();

            // si la ville n'est pas présente en bdd, persistance d'un nouvel objet ville en bdd
        } else {

            ville = new Ville();
            ville.setCodePostal(codePostal);
            ville.setCodeInsee(codeInsee);
            ville.setNomVille(nomVille);

            ville = villeRepository.save(ville);
        }

        // retour de la ville selon les données fournies en paramètre
        return VilleMapper.toDTO(ville);
    }
}
