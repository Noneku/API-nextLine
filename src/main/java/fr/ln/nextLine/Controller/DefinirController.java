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
        return definirService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefinirDTO> getDefinirById(@PathVariable Integer id) {
        return definirService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createDefinir(@RequestBody DefinirDTO definirDTO) {
        return definirService.create(definirDTO);
    }

    //Méthode non util
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDefinir(@PathVariable Integer id, @RequestBody DefinirDTO definirDTO) {
        return definirService.update(id, definirDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDefinir(@PathVariable Integer id) {
        return definirService.delete(id);
    }
}
