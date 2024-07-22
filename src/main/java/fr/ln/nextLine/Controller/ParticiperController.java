package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.ParticiperDTO;
import fr.ln.nextLine.Model.Entity.Participer;
import fr.ln.nextLine.Model.Mapper.ParticiperMapper;
import fr.ln.nextLine.Service.ParticiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participer")
public class ParticiperController {

    private final ParticiperService participerService;

    @Autowired
    public ParticiperController(ParticiperService participerService) {
        this.participerService = participerService;
    }

    @GetMapping
    public ResponseEntity<List<ParticiperDTO>> getAllParticipers() {

        List<Participer> participers = participerService.getAllParticiper();
        List<ParticiperDTO> participerDTOS =
                participers.stream()
                        .map(ParticiperMapper::toDTO)
                        .toList();

        return new ResponseEntity<>(participerDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participer> getParticiperById(@PathVariable Integer id) {
        Participer participer = participerService.getParticiperById(id);
        if (participer != null) {
            return ResponseEntity.ok(participer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Participer> createParticiper(@RequestBody Participer participer) {
        Participer createdParticiper = participerService.createParticiper(participer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParticiper);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participer> updateParticiper(@PathVariable Integer id, @RequestBody Participer participer) {
        Participer updatedParticiper = participerService.updateParticiper(id, participer);
        if (updatedParticiper != null) {
            return ResponseEntity.ok(updatedParticiper);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticiper(@PathVariable Integer id) {
        boolean deleted = participerService.deleteParticiper(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
