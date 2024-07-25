package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.VilleDTO;
import fr.ln.nextLine.Model.Entity.Ville;
import org.springframework.stereotype.Component;

@Component
public class VilleMapper {

    private VilleMapper () {}

    public static VilleDTO toDTO(Ville ville) {

        if (ville == null) {
            return null;
        }

        VilleDTO villeDTO = new VilleDTO();

        villeDTO.setId(ville.getId());
        villeDTO.setNomVille(ville.getNomVille());
        villeDTO.setCodePostal(ville.getCodePostal());
        villeDTO.setCodeInsee(ville.getCodeInsee());

        return villeDTO;
    }

    public static Ville toEntity(VilleDTO villeDTO) {

        if (villeDTO == null) {
            return null;
        }

        Ville ville = new Ville();

        ville.setId(villeDTO.getId());
        ville.setNomVille(villeDTO.getNomVille());
        ville.setCodePostal(villeDTO.getCodePostal());
        ville.setCodeInsee(villeDTO.getCodeInsee());

        return ville;
    }
}
