package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Definir;
import fr.ln.nextLine.Service.DefinirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/definir")
public class DefinirController {

    private final DefinirService DefinirService;

    @Autowired
    public DefinirController(DefinirService DefinirService) {
        this.DefinirService = DefinirService;
    }

    @GetMapping
    public ResponseEntity<List<Definir>> getAllDefinirs() {
        List<Definir> Definirs = DefinirService.getAllDefinirs();
        return ResponseEntity.ok(Definirs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Definir> getDefinirById(@PathVariable Integer id) {
        Definir Definir = DefinirService.getDefinirById(id);
        if (Definir != null) {
            return ResponseEntity.ok(Definir);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Definir> createDefinir(@RequestBody Definir Definir) {
        Definir createdDefinir = DefinirService.createDefinir(Definir);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDefinir);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Definir> updateDefinir(@PathVariable Integer id, @RequestBody Definir Definir) {
        Definir updatedDefinir = DefinirService.updateDefinir(id, Definir);
        if (updatedDefinir != null) {
            return ResponseEntity.ok(updatedDefinir);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDefinir(@PathVariable Integer id) {
        boolean deleted = DefinirService.deleteDefinir(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
