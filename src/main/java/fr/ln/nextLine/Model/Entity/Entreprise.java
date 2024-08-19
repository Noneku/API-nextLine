package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "entreprise", schema = "public")
public class Entreprise {
    @Id
    @ColumnDefault("nextval('entreprise_id_entreprise_seq'::regclass)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entreprise", nullable = false)
    private Integer id;

    @Column(name = "raison_sociale", nullable = false, length = 100)
    private String raisonSociale;

    @Column(name = "adresse_entreprise", nullable = false, length = 100)
    private String adresseEntreprise;

    @Column(name = "numero_siret", nullable = false, length = 14)
    private String numeroSiret;

    @Column(name = "telephone_entreprise", nullable = false, length = 10)
    private String telephoneEntreprise;

    @Column(name = "email_entreprise", nullable = false, length = 50)
    private String emailEntreprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ville", nullable = false)
    private Ville idVille;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_forme_juridique", nullable = false)
    private FormeJuridique idFormeJuridique;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dirigeant", nullable = false)
    private Dirigeant idDirigeant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_assurance", nullable = false)
    private Assurance idAssurance;

}