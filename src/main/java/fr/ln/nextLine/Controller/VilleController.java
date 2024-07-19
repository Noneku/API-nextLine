package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Model.Entity.Ville;
import fr.ln.nextLine.Model.Mapper.VilleMapper;
import fr.ln.nextLine.Service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public ResponseEntity<List<VilleDTO>> getAllVilles() {

        List<Ville> villes = villeService.getAllVilles();
        List<VilleDTO> villesDTO = villes
                .stream()
                .map(VilleMapper::toDTO)
                .toList();

        return new ResponseEntity<>(villesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDTO> getVilleById(@PathVariable Integer id) {

        Ville ville = villeService.getVilleById(id);

        return new ResponseEntity<>(VilleMapper.toDTO(ville), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VilleDTO> createVille(@RequestBody VilleDTO villeDTO) {

        Ville ville = VilleMapper.toEntity(villeDTO);
        Ville createdVille = villeService.createVille(ville);
        VilleDTO createdVilleDTO = VilleMapper.toDTO(createdVille);

        return new ResponseEntity<>(createdVilleDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VilleDTO> updateVille(@PathVariable Integer id, @RequestBody VilleDTO villeDTO) {

        Ville ville = VilleMapper.toEntity(villeDTO);
        Ville updatedVille = villeService.updateVille(id, ville);

        if (updatedVille != null) {
            VilleDTO updatedVilleDTO = VilleMapper.toDTO(updatedVille);
            return new ResponseEntity<>(updatedVilleDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Integer id) {
        boolean deleted = villeService.deleteVille(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
