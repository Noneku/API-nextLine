package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FormeJuridiqueDTO;
import fr.ln.nextLine.Model.Entity.FormeJuridique;
import fr.ln.nextLine.Model.Mapper.FormeJuridiqueMapper;
import fr.ln.nextLine.Service.FormeJuridiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/formes-juridiques")
public class FormeJuridiqueController {

    private final FormeJuridiqueService formeJuridiqueService;

    @Autowired
    public FormeJuridiqueController(FormeJuridiqueService formeJuridiqueService) {
        this.formeJuridiqueService = formeJuridiqueService;
    }

    @GetMapping
    public ResponseEntity<List<FormeJuridiqueDTO>> getAllFormeJuridiques() {
        List<FormeJuridique> formeJuridiques = formeJuridiqueService.getAllFormeJuridiques();
        List<FormeJuridiqueDTO> formeJuridiqueDTOs =
                    formeJuridiques
                            .stream()
                            .map(FormeJuridiqueMapper::toDTO)
                            .toList();
        return ResponseEntity.ok(formeJuridiqueDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormeJuridiqueDTO> getFormeJuridiqueById(@PathVariable Integer id) {
        FormeJuridique formeJuridique = formeJuridiqueService.getFormeJuridiqueById(id);
        if (formeJuridique != null) {
            return ResponseEntity.ok(FormeJuridiqueMapper.toDTO(formeJuridique));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FormeJuridiqueDTO> createFormeJuridique(@RequestBody FormeJuridique formeJuridique) {
        FormeJuridique createdFormeJuridique = formeJuridiqueService.createFormeJuridique(formeJuridique);
        return ResponseEntity.status(HttpStatus.CREATED).body(FormeJuridiqueMapper.toDTO(createdFormeJuridique));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormeJuridiqueDTO> updateFormeJuridique(@PathVariable Integer id, @RequestBody FormeJuridique formeJuridique) {
        FormeJuridique updatedFormeJuridique = formeJuridiqueService.updateFormeJuridique(id, formeJuridique);
        if (updatedFormeJuridique != null) {
            return ResponseEntity.ok(FormeJuridiqueMapper.toDTO(updatedFormeJuridique));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormeJuridique(@PathVariable Integer id) {
        boolean deleted = formeJuridiqueService.deleteFormeJuridique(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
