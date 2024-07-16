package fr.ln.nextLine.Model.Repository;

import fr.ln.nextLine.Model.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
