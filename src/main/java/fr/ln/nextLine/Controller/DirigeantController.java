package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.DirigeantDTO;
import fr.ln.nextLine.Service.DirigeantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dirigeants")
public class DirigeantController {

    private final DirigeantService dirigeantService;

    public DirigeantController(DirigeantService dirigeantService) {

        this.dirigeantService = dirigeantService;
    }

    @GetMapping
    public ResponseEntity<List<DirigeantDTO>> getAllDirigeants() {

        return dirigeantService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirigeantDTO> getDirigeantById(@PathVariable Integer id) {

        return dirigeantService.getById(id);
    }

    @PostMapping
    public ResponseEntity<DirigeantDTO> createDirigeant(@RequestBody DirigeantDTO dirigeantDTO) {

        return dirigeantService.create(dirigeantDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirigeantDTO> updateDirigeant(@PathVariable Integer id, @RequestBody DirigeantDTO dirigeantDTO) {

        return dirigeantService.update(id, dirigeantDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirigeant(@PathVariable Integer id) {

        return dirigeantService.delete(id);

    }
}
