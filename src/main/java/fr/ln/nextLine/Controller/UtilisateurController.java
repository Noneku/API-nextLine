package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.UtilisateurMapper;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurRepository utilisateurRepository) {

        this.utilisateurService = utilisateurService;
        this.utilisateurRepository = utilisateurRepository;
    }


    @GetMapping("/all-users")
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {

        return utilisateurService.getAll();
    }

    @GetMapping("/search-by/login/{utilisateurLogin}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurByLogin(@PathVariable String utilisateurLogin) {
        return null; //utilisateurService.findByLogin(utilisateurLogin);
    }

    @GetMapping("/search-by/id/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Integer id) {

        return utilisateurService.getById(id);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {

        return utilisateurService.create(utilisateurDTO);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDTO utilisateurDTO) {

        return utilisateurService.update(id,utilisateurDTO);
    }

    @DeleteMapping("/delete-by/id/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable Integer id) {

        return utilisateurService.delete(id);

    }

    @GetMapping("/user-connected")
    public ResponseEntity<UtilisateurDTO> recupererUtilisateurConnecte() {

        UtilisateurDTO utilisateurDTO = utilisateurService.recupererUtilisateurConnecte();

        if (utilisateurDTO != null) {
            return ResponseEntity.ok(utilisateurDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
