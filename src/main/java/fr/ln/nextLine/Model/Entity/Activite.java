package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "activites", schema = "public")
public class Activite {
    @Id
    @ColumnDefault("nextval('activites_id_activite_seq'::regclass)")
    @Column(name = "id_activite", nullable = false)
    private Integer id;

    @Column(name = "attestation_reglementaire", nullable = false)
    private Boolean attestationReglementaire = false;

    @Column(name = "nom_attestation", length = 100)
    private String nomAttestation;

    @Column(name = "visite_medicale", nullable = false)
    private Boolean visiteMedicale = false;

    @Column(name = "travaux_dangereux", nullable = false)
    private Boolean travauxDangereux = false;

    @Column(name = "date_declaration_derogee")
    private LocalDate dateDeclarationDerogee;
}