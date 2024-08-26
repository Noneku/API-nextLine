package fr.ln.nextLine.Service.ServiceImpl;

import fr.ln.nextLine.Model.Dto.DocumentDTO;
import fr.ln.nextLine.Model.Dto.FormulaireDTO;
import fr.ln.nextLine.Model.Entity.Document;
import fr.ln.nextLine.Model.Mapper.DocumentMapper;
import fr.ln.nextLine.Model.Repository.DocumentRepository;
import fr.ln.nextLine.Service.DocumentService;
import jakarta.transaction.Transactional;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {

        this.documentRepository = documentRepository;
    }

    @Override
    public ResponseEntity<List<DocumentDTO>> getAll() {

        List<DocumentDTO> documentDTOs = documentRepository.findAll()
                .stream()
                .map(DocumentMapper::toDTO)
                .toList();

        if (documentDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(documentDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DocumentDTO> getById(Integer id) {

        Optional<Document> document = documentRepository.findById(id);

        return document.map(
                        value -> new ResponseEntity<>(DocumentMapper.toDTO(value), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<DocumentDTO> create(DocumentDTO documentDTO) {

        Document document = DocumentMapper.toEntity(documentDTO);
        Document createdDocument = documentRepository.save(document);
        DocumentDTO createdDocumentDTO = DocumentMapper.toDTO(createdDocument);

        return new ResponseEntity<>(createdDocumentDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DocumentDTO> update(Integer id, DocumentDTO documentDTO) {

        if (documentRepository.existsById(id)) {

            Document document = DocumentMapper.toEntity(documentDTO);
            document.setId(id);
            Document updatedDocument = documentRepository.save(document);
            DocumentDTO updatedDocumentDTO = DocumentMapper.toDTO(updatedDocument);

            return new ResponseEntity<>(updatedDocumentDTO, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {

        Optional<Document> documentOptional = documentRepository.findById(id);

        if (documentOptional.isPresent()) {

            documentRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public void generatePDF(FormulaireDTO formulaireDTO, String filePath) {

        // Créer un nouveau document PDF
        try (PDDocument document = new PDDocument()) {

            // Ajouter une page
            PDPage page = new PDPage();
            document.addPage(page);

            // Préparer le contenu de la page
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.OVERWRITE, true)) {

                // Définir la police
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

                // Ajouter des informations à la page
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 750);  // Positionnement du texte

                // Exemple d'ajout de données
                contentStream.showText("Utilisateur: " + formulaireDTO.getUtilisateurDTO().getNomUtilisateur());
                contentStream.newLine();
                contentStream.showText("Formation: " + formulaireDTO.getFormationDTO().getNomFormation());
                contentStream.newLine();
                contentStream.showText("Session: " + formulaireDTO.getSessionDTO().getNumeroOffre());
                contentStream.endText();

                // Terminer le contenu de la page
            }

            // Sauvegarder le document
            document.save(filePath);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}

