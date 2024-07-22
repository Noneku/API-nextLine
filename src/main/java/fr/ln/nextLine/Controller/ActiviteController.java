package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Mapper.ActiviteMapper;
import fr.ln.nextLine.Service.ActiviteService;
import fr.ln.nextLine.Service.Impl.ActiviteServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return activiteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiviteDTO> getActiviteById(@PathVariable Integer id){

        return activiteService.getById(id);
    }


    @PostMapping("/create")
    public ResponseEntity<ActiviteDTO> createActivite(@RequestBody ActiviteDTO activiteDTO) {
        return activiteService.create(activiteDTO);
    }

    /*
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
       */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable Integer id) {
        return activiteService.delete(id);
    }
}
