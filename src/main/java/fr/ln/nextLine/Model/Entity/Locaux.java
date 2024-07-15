package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "locaux", schema = "public")
public class Locaux {
    @Id
    @ColumnDefault("nextval('locaux_id_locaux_seq'::regclass)")
    @Column(name = "id_locaux", nullable = false)
    private Integer id;

    @Column(name = "nom_locaux", nullable = false, length = 100)
    private String nomLocaux;

}