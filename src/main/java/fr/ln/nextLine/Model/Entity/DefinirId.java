package fr.ln.nextLine.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DefinirId implements java.io.Serializable {
    private static final long serialVersionUID = -3595672144049316036L;
    @Column(name = "id_type_travaux", nullable = false)
    private Integer idTypeTravaux;

    @Column(name = "id_activite", nullable = false)
    private Integer idActivite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DefinirId entity = (DefinirId) o;
        return Objects.equals(this.idTypeTravaux, entity.idTypeTravaux) &&
                Objects.equals(this.idActivite, entity.idActivite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeTravaux, idActivite);
    }

}