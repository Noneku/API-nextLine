package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.LienFormulaireDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.LienFormulaire;
import fr.ln.nextLine.Model.Entity.Utilisateur;

public class LienFormulaireMapper {

    private LienFormulaireMapper () {}

    public static LienFormulaireDTO toDTO(LienFormulaire lienFormulaire) {

        if (lienFormulaire == null) {
            return null;
        }

        UtilisateurDTO utilisateurDTO = UtilisateurMapper.toDTO(lienFormulaire.getIdUtilisateur());

        LienFormulaireDTO lienFormulaireDTO = new LienFormulaireDTO();

        lienFormulaireDTO.setId(lienFormulaire.getId());
        lienFormulaireDTO.setTokenLien(lienFormulaire.getTokenLien());
        lienFormulaireDTO.setDateGeneration(lienFormulaire.getDateGeneration());
        lienFormulaireDTO.setStatut(lienFormulaire.getStatut());
        lienFormulaireDTO.setIdUtilisateur(utilisateurDTO);

        return lienFormulaireDTO;
    }

    public static LienFormulaire toEntity(LienFormulaireDTO lienFormulaireDTO) {

        if (lienFormulaireDTO == null) {
            return null;
        }

        Utilisateur utilisateur = UtilisateurMapper.toEntity(lienFormulaireDTO.getIdUtilisateur());

        LienFormulaire lienFormulaire = new LienFormulaire();

        lienFormulaire.setId(lienFormulaireDTO.getId());
        lienFormulaire.setTokenLien(lienFormulaireDTO.getTokenLien());
        lienFormulaire.setDateGeneration(lienFormulaireDTO.getDateGeneration());
        lienFormulaire.setStatut(lienFormulaireDTO.getStatut());
        lienFormulaire.setIdUtilisateur(utilisateur);

        return lienFormulaire;
    }
}
