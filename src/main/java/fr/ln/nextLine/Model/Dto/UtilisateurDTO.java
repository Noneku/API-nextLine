package fr.ln.nextLine.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilisateurDTO {

    private Integer id;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String utilisateurLogin;
    private String emailUtilisateur;
    private String mdpUtilisateur;
    private LocalDate dateCreation;
    private Boolean isactive;
    private String numeroSecuStagiaire;
    private String numeroBeneficiaireStagiaire;
    private LocalDate dateNaissance;
    private RoleDTO idRole;
}
