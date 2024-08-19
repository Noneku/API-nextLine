package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "stage", schema = "public")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('stage_id_stage_seq'::regclass)")
    @Column(name = "id_stage", nullable = false)
    private Integer id;

    @Column(name = "modif_date_debut_stage")
    private LocalDate modifDateDebutStage;

    @Column(name = "objectif_stage", nullable = false, length = 2000)
    private String objectifStage;

    @Column(name = "date_validation_stage")
    private LocalDate dateValidationStage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tuteur", nullable = false)
    private Tuteur tuteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entreprise", nullable = false)
    private Entreprise entreprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_session", nullable = false)
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lieu_realisation", nullable = false)
    private LieuRealisation lieuRealisation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_activite", nullable = false)
    private Activite activite;

}