package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.JourDTO;
import fr.ln.nextLine.Model.Entity.Jour;

public class JourMapper {

    private JourMapper() {}

    public static JourDTO toDTO(Jour jour) {
        if (jour == null) {
            return null;
        }
        JourDTO jourDTO = new JourDTO();

        jourDTO.setId(jour.getId());
        jourDTO.setNomJour(jour.getNomJour());

        return jourDTO;
    }

    public static Jour toEntity(JourDTO jourDTO) {
        if (jourDTO == null) {
            return null;
        }
        Jour jour = new Jour();

        jour.setId(jourDTO.getId());
        jour.setNomJour(jourDTO.getNomJour());

        return jour;
    }
}
