package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.JourDTO;
import fr.ln.nextLine.Service.JourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jours")
public class JourController {

    private final JourService jourService;

    public JourController(JourService jourService) {

        this.jourService = jourService;
    }

    @GetMapping
    public ResponseEntity<List<JourDTO>> getAllJours() {

        return jourService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JourDTO> getJourById(@PathVariable Integer id) {

        return jourService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createJour(@RequestBody JourDTO jourDTO) {

        return jourService.create(jourDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJour(@PathVariable Integer id, @RequestBody JourDTO jourDTO) {

        return jourService.update(id, jourDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJour(@PathVariable Integer id) {

        return jourService.delete(id);

    }
}
