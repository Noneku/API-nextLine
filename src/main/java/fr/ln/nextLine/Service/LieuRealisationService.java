package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.LieuRealisationDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface LieuRealisationService extends GeneriqueCrudService<LieuRealisationDTO> {


}
