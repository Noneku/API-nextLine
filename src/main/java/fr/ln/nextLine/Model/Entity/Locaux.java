package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "locaux", schema = "public")
public class Locaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('locaux_id_locaux_seq'::regclass)")
    @Column(name = "id_locaux", nullable = false)
    private Integer id;

    @Column(name = "nom_locaux", nullable = false, length = 100)
    private String nomLocaux;

}