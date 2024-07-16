package fr.ln.nextLine.Service;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ln.nextLine.Model.Entity.Document;
import fr.ln.nextLine.Model.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentService {

    private final DocumentRepository DocumentRepository;

    @Autowired
    public DocumentService(DocumentRepository DocumentRepository) {
        this.DocumentRepository = DocumentRepository;
    }

    public List<Document> getAllDocuments() {
        return DocumentRepository.findAll();
    }

    public Document getDocumentById(Integer id) {
        Optional<Document> Document = DocumentRepository.findById(id);
        return Document.orElse(null);
    }

    public Document createDocument(Document Document) {
        return DocumentRepository.save(Document);
    }

    public Document updateDocument(Integer id, Document updatedDocument) {
        return null;
    }

    public boolean deleteDocument(Integer id) {
        Optional<Document> DocumentOptional = DocumentRepository.findById(id);
        if (DocumentOptional.isPresent()) {
            DocumentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
