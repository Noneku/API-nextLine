package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface AssuranceService extends GeneriqueCrudService<AssuranceDTO> {

    AssuranceDTO findOrCreateAssurance(String nomAssurance, String numeroSocietaire);

}
