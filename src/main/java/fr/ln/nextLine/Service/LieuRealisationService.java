package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.LieuRealisation;
import fr.ln.nextLine.Model.Repository.LieuRealisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LieuRealisationService {

    private final LieuRealisationRepository lieuRealisationRepository;

    @Autowired
    public LieuRealisationService(LieuRealisationRepository lieuRealisationRepository) {
        this.lieuRealisationRepository = lieuRealisationRepository;
    }

    public List<LieuRealisation> getAllLieuxRealisations() {
        return lieuRealisationRepository.findAll();
    }

    public LieuRealisation getLieuRealisationById(Integer id) {
        Optional<LieuRealisation> lieuRealisation = lieuRealisationRepository.findById(id);
        return lieuRealisation.orElse(null);
    }

    public LieuRealisation createLieuRealisation(LieuRealisation lieuRealisation) {
        return lieuRealisationRepository.save(lieuRealisation);
    }

    public LieuRealisation updateLieuRealisation(Integer id, LieuRealisation updatedLieuRealisation) {
        return null;
    }

    public boolean deleteLieuRealisation(Integer id) {
        Optional<LieuRealisation> lieuRealisationOptional = lieuRealisationRepository.findById(id);
        if (lieuRealisationOptional.isPresent()) {
            lieuRealisationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
