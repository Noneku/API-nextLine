package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "document", schema = "public")
public class Document {
    @Id
    @ColumnDefault("nextval('document_id_document_seq'::regclass)")
    @Column(name = "id_document", nullable = false)
    private Integer id;

    @Column(name = "nom_pdf", nullable = false, length = 150)
    private String nomPdf;

    @Column(name = "date_generation_document", nullable = false)
    private LocalDate dateGenerationDocument;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_stage", nullable = false)
    private Stage idStage;

}