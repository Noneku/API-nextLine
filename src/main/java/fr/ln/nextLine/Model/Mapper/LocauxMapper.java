package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.LocauxDTO;
import fr.ln.nextLine.Model.Entity.Locaux;

public class LocauxMapper {

    private LocauxMapper () {}

    public static LocauxDTO toDTO(Locaux locaux) {

        if (locaux == null) {
            return null;
        }

        LocauxDTO locauxDTO = new LocauxDTO();

        locauxDTO.setId(locaux.getId());
        locauxDTO.setNomLocaux(locaux.getNomLocaux());

        return locauxDTO;
    }

    public static Locaux toEntity(LocauxDTO locauxDTO) {

        if (locauxDTO == null) {
            return null;
        }

        Locaux locaux = new Locaux();

        locaux.setId(locauxDTO.getId());
        locaux.setNomLocaux(locauxDTO.getNomLocaux());

        return locaux;
    }
}
