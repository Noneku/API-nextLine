package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface LienFormulaireService extends GeneriqueCrudService <LienFormulaireDTO> {

}
