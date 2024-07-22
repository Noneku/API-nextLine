package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.DefinirDTO;
import fr.ln.nextLine.Model.Dto.DirigeantDTO;
import fr.ln.nextLine.Model.Entity.Dirigeant;
import fr.ln.nextLine.Model.Repository.DirigeantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface DirigeantService extends GeneriqueCrudService<DirigeantDTO> {

}
