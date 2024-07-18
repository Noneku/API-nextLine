package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.FrequenceDTO;
import fr.ln.nextLine.Model.Entity.Frequence;

public class FrequenceMapper {

    private FrequenceMapper() {}

    public static FrequenceDTO toDTO(Frequence frequence) {
        if (frequence == null) {
            return null;
        }
        FrequenceDTO frequenceDTO = new FrequenceDTO();

        frequenceDTO.setId(frequence.getId());
        frequenceDTO.setNomFrequence(frequence.getNomFrequence());

        return frequenceDTO;
    }

    public static Frequence toEntity(FrequenceDTO frequenceDTO) {
        if (frequenceDTO == null) {
            return null;
        }
        Frequence frequence = new Frequence();

        frequence.setId(frequenceDTO.getId());
        frequence.setNomFrequence(frequenceDTO.getNomFrequence());

        return frequence;
    }
}
