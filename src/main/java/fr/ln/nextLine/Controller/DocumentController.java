package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.DocumentDTO;
import fr.ln.nextLine.Model.Entity.Document;
import fr.ln.nextLine.Model.Mapper.DocumentMapper;
import fr.ln.nextLine.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        List<DocumentDTO> documentsDTOs =
                    documents
                            .stream()
                            .map(DocumentMapper::toDTO)
                            .toList();
        return ResponseEntity.ok(documentsDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Integer id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            return ResponseEntity.ok(DocumentMapper.toDTO(document));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DocumentDTO> createDocument(@RequestBody Document document) {
        Document createdDocument = documentService.createDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(DocumentMapper.toDTO(createdDocument));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> updateDocument(@PathVariable Integer id, @RequestBody Document document) {
        Document updatedDocument = documentService.updateDocument(id, document);
        if (updatedDocument != null) {
            return ResponseEntity.ok(DocumentMapper.toDTO(updatedDocument));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Integer id) {
        boolean deleted = documentService.deleteDocument(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
