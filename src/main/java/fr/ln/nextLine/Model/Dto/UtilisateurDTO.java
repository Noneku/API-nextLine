package fr.ln.nextLine.Model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String emailUtilisateur;
    private LocalDate dateCreation;
    private Boolean isactive;
    private String numeroBeneficiaireStagiaire;
    private LocalDate dateNaissance;
    private RoleDTO roleDTO;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String utilisateurLogin;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mdpUtilisateur;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroSecuStagiaire;

}
