package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Locaux;
import fr.ln.nextLine.Model.Repository.LocauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocauxService {

    private final LocauxRepository locauxRepository;

    @Autowired
    public LocauxService(LocauxRepository locauxRepository) {
        this.locauxRepository = locauxRepository;
    }

    public List<Locaux> getAllLocaux() {
        return locauxRepository.findAll();
    }

    public Locaux getLocalById(Integer id) {
        Optional<Locaux> locaux = locauxRepository.findById(id);
        return locaux.orElse(null);
    }

    public Locaux createLocal(Locaux locaux) {
        return locauxRepository.save(locaux);
    }

    public Locaux updateLocal(Integer id, Locaux updatedLocal) {
        return null;
    }

    public boolean deleteLocal(Integer id) {
        Optional<Locaux> locauxOptional = locauxRepository.findById(id);
        if (locauxOptional.isPresent()) {
            locauxRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
