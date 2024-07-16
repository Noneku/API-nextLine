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
@Table(name = "formation", schema = "public")
public class Formation {
    @Id
    @ColumnDefault("nextval('formation_id_formation_seq'::regclass)")
    @Column(name = "id_formation", nullable = false)
    private Integer id;

    @Column(name = "nom_formation", nullable = false, length = 200)
    private String nomFormation;

    @Column(name = "code_grn", nullable = false, length = 10)
    private String codeGrn;

}