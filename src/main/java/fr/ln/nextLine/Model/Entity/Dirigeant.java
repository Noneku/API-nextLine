package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "dirigeant", schema = "public")
public class Dirigeant {
    @Id
    @ColumnDefault("nextval('dirigeant_id_dirigeant_seq'::regclass)")
    @Column(name = "id_dirigeant", nullable = false)
    private Integer id;

    @Column(name = "nom_dirigeant", nullable = false, length = 50)
    private String nomDirigeant;

    @Column(name = "prenom_dirigeant", nullable = false, length = 50)
    private String prenomDirigeant;

    @Column(name = "email_dirigeant", length = 100)
    private String emailDirigeant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fonction", nullable = false)
    private Fonction idFonction;

}