package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

    private final VilleService villeService;

    public VilleController(VilleService villeService) {

        this.villeService = villeService;
    }

    @GetMapping
    public ResponseEntity<List<VilleDTO>> getAllVilles() {

        return villeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDTO> getVilleById(@PathVariable Integer id) {

        return villeService.getById(id);
    }

    @PostMapping
    public ResponseEntity<VilleDTO> createVille(@RequestBody VilleDTO villeDTO) {

        return villeService.create(villeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VilleDTO> updateVille(@PathVariable Integer id, @RequestBody VilleDTO villeDTO) {

        return villeService.update(id, villeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Integer id) {

        return villeService.delete(id);

    }
}
