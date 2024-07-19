package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FonctionDTO;
import fr.ln.nextLine.Model.Entity.Fonction;
import fr.ln.nextLine.Model.Mapper.FonctionMapper;
import fr.ln.nextLine.Service.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fonctions")
public class FonctionController {

    private final FonctionService fonctionService;

    @Autowired
    public FonctionController(FonctionService fonctionService) {
        this.fonctionService = fonctionService;
    }

    @GetMapping
    public ResponseEntity<List<FonctionDTO>> getAllFonctions() {
        List<Fonction> fonctions = fonctionService.getAllFonctions();
        List<FonctionDTO> fonctionsDTOs =
                fonctions
                        .stream()
                        .map(FonctionMapper::toDTO)
                        .toList();
        return ResponseEntity.ok(fonctionsDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FonctionDTO> getFonctionById(@PathVariable Integer id) {
        Fonction fonction = fonctionService.getFonctionById(id);
        if (fonction != null) {
            return new ResponseEntity<>(FonctionMapper.toDTO(fonction), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FonctionDTO> createFonction(@RequestBody Fonction fonction) {
        Fonction createdFonction = fonctionService.createFonction(fonction);

        return ResponseEntity.status(HttpStatus.CREATED).body(FonctionMapper.toDTO(createdFonction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FonctionDTO> updateFonction(@PathVariable Integer id, @RequestBody Fonction fonction) {
        Fonction updatedFonction = fonctionService.updateFonction(id, fonction);
        if (updatedFonction != null) {
            return ResponseEntity.ok(FonctionMapper.toDTO(updatedFonction));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFonction(@PathVariable Integer id) {
        boolean deleted = fonctionService.deleteFonction(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
