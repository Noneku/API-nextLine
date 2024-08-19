package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "type_travaux_dangereux", schema = "public")
public class TypeTravauxDangereux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('type_travaux_dangereux_id_type_travaux_seq'::regclass)")
    @Column(name = "id_type_travaux", nullable = false)
    private Integer id;

    @Column(name = "lib_type_travaux", nullable = false, length = 200)
    private String libTypeTravaux;

}