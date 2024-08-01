package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "forme_juridique", schema = "public")
public class FormeJuridique {
    @Id
    @ColumnDefault("nextval('forme_juridique_id_forme_juridique_seq'::regclass)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forme_juridique", nullable = false)
    private Integer id;

    @Column(name = "nom_forme_juridique", nullable = false, length = 10)
    private String nomFormeJuridique;

}