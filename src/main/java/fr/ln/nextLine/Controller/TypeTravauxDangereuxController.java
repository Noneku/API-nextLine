package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.TypeTravauxDangereuxDTO;
import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;
import fr.ln.nextLine.Model.Mapper.TypeTravauxDangereuxMapper;
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
    public ResponseEntity<List<TypeTravauxDangereuxDTO>> getAllTypesTravauxDangereux() {

        List<TypeTravauxDangereux> typeTravauxDangereux = typeTravauxDangereuxService.getAllTypesTravauxDangereux();
        List<TypeTravauxDangereuxDTO> typeTravauxDangereuxDTOS = typeTravauxDangereux
                .stream()
                .map(TypeTravauxDangereuxMapper::toDTO)
                .toList();

        return new ResponseEntity<>(typeTravauxDangereuxDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTravauxDangereuxDTO> getTypeTravauxDangereuxById(@PathVariable Integer id) {

        TypeTravauxDangereux typeTravauxDangereux = typeTravauxDangereuxService.getTypeTravauxDangereuxById(id);

        return new ResponseEntity<>(TypeTravauxDangereuxMapper.toDTO(typeTravauxDangereux), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeTravauxDangereuxDTO> createTypeTravauxDangereux(@RequestBody TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        TypeTravauxDangereux typeTravauxDangereux = TypeTravauxDangereuxMapper.toEntity(typeTravauxDangereuxDTO);
        TypeTravauxDangereux createdTypeTravauxDangereux = typeTravauxDangereuxService.createTypeTravauxDangereux(typeTravauxDangereux);
        TypeTravauxDangereuxDTO createdTypeTravauxDangereuxDTO = TypeTravauxDangereuxMapper.toDTO(createdTypeTravauxDangereux);

        return new ResponseEntity<>(createdTypeTravauxDangereuxDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTravauxDangereuxDTO> updateTypeTravauxDangereux(@PathVariable Integer id, @RequestBody TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        TypeTravauxDangereux typeTravauxDangereux = TypeTravauxDangereuxMapper.toEntity(typeTravauxDangereuxDTO);
        TypeTravauxDangereux updatedTypeTravauxDangereux = typeTravauxDangereuxService.updateTypeTravauxDangereux(id, typeTravauxDangereux);

        if (updatedTypeTravauxDangereux != null) {
            TypeTravauxDangereuxDTO updatedTypeTravauxDangereuxDTO = TypeTravauxDangereuxMapper.toDTO(updatedTypeTravauxDangereux);
            return new ResponseEntity<>(updatedTypeTravauxDangereuxDTO, HttpStatus.OK);
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
