package fr.ln.nextLine.Controller;

import fr.ln.nextLine.Model.Dto.DocumentDTO;
import fr.ln.nextLine.Service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {

        this.documentService = documentService;
    }

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getAllDocuments() {

        return documentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Integer id) {

        return documentService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createDocument(@RequestBody DocumentDTO documentDTO) {

        return documentService.create(documentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDocument(@PathVariable Integer id, @RequestBody DocumentDTO documentDTO) {

        return documentService.update(id, documentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable Integer id) {

        return documentService.delete(id);

    }
}
