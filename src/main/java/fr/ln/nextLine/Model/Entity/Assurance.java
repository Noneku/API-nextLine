package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "assurance", schema = "public")
public class Assurance {
    @Id
    @ColumnDefault("nextval('assurance_id_assurance_seq'::regclass)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assurance", nullable = false)
    private Integer id;

    @Column(name = "nom_assurance", nullable = false, length = 50)
    private String nomAssurance;

    @Column(name = "numero_societaire", nullable = false, length = 20)
    private String numeroSocietaire;

}