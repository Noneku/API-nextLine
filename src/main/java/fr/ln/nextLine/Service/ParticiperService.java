package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Participer;
import fr.ln.nextLine.Model.Repository.ParticiperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParticiperService {

    private final ParticiperRepository participerRepository;

    @Autowired
    public ParticiperService(ParticiperRepository participerRepository) {
        this.participerRepository = participerRepository;
    }

    public List<Participer> getAllParticiper() {
        return participerRepository.findAll();
    }

    public Participer getParticiperById(Integer id) {
        Optional<Participer> participer = participerRepository.findById(id);
        return participer.orElse(null);
    }

    public Participer createParticiper(Participer participer) {
        return participerRepository.save(participer);
    }

    public Participer updateParticiper(Integer id, Participer updatedParticiper) {
        return null;
    }

    public boolean deleteParticiper(Integer id) {
        Optional<Participer> participerOptional = participerRepository.findById(id);
        if (participerOptional.isPresent()) {
            participerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
