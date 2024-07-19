package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.DefinirDTO;
import fr.ln.nextLine.Model.Entity.Definir;


public class DefinirMapper {

    private DefinirMapper() {}

    public static DefinirDTO toDTO(Definir definir) {
        if (definir == null) {
            return null;
        }
        DefinirDTO definirDTO = new DefinirDTO();

        definirDTO.setIdTypeTravaux(definir.getIdTypeTravaux());
        definirDTO.setIdActivite(definir.getIdActivite());

        return definirDTO;
    }

    public static Definir toEntity(DefinirDTO definirDTO) {
        if (definirDTO == null) {
            return null;
        }
        Definir definir = new Definir();

        definir.setIdTypeTravaux(definirDTO.getIdTypeTravaux());
        definir.setIdActivite(definirDTO.getIdActivite());

        return definir;
    }
}


