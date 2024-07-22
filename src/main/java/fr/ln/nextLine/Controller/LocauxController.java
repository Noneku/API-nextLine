package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.LocauxDTO;
import fr.ln.nextLine.Model.Entity.Locaux;
import fr.ln.nextLine.Model.Mapper.LocauxMapper;
import fr.ln.nextLine.Service.LocauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        List<Locaux> locaux = locauxService.getAllLocaux();
        List<LocauxDTO> locauxDTO = locaux
                .stream()
                .map(LocauxMapper::toDTO)
                .toList();

        return new ResponseEntity<>(locauxDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocauxDTO> getLocalById(@PathVariable Integer id) {

        Locaux locaux = locauxService.getLocalById(id);

        return new ResponseEntity<>(LocauxMapper.toDTO(locaux), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocauxDTO> createLocal(@RequestBody LocauxDTO locauxDTO) {

        Locaux locaux = LocauxMapper.toEntity(locauxDTO);
        Locaux createdLocal = locauxService.createLocal(locaux);
        LocauxDTO createdLocauxDTO = LocauxMapper.toDTO(createdLocal);

        return new ResponseEntity<>(createdLocauxDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocauxDTO> updateLocal(@PathVariable Integer id, @RequestBody LocauxDTO locauxDTO) {

        Locaux locaux = LocauxMapper.toEntity(locauxDTO);
        Locaux updatedLocal = locauxService.updateLocal(id, locaux);

        if (updatedLocal != null) {
            LocauxDTO updatedLocauxDTO = LocauxMapper.toDTO(updatedLocal);
            return new ResponseEntity<>(updatedLocauxDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Integer id) {
        boolean deleted = locauxService.deleteLocal(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
