package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-nextline")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {

        this.utilisateurService = utilisateurService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {

        return utilisateurService.getAll();
    }

    @GetMapping("/user/search-by/login/{utilisateurLogin}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurByLogin(@PathVariable String utilisateurLogin) {
        return null; //utilisateurService.findByLogin(utilisateurLogin);
    }

    @GetMapping("/user/search-by/id/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Integer id) {

        return utilisateurService.getById(id);
    }


    @PostMapping("/user/create-user")
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {

        return utilisateurService.create(utilisateurDTO);
    }

    @PutMapping("/user/update-user/{id}")
    public ResponseEntity<UtilisateurDTO> updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDTO utilisateurDTO) {

        return utilisateurService.update(id, utilisateurDTO);
    }

    @DeleteMapping("/user/delete-by/id/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {

        return utilisateurService.delete(id);

    }
}
