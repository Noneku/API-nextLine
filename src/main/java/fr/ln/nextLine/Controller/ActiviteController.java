package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Mapper.ActiviteMapper;
import fr.ln.nextLine.Service.ActiviteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activites")
public class ActiviteController {

    private final ActiviteService activiteService;

    public ActiviteController(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }


    @GetMapping
    public ResponseEntity<List<ActiviteDTO>> getAllActivites() {

        List<Activite> activites = activiteService.getAllActivites();
        List<ActiviteDTO> activitesDto =
                activites.stream()
                         .map(ActiviteMapper::toDTO)
                         .toList();

        return new ResponseEntity<>(activitesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiviteDTO> getActiviteById(@PathVariable Integer id) {

        Activite activite = activiteService.getActiviteById(id);

        if (activite != null) {
            return new ResponseEntity<>(ActiviteMapper.toDTO(activite), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Activite> createActivite(@RequestBody Activite activite) {
        Activite createdActivite = activiteService.createActivite(activite);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdActivite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activite> updateActivite(@PathVariable Integer id, @RequestBody Activite activite) {
        Activite updatedActivite = activiteService.updateActivite(id, activite);
        if (updatedActivite != null) {
            return ResponseEntity.ok(updatedActivite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable Integer id) {
        boolean deleted = activiteService.deleteActivite(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
