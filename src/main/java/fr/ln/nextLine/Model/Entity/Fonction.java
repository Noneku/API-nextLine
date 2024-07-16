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
@Table(name = "fonction", schema = "public")
public class Fonction {
    @Id
    @ColumnDefault("nextval('fonction_id_fonction_seq'::regclass)")
    @Column(name = "id_fonction", nullable = false)
    private Integer id;

    @Column(name = "nom_fonction", nullable = false, length = 50)
    private String nomFonction;

}