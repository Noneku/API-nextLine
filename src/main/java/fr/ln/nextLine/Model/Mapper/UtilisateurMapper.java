package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Role;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Repository.RoleRepository;
import fr.ln.nextLine.Service.RoleService;

import static fr.ln.nextLine.config.Security.SecurityConfig.passwordEncoder;

public class UtilisateurMapper {


    private UtilisateurMapper () {
    }

    public static UtilisateurDTO toDTO(Utilisateur utilisateur) {

        if (utilisateur == null) {
            return null;
        }

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        RoleDTO roleDTO = RoleMapper.toDTO(utilisateur.getRole());

        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setNomUtilisateur(utilisateur.getNomUtilisateur());
        utilisateurDTO.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
        utilisateurDTO.setUtilisateurLogin(utilisateur.getUtilisateurLogin());
        utilisateurDTO.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
        utilisateurDTO.setMdpUtilisateur(passwordEncoder().encode(utilisateur.getMdpUtilisateur()));
        utilisateurDTO.setDateCreation(utilisateur.getDateCreation());
        utilisateurDTO.setIsactive(utilisateur.getIsactive());
        utilisateurDTO.setNumeroSecuStagiaire(utilisateur.getNumeroSecuStagiaire());
        utilisateurDTO.setNumeroBeneficiaireStagiaire(utilisateur.getNumeroBeneficiaireStagiaire());
        utilisateurDTO.setDateNaissance(utilisateur.getDateNaissance());
        utilisateurDTO.setRoleDTO(roleDTO);

        return utilisateurDTO;
    }

    public static Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {

        if (utilisateurDTO == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        Role role = RoleMapper.toEntity(utilisateurDTO.getRoleDTO());

        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setNomUtilisateur(utilisateurDTO.getNomUtilisateur());
        utilisateur.setPrenomUtilisateur(utilisateurDTO.getPrenomUtilisateur());
        utilisateur.setUtilisateurLogin(utilisateurDTO.getUtilisateurLogin());
        utilisateur.setEmailUtilisateur(utilisateurDTO.getEmailUtilisateur());
        utilisateur.setMdpUtilisateur(passwordEncoder().encode(utilisateurDTO.getMdpUtilisateur()));
        utilisateur.setDateCreation(utilisateurDTO.getDateCreation());
        utilisateur.setIsactive(utilisateurDTO.getIsactive());
        utilisateur.setNumeroSecuStagiaire(utilisateurDTO.getNumeroSecuStagiaire());
        utilisateur.setNumeroBeneficiaireStagiaire(utilisateurDTO.getNumeroBeneficiaireStagiaire());
        utilisateur.setDateNaissance(utilisateurDTO.getDateNaissance());
        utilisateur.setRole(role);

        return utilisateur;
    }
}
