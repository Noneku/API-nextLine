package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.LieuRealisationDTO;
import fr.ln.nextLine.Service.LieuRealisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lieux-realisation")
public class LieuRealisationController {

    private final LieuRealisationService lieuRealisationService;

    @Autowired
    public LieuRealisationController(LieuRealisationService lieuRealisationService) {

        this.lieuRealisationService = lieuRealisationService;
    }

    @GetMapping
    public ResponseEntity<List<LieuRealisationDTO>> getAllLieuxRealisation() {

        return lieuRealisationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LieuRealisationDTO> getLieuRealisationById(@PathVariable Integer id) {

        return lieuRealisationService.getById(id);
    }

    @PostMapping
    public ResponseEntity<LieuRealisationDTO> createLieuRealisation(@RequestBody LieuRealisationDTO lieuRealisationDTO) {

        return lieuRealisationService.create(lieuRealisationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LieuRealisationDTO> updateLieuRealisation(@PathVariable Integer id, @RequestBody LieuRealisationDTO lieuRealisationDTO) {

        return lieuRealisationService.update(id, lieuRealisationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Integer id) {

        return lieuRealisationService.delete(id);

    }
}
