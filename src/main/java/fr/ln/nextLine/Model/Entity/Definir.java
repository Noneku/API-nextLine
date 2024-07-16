package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "definir", schema = "public")
public class Definir {
    @EmbeddedId
    private DefinirId id;

    @MapsId("idTypeTravaux")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_travaux", nullable = false)
    private TypeTravauxDangereux idTypeTravaux;

    @MapsId("idActivite")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_activite", nullable = false)
    private Activite idActivite;

}