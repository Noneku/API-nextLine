package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Model.Mapper.LienFormulaireMapper;
import fr.ln.nextLine.Model.Repository.LienFormulaireRepository;
import fr.ln.nextLine.Service.LienFormulaireService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LienFormulaireServiceImpl implements LienFormulaireService {

    private final LienFormulaireRepository lienFormulaireRepository;

    public LienFormulaireServiceImpl(LienFormulaireRepository lienFormulaireRepository) {

        this.lienFormulaireRepository = lienFormulaireRepository;
    }


    @Override
    public ResponseEntity<List<LienFormulaireDTO>> getAll() {

        List<LienFormulaireDTO> lienFormulaireDTOs = lienFormulaireRepository.findAll()
                .stream()
                .map(LienFormulaireMapper::toDTO)
                .toList();

        if (lienFormulaireDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lienFormulaireDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LienFormulaireDTO> getById(Integer id) {

        Optional<LienFormulaire> lienFormulaire = lienFormulaireRepository.findById(id);

        return lienFormulaire.map(
                        value -> new ResponseEntity<>(LienFormulaireMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<LienFormulaireDTO> create(LienFormulaireDTO lienFormulaireDTO) {

        LienFormulaire lienFormulaire = LienFormulaireMapper.toEntity(lienFormulaireDTO);
        LienFormulaire createdLienFormulaire = lienFormulaireRepository.save(lienFormulaire);
        LienFormulaireDTO createdVLienFormulaireDTO = LienFormulaireMapper.toDTO(createdLienFormulaire);

        return new ResponseEntity<>(createdVLienFormulaireDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LienFormulaireDTO> update(Integer id, LienFormulaireDTO lienFormulaireDTO) {

        if (lienFormulaireRepository.existsById(id)) {

            LienFormulaire lienFormulaire = LienFormulaireMapper.toEntity(lienFormulaireDTO);
            lienFormulaire.setId(id);
            LienFormulaire updatedLienFormulaire = lienFormulaireRepository.save(lienFormulaire);
            LienFormulaireDTO updatedLienFormulaireDTO = LienFormulaireMapper.toDTO(updatedLienFormulaire);

            return new ResponseEntity<>(updatedLienFormulaireDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<LienFormulaire> lienFormulaireOptional = lienFormulaireRepository.findById(id);

        if (lienFormulaireOptional.isPresent()) {

            lienFormulaireRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
