package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.LocauxDTO;
import fr.ln.nextLine.Service.LocauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locaux")
public class LocauxController {

    private final LocauxService locauxService;

    @Autowired
    public LocauxController(LocauxService locauxService) {

        this.locauxService = locauxService;
    }

    @GetMapping
    public ResponseEntity<List<LocauxDTO>> getAllLocaux() {

        return locauxService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocauxDTO> getLocauxById(@PathVariable Integer id) {

        return locauxService.getById(id);
    }

    @PostMapping
    public ResponseEntity<LocauxDTO> createLocaux(@RequestBody LocauxDTO locauxDTO) {

        return locauxService.create(locauxDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocauxDTO> updateLocaux(@PathVariable Integer id, @RequestBody LocauxDTO locauxDTO) {

        return locauxService.update(id, locauxDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocaux(@PathVariable Integer id) {

        return locauxService.delete(id);

    }
}
