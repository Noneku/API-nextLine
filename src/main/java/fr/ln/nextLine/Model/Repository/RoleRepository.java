package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
}
