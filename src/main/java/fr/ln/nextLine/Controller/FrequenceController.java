package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.FrequenceDTO;
import fr.ln.nextLine.Service.FrequenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frequences")
public class FrequenceController {

    private final FrequenceService frequenceService;

    public FrequenceController(FrequenceService frequenceService) {

        this.frequenceService = frequenceService;
    }

    @GetMapping
    public ResponseEntity<List<FrequenceDTO>> getAllFrequences() {

        return frequenceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FrequenceDTO> getFrequenceById(@PathVariable Integer id) {

        return frequenceService.getById(id);
    }

    @PostMapping
    public ResponseEntity<FrequenceDTO> createFrequence(@RequestBody FrequenceDTO frequenceDTO) {

        return frequenceService.create(frequenceDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FrequenceDTO> updateFrequence(@PathVariable Integer id, @RequestBody FrequenceDTO frequenceDTO) {

        return frequenceService.update(id, frequenceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrequence(@PathVariable Integer id) {

        return frequenceService.delete(id);

    }
}
