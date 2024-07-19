package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.DefinirDTO;
import fr.ln.nextLine.Model.Entity.Definir;
import fr.ln.nextLine.Model.Mapper.DefinirMapper;
import fr.ln.nextLine.Service.DefinirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/definirs")
public class DefinirController {

    private final DefinirService definirService;

    @Autowired
    public DefinirController(DefinirService definirService) {
        this.definirService = definirService;
    }

    @GetMapping
    public ResponseEntity<List<DefinirDTO>> getAllDefinirs() {
        List<Definir> definirs = definirService.getAllDefinirs();
        List<DefinirDTO> definirDTOs =
                definirs
                        .stream()
                        .map(DefinirMapper::toDTO)
                        .toList();
        return ResponseEntity.ok(definirDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefinirDTO> getDefinirById(@PathVariable Integer id) {
        Definir definir = definirService.getDefinirById(id);
        if (definir != null) {
            return ResponseEntity.ok(DefinirMapper.toDTO(definir));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DefinirDTO> createDefinir(@RequestBody Definir definir) {
        Definir createdDefinir = definirService.createDefinir(definir);
        return ResponseEntity.status(HttpStatus.CREATED).body(DefinirMapper.toDTO(createdDefinir));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefinirDTO> updateDefinir(@PathVariable Integer id, @RequestBody Definir definir) {
        Definir updatedDefinir = definirService.updateDefinir(id, definir);
        if (updatedDefinir != null) {
            return ResponseEntity.ok(DefinirMapper.toDTO(updatedDefinir));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDefinir(@PathVariable Integer id) {
        boolean deleted = definirService.deleteDefinir(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
