package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.UtilisateurMapper;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {

        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        List<UtilisateurDTO> utilisateurDTO = utilisateurs
                .stream()
                .map(UtilisateurMapper::toDTO)
                .toList();

        return new ResponseEntity<>(utilisateurDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Integer id) {

        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);

        return new ResponseEntity<>(UtilisateurMapper.toDTO(utilisateur), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = UtilisateurMapper.toEntity(utilisateurDTO);
        Utilisateur createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        UtilisateurDTO createdUtilisateurDTO = UtilisateurMapper.toDTO(createdUtilisateur);

        return new ResponseEntity<>(createdUtilisateurDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = UtilisateurMapper.toEntity(utilisateurDTO);
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateur);

        if (updatedUtilisateur != null) {
            UtilisateurDTO updatedUtilisateurDTO = UtilisateurMapper.toDTO(updatedUtilisateur);
            return new ResponseEntity<>(updatedUtilisateurDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        boolean deleted = utilisateurService.deleteUtilisateur(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
