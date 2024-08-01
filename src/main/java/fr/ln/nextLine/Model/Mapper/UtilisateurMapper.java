package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Role;
import fr.ln.nextLine.Model.Entity.Utilisateur;

public class UtilisateurMapper {

    private UtilisateurMapper () {}

    public static UtilisateurDTO toDTO(Utilisateur utilisateur) {

        if (utilisateur == null) {
            return null;
        }

        RoleDTO roleDTO = RoleMapper.toDTO(utilisateur.getIdRole());

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setNomUtilisateur(utilisateur.getNomUtilisateur());
        utilisateurDTO.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
        utilisateurDTO.setUtilisateurLogin(utilisateur.getUtilisateurLogin());
        utilisateurDTO.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
        utilisateurDTO.setMdpUtilisateur(utilisateur.getMdpUtilisateur());
        utilisateurDTO.setDateCreation(utilisateur.getDateCreation());
        utilisateurDTO.setIsactive(utilisateur.getIsactive());
        utilisateurDTO.setNumeroSecuStagiaire(utilisateur.getNumeroSecuStagiaire());
        utilisateurDTO.setNumeroBeneficiaireStagiaire(utilisateur.getNumeroBeneficiaireStagiaire());
        utilisateurDTO.setDateNaissance(utilisateur.getDateNaissance());
        utilisateurDTO.setIdRole(roleDTO);

        return utilisateurDTO;
    }

    public static Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {

        if (utilisateurDTO == null) {
            return null;
        }

        Role role = RoleMapper.toEntity(utilisateurDTO.getIdRole());

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setNomUtilisateur(utilisateurDTO.getNomUtilisateur());
        utilisateur.setPrenomUtilisateur(utilisateurDTO.getPrenomUtilisateur());
        utilisateur.setUtilisateurLogin(utilisateurDTO.getUtilisateurLogin());
        utilisateur.setEmailUtilisateur(utilisateurDTO.getEmailUtilisateur());
        utilisateur.setMdpUtilisateur(utilisateurDTO.getMdpUtilisateur());
        utilisateur.setDateCreation(utilisateurDTO.getDateCreation());
        utilisateur.setIsactive(utilisateurDTO.getIsactive());
        utilisateur.setNumeroSecuStagiaire(utilisateurDTO.getNumeroSecuStagiaire());
        utilisateur.setNumeroBeneficiaireStagiaire(utilisateurDTO.getNumeroBeneficiaireStagiaire());
        utilisateur.setDateNaissance(utilisateurDTO.getDateNaissance());
        utilisateur.setIdRole(role);

        return utilisateur;
    }
}
