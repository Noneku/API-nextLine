package fr.ln.nextLine.Service;

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

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(Integer id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.orElse(null);
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public Document updateDocument(Integer id, Document updatedDocument) {
        return null;
    }

    public boolean deleteDocument(Integer id) {
        Optional<Document> documentOptional = documentRepository.findById(id);
        if (documentOptional.isPresent()) {
            documentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
