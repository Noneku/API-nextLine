package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import fr.ln.nextLine.Model.Entity.Entreprise;
import fr.ln.nextLine.Model.Mapper.AssuranceMapper;
import fr.ln.nextLine.Model.Mapper.EntrepriseMapper;
import fr.ln.nextLine.Service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public ResponseEntity<List<EntrepriseDTO>> getAllEntreprises() {
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
        List<EntrepriseDTO> entrepriseDTOs =
                entreprises
                        .stream()
                        .map(EntrepriseMapper::toDTO)
                        .toList();
        return new ResponseEntity<>(entrepriseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseById(@PathVariable Integer id) {
        Entreprise entreprise = entrepriseService.getEntrepriseById(id);

        if (entreprise != null) {
            return new ResponseEntity<>(EntrepriseMapper.toDTO(entreprise), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<EntrepriseDTO> createEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise createdEntreprise = entrepriseService.createEntreprise(entreprise);

        return ResponseEntity.status(HttpStatus.CREATED).body(EntrepriseMapper.toDTO(createdEntreprise));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> updateEntreprise(@PathVariable Integer id, @RequestBody Entreprise entreprise) {
        Entreprise updatedEntreprise = entrepriseService.updateEntreprise(id, entreprise);

        if (updatedEntreprise != null) {
            return ResponseEntity.ok(EntrepriseMapper.toDTO(updatedEntreprise));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Integer id) {
        boolean deleted = entrepriseService.deleteEntreprise(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
