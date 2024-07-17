package fr.ln.nextLine.Service;

import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;
import fr.ln.nextLine.Model.Repository.TypeTravauxDangereuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeTravauxDangereuxService {

    private final TypeTravauxDangereuxRepository typeTravauxDangereuxRepository;

    @Autowired
    public TypeTravauxDangereuxService(TypeTravauxDangereuxRepository typeTravauxDangereuxRepository) {
        this.typeTravauxDangereuxRepository = typeTravauxDangereuxRepository;
    }

    public List<TypeTravauxDangereux> getAllTypesTravauxDangereux() {
        return typeTravauxDangereuxRepository.findAll();
    }

    public TypeTravauxDangereux getTypeTravauxDangereuxById(Integer id) {
        Optional<TypeTravauxDangereux> typeTravauxDangereux = typeTravauxDangereuxRepository.findById(id);
        return typeTravauxDangereux.orElse(null);
    }

    public TypeTravauxDangereux createTypeTravauxDangereux(TypeTravauxDangereux typeTravauxDangereux) {
        return typeTravauxDangereuxRepository.save(typeTravauxDangereux);
    }

    public TypeTravauxDangereux updateTypeTravauxDangereux(Integer id, TypeTravauxDangereux updatedTypeTravauxDangereux) {
        return null;
    }

    public boolean deleteTypeTravauxDangereux(Integer id) {
        Optional<TypeTravauxDangereux> typeTravauxDangereuxOptional = typeTravauxDangereuxRepository.findById(id);
        if (typeTravauxDangereuxOptional.isPresent()) {
            typeTravauxDangereuxRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
