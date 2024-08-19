package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "session", schema = "public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('session_id_session_seq'::regclass)")
    @Column(name = "id_session", nullable = false)
    private Integer id;

    @Column(name = "date_debut_session", nullable = false)
    private LocalDate dateDebutSession;

    @Column(name = "date_fin_session", nullable = false)
    private LocalDate dateFinSession;

    @Column(name = "numero_offre", nullable = false, length = 10)
    private String numeroOffre;

    @Column(name = "date_debut_stage", nullable = false)
    private LocalDate dateDebutStage;

    @Column(name = "date_fin_stage", nullable = false)
    private LocalDate dateFinStage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

}