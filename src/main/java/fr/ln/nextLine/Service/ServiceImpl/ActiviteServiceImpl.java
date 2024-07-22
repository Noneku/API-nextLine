package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Service.ActiviteService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ActiviteServiceImpl implements ActiviteService {

    @Override
    public ResponseEntity<List<ActiviteDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ActiviteDTO> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ActiviteDTO> create(ActiviteDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<ActiviteDTO> update(Integer id, ActiviteDTO entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return null;
    }
}
