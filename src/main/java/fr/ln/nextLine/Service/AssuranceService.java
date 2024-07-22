package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.AssuranceDTO;
import fr.ln.nextLine.Model.Entity.Assurance;
import fr.ln.nextLine.Model.Repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface AssuranceService extends GeneriqueCrudService<AssuranceDTO> {

}
