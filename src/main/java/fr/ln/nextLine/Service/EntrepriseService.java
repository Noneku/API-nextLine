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

    private final EntrepriseRepository EntrepriseRepository;

    @Autowired
    public EntrepriseService(EntrepriseRepository EntrepriseRepository) {
        this.EntrepriseRepository = EntrepriseRepository;
    }

    public List<Entreprise> getAllEntreprises() {
        return EntrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseById(Integer id) {
        Optional<Entreprise> Entreprise = EntrepriseRepository.findById(id);
        return Entreprise.orElse(null);
    }

    public Entreprise createEntreprise(Entreprise Entreprise) {
        return EntrepriseRepository.save(Entreprise);
    }

    public Entreprise updateEntreprise(Integer id, Entreprise updatedEntreprise) {
        return null;
    }

    public boolean deleteEntreprise(Integer id) {
        Optional<Entreprise> EntrepriseOptional = EntrepriseRepository.findById(id);
        if (EntrepriseOptional.isPresent()) {
            EntrepriseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
