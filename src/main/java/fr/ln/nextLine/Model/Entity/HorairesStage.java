package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetTime;

@Getter
@Setter
@Entity
@Table(name = "horaires_stage", schema = "public")
public class HorairesStage {
    @Id
    @ColumnDefault("nextval('horaires_stage_id_horaires_stage_seq'::regclass)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horaires_stage", nullable = false)
    private Integer id;

    @Column(name = "heure_debut", nullable = false)
    private OffsetTime heureDebut;

    @Column(name = "heure_debut_pause_dej", nullable = false)
    private OffsetTime heureDebutPauseDej;

    @Column(name = "heure_fin_pause_dej", nullable = false)
    private OffsetTime heureFinPauseDej;

    @Column(name = "heure_fin", nullable = false)
    private OffsetTime heureFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_stage", nullable = false)
    private Stage stage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_jour", nullable = false)
    private Jour jour;

}