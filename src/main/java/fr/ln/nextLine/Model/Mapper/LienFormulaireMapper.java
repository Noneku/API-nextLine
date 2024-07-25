package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Model.Entity.LienFormulaire;

public class LienFormulaireMapper {

    private LienFormulaireMapper () {}

    public static LienFormulaireDTO toDTO(LienFormulaire lienFormulaire) {

        if (lienFormulaire == null) {
            return null;
        }
        LienFormulaireDTO lienFormulaireDTO = new LienFormulaireDTO();

        lienFormulaireDTO.setId(lienFormulaire.getId());
        lienFormulaireDTO.setTokenLien(lienFormulaire.getTokenLien());
        lienFormulaireDTO.setDateGeneration(lienFormulaire.getDateGeneration());
        lienFormulaireDTO.setStatut(lienFormulaire.getStatut());
        lienFormulaireDTO.setIdUtilisateur(lienFormulaire.getIdUtilisateur());

        return lienFormulaireDTO;
    }

    public static LienFormulaire toEntity(LienFormulaireDTO lienFormulaireDTO) {

        if (lienFormulaireDTO == null) {
            return null;
        }

        LienFormulaire lienFormulaire = new LienFormulaire();

        lienFormulaire.setId(lienFormulaireDTO.getId());
        lienFormulaire.setTokenLien(lienFormulaireDTO.getTokenLien());
        lienFormulaire.setDateGeneration(lienFormulaireDTO.getDateGeneration());
        lienFormulaire.setStatut(lienFormulaireDTO.getStatut());
        lienFormulaire.setIdUtilisateur(lienFormulaire.getIdUtilisateur());

        return lienFormulaire;
    }
}
