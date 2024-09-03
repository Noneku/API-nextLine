package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FormeJuridiqueDTO;
import fr.ln.nextLine.Service.FormeJuridiqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formes-juridiques")
public class FormeJuridiqueController {

    private final FormeJuridiqueService formeJuridiqueService;

    public FormeJuridiqueController(FormeJuridiqueService formeJuridiqueService) {

        this.formeJuridiqueService = formeJuridiqueService;
    }

    @GetMapping
    public ResponseEntity<List<FormeJuridiqueDTO>> getAllFormesJuridiques() {

        return formeJuridiqueService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormeJuridiqueDTO> getFormeJuridiqueById(@PathVariable Integer id) {

        return formeJuridiqueService.getById(id);
    }

    @PostMapping
    public ResponseEntity<FormeJuridiqueDTO> createFormeJuridique(@RequestBody FormeJuridiqueDTO formeJuridiqueDTO) {

        return formeJuridiqueService.create(formeJuridiqueDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormeJuridiqueDTO> updateFormeJuridique(@PathVariable Integer id, @RequestBody FormeJuridiqueDTO formeJuridiqueDTO) {

        return formeJuridiqueService.update(id, formeJuridiqueDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormeJuridique(@PathVariable Integer id) {

        return formeJuridiqueService.delete(id);
    }

    @PostMapping("/find-or-create/{nom_forme_juridique}")
    public FormeJuridiqueDTO findOrCreateFormeJuridique(@PathVariable ("nom_forme_juridique") String nom_forme_juridique) {

        return formeJuridiqueService.findOrCreateFormeJuridique(nom_forme_juridique);
    }
}
