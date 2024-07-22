package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.LocauxDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface LocauxService extends GeneriqueCrudService <LocauxDTO> {

}
