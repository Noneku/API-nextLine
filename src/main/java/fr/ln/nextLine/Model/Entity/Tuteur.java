package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tuteur", schema = "public")
public class Tuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tuteur_id_tuteur_seq'::regclass)")
    @Column(name = "id_tuteur", nullable = false)
    private Integer id;

    @Column(name = "nom_tuteur", nullable = false, length = 50)
    private String nomTuteur;

    @Column(name = "prenom_tuteur", nullable = false, length = 50)
    private String prenomTuteur;

    @Column(name = "email_tuteur", nullable = false, length = 100)
    private String emailTuteur;

    @Column(name = "tel_tuteur", nullable = false, length = 10)
    private String telTuteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entreprise", nullable = false)
    private Entreprise idEntreprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fonction", nullable = false)
    private Fonction idFonction;

}