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
@Table(name = "frequence", schema = "public")
public class Frequence {
    @Id
    @ColumnDefault("nextval('frequence_id_frequence_seq'::regclass)")
    @Column(name = "id_frequence", nullable = false)
    private Integer id;

    @Column(name = "nom_frequence", nullable = false, length = 100)
    private String nomFrequence;

}