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
@Table(name = "jour", schema = "public")
public class Jour {
    @Id
    @ColumnDefault("nextval('jour_id_jour_seq'::regclass)")
    @Column(name = "id_jour", nullable = false)
    private Integer id;

    @Column(name = "nom_jour", nullable = false, length = 20)
    private String nomJour;

}