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

    private final DefinirRepository definirRepository;

    @Autowired
    public DefinirService(DefinirRepository definirRepository) {
        this.definirRepository = definirRepository;
    }

    public List<Definir> getAllDefinirs() {
        return definirRepository.findAll();
    }

    public Definir getDefinirById(Integer id) {
        Optional<Definir> definir = definirRepository.findById(id);
        return definir.orElse(null);
    }

    public Definir createDefinir(Definir definir) {
        return definirRepository.save(definir);
    }

    public Definir updateDefinir(Integer id, Definir updatedDefinir) {
        return null;
    }

    public boolean deleteDefinir(Integer id) {
        Optional<Definir> definirOptional = definirRepository.findById(id);
        if (definirOptional.isPresent()) {
            definirRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
