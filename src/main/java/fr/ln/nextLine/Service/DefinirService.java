package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Dto.DefinirDTO;
import fr.ln.nextLine.Model.Entity.Definir;
import fr.ln.nextLine.Model.Repository.DefinirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface DefinirService extends GeneriqueCrudService<DefinirDTO> {

}
