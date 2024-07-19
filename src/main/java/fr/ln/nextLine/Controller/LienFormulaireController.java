package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Model.Mapper.LienFormulaireMapper;
import fr.ln.nextLine.Service.LienFormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liens-formulaires")
public class LienFormulaireController {

    private final LienFormulaireService lienFormulaireService;

    @Autowired
    public LienFormulaireController(LienFormulaireService lienFormulaireService) {
        this.lienFormulaireService = lienFormulaireService;
    }

    @GetMapping
    public ResponseEntity<List<LienFormulaireDTO>> getAllLiensFormulaires() {

        List<LienFormulaire> liensFormulaires = lienFormulaireService.getAllLiensFormulaires();
        List<LienFormulaireDTO> lienFormulairesDTO =
                liensFormulaires
                                .stream()
                                .map(LienFormulaireMapper::toDTO)
                                .toList();
        return new ResponseEntity<>(lienFormulairesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LienFormulaireDTO> getLienFormulaireById(@PathVariable Integer id) {

        LienFormulaire lienFormulaire = lienFormulaireService.getLienFormulaireById(id);

        return new ResponseEntity<>(LienFormulaireMapper.toDTO(lienFormulaire), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LienFormulaireDTO> createLienFormulaire(@RequestBody LienFormulaireDTO lienFormulaireDTO) {

        LienFormulaire lienFormulaire = LienFormulaireMapper.toEntity(lienFormulaireDTO);
        LienFormulaire createdLienFormulaire = lienFormulaireService.createLienFormulaire(lienFormulaire);
        LienFormulaireDTO createdLienFormulaireDTO = LienFormulaireMapper.toDTO(createdLienFormulaire);

        return new ResponseEntity<>(createdLienFormulaireDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LienFormulaireDTO> updateLienFormulaire(@PathVariable Integer id, @RequestBody LienFormulaireDTO lienFormulaireDTO) {

        LienFormulaire lienFormulaire = LienFormulaireMapper.toEntity(lienFormulaireDTO);
        LienFormulaire updatedLienFormulaire = lienFormulaireService.updateLienFormulaire(id, lienFormulaire);

        if (updatedLienFormulaire == null) {
            LienFormulaireDTO updatedLienFormulaireDTO = LienFormulaireMapper.toDTO(lienFormulaire);
            return new ResponseEntity<>(updatedLienFormulaireDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLienFormulaire(@PathVariable Integer id) {
        boolean deleted = lienFormulaireService.deleteLienFormulaire(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
