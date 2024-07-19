package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.TypeTravauxDangereuxDTO;
import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;

public class TypeTravauxDangereuxMapper {

    private TypeTravauxDangereuxMapper () {}

    public static TypeTravauxDangereuxDTO toDTO(TypeTravauxDangereux typeTravauxDangereux) {

        if (typeTravauxDangereux == null) {
            return null;
        }

        TypeTravauxDangereuxDTO typeTravauxDangereuxDTO = new TypeTravauxDangereuxDTO();

        typeTravauxDangereuxDTO.setId(typeTravauxDangereux.getId());
        typeTravauxDangereuxDTO.setLibTypeTravaux(typeTravauxDangereux.getLibTypeTravaux());

        return typeTravauxDangereuxDTO;
    }

    public static TypeTravauxDangereux toEntity(TypeTravauxDangereuxDTO typeTravauxDangereuxDTO) {

        if (typeTravauxDangereuxDTO == null) {
            return null;
        }

        TypeTravauxDangereux typeTravauxDangereux = new TypeTravauxDangereux();

        typeTravauxDangereuxDTO.setId(typeTravauxDangereuxDTO.getId());
        typeTravauxDangereuxDTO.setLibTypeTravaux(typeTravauxDangereuxDTO.getLibTypeTravaux());

        return typeTravauxDangereux;
    }
}
