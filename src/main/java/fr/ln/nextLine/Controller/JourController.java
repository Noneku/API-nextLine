package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.JourDTO;
import fr.ln.nextLine.Model.Entity.Jour;
import fr.ln.nextLine.Model.Mapper.JourMapper;
import fr.ln.nextLine.Service.JourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jours")
public class JourController {

    private final JourService jourService;

    @Autowired
    public JourController(JourService jourService) {
        this.jourService = jourService;
    }

    @GetMapping
    public ResponseEntity<List<JourDTO>> getAllJours() {
        List<Jour> jours = jourService.getAllJours();
        List<JourDTO> jourDTOs =
                jours
                        .stream()
                        .map(JourMapper::toDTO)
                        .toList();
        return ResponseEntity.ok(jourDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JourDTO> getJourById(@PathVariable Integer id) {
        Jour jour = jourService.getJourById(id);
        if (jour != null) {
            return ResponseEntity.ok(JourMapper.toDTO(jour));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<JourDTO> createJour(@RequestBody Jour jour) {
        Jour createdJour = jourService.createJour(jour);
        return ResponseEntity.status(HttpStatus.CREATED).body(JourMapper.toDTO(createdJour));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JourDTO> updateJour(@PathVariable Integer id, @RequestBody Jour jour) {
        Jour updatedJour = jourService.updateJour(id, jour);
        if (updatedJour != null) {
            return ResponseEntity.ok(JourMapper.toDTO(updatedJour));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJour(@PathVariable Integer id) {
        boolean deleted = jourService.deleteJour(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
