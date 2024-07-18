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
        List<ActiviteDTO> activitesDTO =
                activites.stream()
                         .map(ActiviteMapper::toDTO)
                         .toList();

        return new ResponseEntity<>(activitesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiviteDTO> getActiviteById(@PathVariable Integer id) {

        Activite activite = activiteService.getActiviteById(id);

        return new ResponseEntity<>(ActiviteMapper.toDTO(activite), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActiviteDTO> createActivite(@RequestBody ActiviteDTO activiteDTO) {

        Activite activite = ActiviteMapper.toEntity(activiteDTO);
        Activite createdActivite = activiteService.createActivite(activite);
        ActiviteDTO createdActiviteDTO = ActiviteMapper.toDTO(createdActivite);

        return new ResponseEntity<>(createdActiviteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActiviteDTO> updateActivite(@PathVariable Integer id, @RequestBody ActiviteDTO activiteDTO) {

        Activite activite = ActiviteMapper.toEntity(activiteDTO);
        Activite updatedActivite = activiteService.updateActivite(id, activite);

        if (updatedActivite != null) {
            ActiviteDTO updatedActiviteDTO = ActiviteMapper.toDTO(updatedActivite);
           return new ResponseEntity<>(updatedActiviteDTO, HttpStatus.OK);
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
