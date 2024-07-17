package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Entreprise;
import fr.ln.nextLine.Model.Repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseById(Integer id) {
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return entreprise.orElse(null);
    }

    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise updateEntreprise(Integer id, Entreprise updatedEntreprise) {
        return null;
    }

    public boolean deleteEntreprise(Integer id) {
        Optional<Entreprise> entrepriseOptional = entrepriseRepository.findById(id);
        if (entrepriseOptional.isPresent()) {
            entrepriseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
