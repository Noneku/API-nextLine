package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.TypeTravauxDangereuxDTO;
import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;
import fr.ln.nextLine.Model.Mapper.TypeTravauxDangereuxMapper;
import fr.ln.nextLine.Model.Repository.TypeTravauxDangereuxRepository;
import fr.ln.nextLine.Service.TypeTravauxDangereuxService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeTravauxDangereuxServiceImpl implements TypeTravauxDangereuxService {

    private final TypeTravauxDangereuxRepository typeTravauxDangereuxRepository;

    public TypeTravauxDangereuxServiceImpl(TypeTravauxDangereuxRepository typeTravauxDangereuxRepository) {

        this.typeTravauxDangereuxRepository = typeTravauxDangereuxRepository;
    }


    @Override
    public ResponseEntity<List<TypeTravauxDangereuxDTO>> getAll() {

        List<TypeTravauxDangereuxDTO> typeTravauxDangereuxDTOs = typeTravauxDangereuxRepository.findAll()
                .stream()
                .map(TypeTravauxDangereuxMapper::toDTO)
                .toList();

        if (typeTravauxDangereuxDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(typeTravauxDangereuxDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TypeTravauxDangereuxDTO> getById(Integer id) {

        Optional<TypeTravauxDangereux> typeTravauxDangereux = typeTravauxDangereuxRepository.findById(id);

        return typeTravauxDangereux.map(
                        value -> new ResponseEntity<>(TypeTravauxDangereuxMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<TypeTravauxDangereuxDTO> create(TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        TypeTravauxDangereux typeTravauxDangereux = TypeTravauxDangereuxMapper.toEntity(typeTravauxDangereuxDTO);
        TypeTravauxDangereux createdTypeTravauxDangereux = typeTravauxDangereuxRepository.save(typeTravauxDangereux);
        TypeTravauxDangereuxDTO createdTypeTravauxDangereuxDTO = TypeTravauxDangereuxMapper.toDTO(createdTypeTravauxDangereux);

        return new ResponseEntity<>(createdTypeTravauxDangereuxDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TypeTravauxDangereuxDTO> update(Integer id, TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        if (typeTravauxDangereuxRepository.existsById(id)) {

            TypeTravauxDangereux typeTravauxDangereux = TypeTravauxDangereuxMapper.toEntity(typeTravauxDangereuxDTO);
            typeTravauxDangereux.setId(id);
            TypeTravauxDangereux updatedTypeTravauxDangereux = typeTravauxDangereuxRepository.save(typeTravauxDangereux);
            TypeTravauxDangereuxDTO updatedTypeTravauxDangereuxDTO = TypeTravauxDangereuxMapper.toDTO(updatedTypeTravauxDangereux);

            return new ResponseEntity<>(updatedTypeTravauxDangereuxDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<TypeTravauxDangereux> typeTravauxDangereuxOptional = typeTravauxDangereuxRepository.findById(id);

        if (typeTravauxDangereuxOptional.isPresent()) {

            typeTravauxDangereuxRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
