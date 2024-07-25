package fr.ln.nextLine.Model.Dto;

import fr.ln.nextLine.Model.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

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
    private Role idRole;
}
