package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Service.FonctionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fonctions")
public class FonctionController {

    private final FonctionService fonctionService;

    public FonctionController(FonctionService fonctionService) {

        this.fonctionService = fonctionService;
    }

    @GetMapping
    public ResponseEntity<List<FonctionDTO>> getAllFonctions() {

        return fonctionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FonctionDTO> getFonctionById(@PathVariable Integer id) {

        return fonctionService.getById(id);
    }

    @PostMapping
    public ResponseEntity<FonctionDTO> createFonction(@RequestBody FonctionDTO fonctionDTO) {

        return fonctionService.create(fonctionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FonctionDTO> updateFonction(@PathVariable Integer id, @RequestBody FonctionDTO fonctionDTO) {

        return fonctionService.update(id, fonctionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFonction(@PathVariable Integer id) {

        return fonctionService.delete(id);

    }
}
