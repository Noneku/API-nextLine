package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "lieu_realisation", schema = "public")
public class LieuRealisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('lieu_realisation_id_lieu_realisation_seq'::regclass)")
    @Column(name = "id_lieu_realisation", nullable = false)
    private Integer id;

    @Column(name = "deplacements", nullable = false)
    private Boolean deplacements = false;

    @Column(name = "autres_locaux", length = 100)
    private String autresLocaux;

    @Column(name = "autre_frequence", length = 100)
    private String autreFrequence;

    @Column(name = "autre_mode_deplacement", length = 100)
    private String autreModeDeplacement;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_locaux", nullable = false)
    private Locaux idLocaux;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_frequence", nullable = false)
    private Frequence idFrequence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_mode_deplacement", nullable = false)
    private ModesDeplacement idModeDeplacement;

}