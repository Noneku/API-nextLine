package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "utilisateur", schema = "public")
public class Utilisateur {
    @Id
    @ColumnDefault("nextval('utilisateur_id_utilisateur_seq'::regclass)")
    @Column(name = "id_utilisateur", nullable = false)
    private Integer id;

    @Column(name = "nom_utilisateur", nullable = false, length = 50)
    private String nomUtilisateur;

    @Column(name = "prenom_utilisateur", nullable = false, length = 50)
    private String prenomUtilisateur;

    @Column(name = "utilisateur_login", nullable = false, length = 50)
    private String utilisateurLogin;

    @Column(name = "email_utilisateur", nullable = false, length = 100)
    private String emailUtilisateur;

    @Column(name = "mdp_utilisateur", nullable = false, length = 250)
    private String mdpUtilisateur;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "isactive", nullable = false)
    private Boolean isactive = false;

    @Column(name = "numero_secu_stagiaire", length = 15)
    private String numeroSecuStagiaire;

    @Column(name = "numero_beneficiaire_stagiaire", length = 10)
    private String numeroBeneficiaireStagiaire;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_role", nullable = false)
    private Role idRole;

}