package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.Definir;
import fr.ln.nextLine.Model.Repository.DefinirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefinirService {

    private final DefinirRepository DefinirRepository;

    @Autowired
    public DefinirService(DefinirRepository DefinirRepository) {
        this.DefinirRepository = DefinirRepository;
    }

    public List<Definir> getAllDefinirs() {
        return DefinirRepository.findAll();
    }

    public Definir getDefinirById(Integer id) {
        Optional<Definir> Definir = DefinirRepository.findById(id);
        return Definir.orElse(null);
    }

    public Definir createDefinir(Definir Definir) {
        return DefinirRepository.save(Definir);
    }

    public Definir updateDefinir(Integer id, Definir updatedDefinir) {
        return null;
    }

    public boolean deleteDefinir(Integer id) {
        Optional<Definir> DefinirOptional = DefinirRepository.findById(id);
        if (DefinirOptional.isPresent()) {
            DefinirRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
