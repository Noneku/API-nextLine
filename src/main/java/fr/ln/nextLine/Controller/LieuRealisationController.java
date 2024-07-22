package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.LieuRealisationDTO;
import fr.ln.nextLine.Model.Entity.LieuRealisation;
import fr.ln.nextLine.Model.Mapper.LieuRealisationMapper;
import fr.ln.nextLine.Service.LieuRealisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lieux-realisation")
public class LieuRealisationController {

    private final LieuRealisationService lieuRealisationService;

    @Autowired
    public LieuRealisationController(LieuRealisationService lieuRealisationService) {
        this.lieuRealisationService = lieuRealisationService;
    }

    @GetMapping
    public ResponseEntity<List<LieuRealisationDTO>> getAllLieuxRealisation() {

        List<LieuRealisation> lieuxRealisation = lieuRealisationService.getAllLieuxRealisations();
        List<LieuRealisationDTO> lieuxRealisationDTO =
                lieuxRealisation
                        .stream()
                        .map(LieuRealisationMapper::toDTO)
                        .toList();
        return new ResponseEntity<>(lieuxRealisationDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LieuRealisationDTO> getLieuRealisationById(@PathVariable Integer id) {

        LieuRealisation lieuRealisation = lieuRealisationService.getLieuRealisationById(id);

        return new ResponseEntity<>(LieuRealisationMapper.toDTO(lieuRealisation), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LieuRealisationDTO> createLieuRealisation(@RequestBody LieuRealisationDTO lieuRealisationDTO) {

        LieuRealisation lieuRealisation = LieuRealisationMapper.toEntity(lieuRealisationDTO);
        LieuRealisation createdLieuRealisation = lieuRealisationService.createLieuRealisation(lieuRealisation);
        LieuRealisationDTO createdlieuRealisationDTO = LieuRealisationMapper.toDTO(createdLieuRealisation);

        return new ResponseEntity<>(createdlieuRealisationDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LieuRealisationDTO> updateLieuRealisation(@PathVariable Integer id, @RequestBody LieuRealisationDTO lieuRealisationDTO) {

        LieuRealisation lieuRealisation = LieuRealisationMapper.toEntity(lieuRealisationDTO);
        LieuRealisation updatedLieuRealisation = lieuRealisationService.updateLieuRealisation(id, lieuRealisation);

        if (updatedLieuRealisation != null) {
            LieuRealisationDTO updatedLieuRealisationDTO = LieuRealisationMapper.toDTO(lieuRealisation);
            return new ResponseEntity<>(updatedLieuRealisationDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLieuRealisation(@PathVariable Integer id) {
        boolean deleted = lieuRealisationService.deleteLieuRealisation(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
