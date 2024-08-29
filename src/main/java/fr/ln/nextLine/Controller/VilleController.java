package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Service.VilleService;
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

    // appel de la méthode pour chercher une ville a partir du CP et du Code insee
    @GetMapping("/find")
    public ResponseEntity<VilleDTO> getByCodePostalAndCodeInsee(@RequestParam String codePostal, @RequestParam String codeInsee) {

        return villeService.findByCodePostalAndCodeInsee(codePostal, codeInsee);

        // pour accéder à cet endpoint : GET /find?codePostal={codePostal}&codeInsee={codeInsee}
    }

    // appel de la méthode pour chercher ou persister une ville
    @PostMapping("/find-or-create")
    public VilleDTO findOrCreateVille(@RequestParam String codePostal, @RequestParam String codeInsee, @RequestParam String nomVille) {

        return villeService.findOrCreateVille(codePostal, codeInsee, nomVille);
    }
}
