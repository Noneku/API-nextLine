package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "role", schema = "public")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('role_id_role_seq'::regclass)")
    @Column(name = "id_role", nullable = false)
    private Integer id;

    @Column(name = "nom_role", nullable = false, length = 20)
    private String nomRole;

}