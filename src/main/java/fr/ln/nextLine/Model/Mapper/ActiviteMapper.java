package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.ActiviteDTO;
import fr.ln.nextLine.Model.Entity.Activite;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ActiviteMapper {

    public static ActiviteDTO toDTO(Activite activite) {
        if (activite == null) {
            return null;
        }
        ActiviteDTO activiteDTO = new ActiviteDTO();

        activiteDTO.setId(activite.getId());
        activiteDTO.setAttestationReglementaire(activite.getAttestationReglementaire());
        activiteDTO.setNomAttestation(activite.getNomAttestation());
        activiteDTO.setVisiteMedicale(activite.getVisiteMedicale());
        activiteDTO.setTravauxDangereux(activite.getTravauxDangereux());
        activiteDTO.setDateDeclarationDerogee(activite.getDateDeclarationDerogee());

        return activiteDTO;
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
