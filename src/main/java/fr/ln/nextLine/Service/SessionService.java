package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.SessionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface SessionService extends GeneriqueCrudService <SessionDTO> {

    Integer calculNombreSemaines(LocalDate dateDebutStage, LocalDate dateFinStage);

}
