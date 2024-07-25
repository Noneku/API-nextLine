package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.ParticiperDTO;
import fr.ln.nextLine.Model.Entity.Participer;

public class ParticiperMapper {

    private ParticiperMapper () {}

    public static ParticiperDTO toDTO(Participer participer) {

        if (participer == null) {
            return null;
        }

        ParticiperDTO participerDTO = new ParticiperDTO();

        participerDTO.setIdSession(participer.getIdSession());
        participerDTO.setIdUtilisateur(participer.getIdUtilisateur());

        return participerDTO;
    }

    public static Participer toEntity(ParticiperDTO participerDTO) {

        if (participerDTO == null) {
            return null;
        }

        Participer participer = new Participer();

        participer.setIdSession(participerDTO.getIdSession());
        participer.setIdUtilisateur(participerDTO.getIdUtilisateur());

        return participer;
    }
}
