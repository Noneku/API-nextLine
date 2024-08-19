package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "ville", schema = "public")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ville", nullable = false)
    private Integer id;

    @Column(name = "nom_ville", nullable = false, length = 50)
    private String nomVille;

    @Column(name = "code_postal", nullable = false, length = 5)
    private String codePostal;

    @Column(name = "code_insee", nullable = false, length = 5)
    private String codeInsee;

}