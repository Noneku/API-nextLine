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
public class ParticiperId implements java.io.Serializable {
    private static final long serialVersionUID = -1613473923436094262L;
    @Column(name = "id_session", nullable = false)
    private Integer idSession;

    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParticiperId entity = (ParticiperId) o;
        return Objects.equals(this.idUtilisateur, entity.idUtilisateur) &&
                Objects.equals(this.idSession, entity.idSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur, idSession);
    }

}