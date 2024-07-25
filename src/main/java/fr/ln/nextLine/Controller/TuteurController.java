package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.TuteurDTO;
import fr.ln.nextLine.Service.TuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuteurs")
public class TuteurController {

    private final TuteurService tuteurService;

    @Autowired
    public TuteurController(TuteurService tuteurService) {

        this.tuteurService = tuteurService;
    }

    @GetMapping
    public ResponseEntity<List<TuteurDTO>> getAllTuteurs() {

        return tuteurService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuteurDTO> getTuteurById(@PathVariable Integer id) {

        return tuteurService.getById(id);
    }

    @PostMapping
    public ResponseEntity<TuteurDTO> createTuteur(@RequestBody TuteurDTO tuteurDTO) {

        return tuteurService.create(tuteurDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuteurDTO> updateTuteur(@PathVariable Integer id, @RequestBody TuteurDTO tuteurDTO) {

        return tuteurService.update(id, tuteurDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTuteur(@PathVariable Integer id) {

        return tuteurService.delete(id);

    }
}
