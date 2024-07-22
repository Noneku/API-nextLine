package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ActiviteService extends GeneriqueCrudService<ActiviteDTO> {

}
