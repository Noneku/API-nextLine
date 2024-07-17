package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;
import fr.ln.nextLine.Service.TypeTravauxDangereuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types-travaux-dangereux")
public class TypeTravauxDangereuxController {

    private final TypeTravauxDangereuxService typeTravauxDangereuxService;

    @Autowired
    public TypeTravauxDangereuxController(TypeTravauxDangereuxService typeTravauxDangereuxService) {
        this.typeTravauxDangereuxService = typeTravauxDangereuxService;
    }

    @GetMapping
    public ResponseEntity<List<TypeTravauxDangereux>> getAllTypesTravauxDangereux() {
        List<TypeTravauxDangereux> typesTravauxDangereux = typeTravauxDangereuxService.getAllTypesTravauxDangereux();
        return ResponseEntity.ok(typesTravauxDangereux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTravauxDangereux> getTypeTravauxDangereuxById(@PathVariable Integer id) {
        TypeTravauxDangereux typeTravauxDangereux = typeTravauxDangereuxService.getTypeTravauxDangereuxById(id);
        if (typeTravauxDangereux != null) {
            return ResponseEntity.ok(typeTravauxDangereux);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TypeTravauxDangereux> createTypeTravauxDangereux(@RequestBody TypeTravauxDangereux typeTravauxDangereux) {
        TypeTravauxDangereux createdTypeTravauxDangereux = typeTravauxDangereuxService.createTypeTravauxDangereux(typeTravauxDangereux);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeTravauxDangereux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTravauxDangereux> updateTypeTravauxDangereux(@PathVariable Integer id, @RequestBody TypeTravauxDangereux typeTravauxDangereux) {
        TypeTravauxDangereux updatedTypeTravauxDangereux = typeTravauxDangereuxService.updateTypeTravauxDangereux(id, typeTravauxDangereux);
        if (updatedTypeTravauxDangereux != null) {
            return ResponseEntity.ok(updatedTypeTravauxDangereux);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeTravauxDangereux(@PathVariable Integer id) {
        boolean deleted = typeTravauxDangereuxService.deleteTypeTravauxDangereux(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
