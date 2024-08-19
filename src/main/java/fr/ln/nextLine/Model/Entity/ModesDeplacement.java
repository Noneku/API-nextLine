package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "modes_deplacements", schema = "public")
public class ModesDeplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('modes_deplacements_id_mode_deplacement_seq'::regclass)")
    @Column(name = "id_mode_deplacement", nullable = false)
    private Integer id;

    @Column(name = "nom_deplacement", nullable = false, length = 150)
    private String nomDeplacement;

}