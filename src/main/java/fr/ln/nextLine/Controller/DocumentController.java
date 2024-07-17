package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Entity.Document;
import fr.ln.nextLine.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService DocumentService;

    @Autowired
    public DocumentController(DocumentService DocumentService) {
        this.DocumentService = DocumentService;
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> Documents = DocumentService.getAllDocuments();
        return ResponseEntity.ok(Documents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Integer id) {
        Document Document = DocumentService.getDocumentById(id);
        if (Document != null) {
            return ResponseEntity.ok(Document);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document Document) {
        Document createdDocument = DocumentService.createDocument(Document);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Integer id, @RequestBody Document Document) {
        Document updatedDocument = DocumentService.updateDocument(id, Document);
        if (updatedDocument != null) {
            return ResponseEntity.ok(updatedDocument);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Integer id) {
        boolean deleted = DocumentService.deleteDocument(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
