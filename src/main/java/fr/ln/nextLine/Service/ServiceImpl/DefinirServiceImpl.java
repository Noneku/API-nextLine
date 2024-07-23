package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.DefinirDTO;
import fr.ln.nextLine.Model.Entity.Definir;
import fr.ln.nextLine.Model.Mapper.DefinirMapper;
import fr.ln.nextLine.Model.Repository.DefinirRepository;
import fr.ln.nextLine.Service.DefinirService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefinirServiceImpl implements DefinirService {

    private final DefinirRepository definirRepository;

    public DefinirServiceImpl(DefinirRepository definirRepository) {

        this.definirRepository = definirRepository;
    }

    @Override
    public ResponseEntity<List<DefinirDTO>> getAll() {
        {

            List<DefinirDTO> definirDTOs = definirRepository.findAll()
                    .stream()
                    .map(DefinirMapper::toDTO)
                    .toList();

            if (definirDTOs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(definirDTOs, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<DefinirDTO> getById(Integer id) {
        {

            Optional<Definir> definir = definirRepository.findById(id);

            return definir.map(
                            value -> new ResponseEntity<>(DefinirMapper.toDTO(value), HttpStatus.FOUND))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity<DefinirDTO> create(DefinirDTO definirDTO) {
        {

            Definir definir = DefinirMapper.toEntity(definirDTO);
            Definir createdDefinir = definirRepository.save(definir);
            DefinirDTO createdVDefinirDTO = DefinirMapper.toDTO(createdDefinir);

            return new ResponseEntity<>(createdVDefinirDTO, HttpStatus.CREATED);
        }
    }
    //Aucune utilisation particulière

    @Override
    public ResponseEntity<DefinirDTO> update(Integer id, DefinirDTO definirDTO) {
        {
            /*
            if (definirRepository.existsById(id)) {

                Definir definir = DefinirMapper.toEntity(definirDTO);
                definir.setId(id);
                Definir updatedLienDefinir = definirRepository.save(definir);
                DefinirDTO updatedDefinirDTO = DefinirMapper.toDTO(updatedLienFormulaire);

                return new ResponseEntity<>(updatedDefinirDTO, HttpStatus.OK);

            } else {

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

             */
        }

             return null;
    }
    @Override
    public ResponseEntity<Void> delete(Integer id) {
        {

            Optional<Definir> definirOptional = definirRepository.findById(id);

            if (definirOptional.isPresent()) {

                definirRepository.deleteById(id);

                return new ResponseEntity<>(HttpStatus.OK);

            } else {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }
}
