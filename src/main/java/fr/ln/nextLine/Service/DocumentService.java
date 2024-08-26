package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.DocumentDTO;
import fr.ln.nextLine.Model.Dto.FormulaireDTO;
import org.springframework.stereotype.Service;

@Service
public interface DocumentService extends GeneriqueCrudService <DocumentDTO> {

    void generatePDF(FormulaireDTO formulaireDTO, String filePath);
}
