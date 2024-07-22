package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activites")
public class ActiviteController {

    private final ActiviteService activiteService;

    @Autowired
    public ActiviteController(ActiviteService activiteService) {

        this.activiteService = activiteService;
    }

    @GetMapping
    public ResponseEntity<List<ActiviteDTO>> getAllActivites() {

        return activiteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiviteDTO> getActiviteById(@PathVariable Integer id) {

        return activiteService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ActiviteDTO> createActivite(@RequestBody ActiviteDTO activiteDTO) {

        return activiteService.create(activiteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActiviteDTO> updateActivite(@PathVariable Integer id, @RequestBody ActiviteDTO activiteDTO) {

        return activiteService.update(id, activiteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable Integer id) {

        return activiteService.delete(id);

    }
}
