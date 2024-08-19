package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "fonction", schema = "public")
public class Fonction {
    @Id
    @ColumnDefault("nextval('fonction_id_fonction_seq'::regclass)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fonction", nullable = false)
    private Integer id;

    @Column(name = "nom_fonction", nullable = false, length = 50)
    private String nomFonction;

}