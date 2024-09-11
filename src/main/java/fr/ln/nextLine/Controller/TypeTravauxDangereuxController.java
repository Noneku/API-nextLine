package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.TypeTravauxDangereuxDTO;
import fr.ln.nextLine.Service.TypeTravauxDangereuxService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<TypeTravauxDangereuxDTO>> getAllTypesTravauxDangereux() {

        return typeTravauxDangereuxService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTravauxDangereuxDTO> getTypeTravauxDangereuxById(@PathVariable Integer id) {

        return typeTravauxDangereuxService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createTypeTravauxDangereux(@RequestBody TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        return typeTravauxDangereuxService.create(typeTravauxDangereuxDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTypeTravauxDangereux(@PathVariable Integer id, @RequestBody TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        return typeTravauxDangereuxService.update(id, typeTravauxDangereuxDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTypeTravauxDangereux(@PathVariable Integer id) {

        return typeTravauxDangereuxService.delete(id);

    }
}
