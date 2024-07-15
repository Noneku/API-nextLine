package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "lien_formulaire", schema = "public")
public class LienFormulaire {
    @Id
    @ColumnDefault("nextval('lien_formulaire_id_lien_seq'::regclass)")
    @Column(name = "id_lien", nullable = false)
    private Integer id;

    @Column(name = "token_lien", nullable = false, length = 200)
    private String tokenLien;

    @Column(name = "date_generation", nullable = false)
    private LocalDate dateGeneration;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

}