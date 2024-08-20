package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Model.Dto.DefinirDTO;
import fr.ln.nextLine.Model.Dto.TypeTravauxDangereuxDTO;
import fr.ln.nextLine.Model.Entity.Activite;
import fr.ln.nextLine.Model.Entity.Definir;
import fr.ln.nextLine.Model.Entity.TypeTravauxDangereux;


public class DefinirMapper {

    private DefinirMapper() {}

    public static DefinirDTO toDTO(Definir definir) {
        if (definir == null) {
            return null;
        }

        DefinirDTO definirDTO = new DefinirDTO();
        TypeTravauxDangereuxDTO typeTravauxDangereuxDTO = TypeTravauxDangereuxMapper.toDTO(definir.getTypeTravauxDangereux());
        ActiviteDTO activiteDTO = ActiviteMapper.toDTO(definir.getActivite());

        definirDTO.setTypeTravauxDangereuxDTO(typeTravauxDangereuxDTO);
        definirDTO.setActiviteDTO(activiteDTO);

        return definirDTO;
    }

    public static Definir toEntity(DefinirDTO definirDTO) {
        if (definirDTO == null) {
            return null;
        }

        Definir definir = new Definir();
        TypeTravauxDangereux typeTravauxDangereux = TypeTravauxDangereuxMapper.toEntity(definirDTO.getTypeTravauxDangereuxDTO());
        Activite activite = ActiviteMapper.toEntity(definirDTO.getActiviteDTO());

        definir.setTypeTravauxDangereux(typeTravauxDangereux);
        definir.setActivite(activite);

        return definir;
    }
}


