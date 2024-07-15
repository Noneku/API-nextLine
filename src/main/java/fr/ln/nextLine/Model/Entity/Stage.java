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
    private Tuteur idTuteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entreprise", nullable = false)
    private Entreprise idEntreprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_session", nullable = false)
    private Session idSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lieu_realisation", nullable = false)
    private LieuRealisation idLieuRealisation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_activite", nullable = false)
    private Activite idActivite;

}