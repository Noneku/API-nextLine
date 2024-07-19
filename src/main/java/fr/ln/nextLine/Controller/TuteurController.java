package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.TuteurDTO;
import fr.ln.nextLine.Model.Entity.Tuteur;
import fr.ln.nextLine.Model.Mapper.TuteurMapper;
import fr.ln.nextLine.Service.TuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        List<Tuteur> tuteurs = tuteurService.getAllTuteurs();
        List<TuteurDTO> tuteurDTOS = tuteurs
                .stream()
                .map(TuteurMapper::toDTO)
                .toList();

        return new ResponseEntity<>(tuteurDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuteurDTO> getTuteurById(@PathVariable Integer id) {

        Tuteur tuteur = tuteurService.getTuteurById(id);

        return new ResponseEntity<>(TuteurMapper.toDTO(tuteur), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TuteurDTO> createTuteur(@RequestBody TuteurDTO tuteurDTO) {

        Tuteur tuteur = TuteurMapper.toEntity(tuteurDTO);
        Tuteur createdTuteur = tuteurService.createTuteur(tuteur);
        TuteurDTO createdTuteurDTO = TuteurMapper.toDTO(createdTuteur);

        return new ResponseEntity<>(createdTuteurDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuteurDTO> updateTuteur(@PathVariable Integer id, @RequestBody TuteurDTO tuteurDTO) {

        Tuteur tuteur = TuteurMapper.toEntity(tuteurDTO);
        Tuteur updatedTuteur = tuteurService.updateTuteur(id, tuteur);

        if (updatedTuteur != null) {
            TuteurDTO updatedTuteurDTO = TuteurMapper.toDTO(updatedTuteur);
            return new ResponseEntity<>(updatedTuteurDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTuteur(@PathVariable Integer id) {
        boolean deleted = tuteurService.deleteTuteur(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
