package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Model.Entity.Activite;

public class ActiviteMapper {

    private ActiviteMapper () {}

    public static ActiviteDTO toDTO(Activite activite) {
        if (activite == null) {
            return null;
        }
        ActiviteDTO activiteDto = new ActiviteDTO();

        activiteDto.setId(activite.getId());
        activiteDto.setAttestationReglementaire(activite.getAttestationReglementaire());
        activiteDto.setNomAttestation(activite.getNomAttestation());
        activiteDto.setVisiteMedicale(activite.getVisiteMedicale());
        activiteDto.setTravauxDangereux(activite.getTravauxDangereux());
        activiteDto.setDateDeclarationDerogee(activite.getDateDeclarationDerogee());

        return activiteDto;
    }

    public static Activite toEntity(ActiviteDTO activiteDto) {

        if (activiteDto == null) {
            return null;
        }
        Activite activite = new Activite();

        activite.setId(activiteDto.getId());
        activite.setAttestationReglementaire(activiteDto.getAttestationReglementaire());
        activite.setNomAttestation(activiteDto.getNomAttestation());
        activite.setVisiteMedicale(activiteDto.getVisiteMedicale());
        activite.setTravauxDangereux(activiteDto.getTravauxDangereux());
        activite.setDateDeclarationDerogee(activiteDto.getDateDeclarationDerogee());

        return activite;
    }
}
