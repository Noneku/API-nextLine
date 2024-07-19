package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.DocumentDTO;
import fr.ln.nextLine.Model.Entity.Document;

public class DocumentMapper {

    private DocumentMapper() {}

    public static DocumentDTO toDTO(Document document) {
        if (document == null) {
            return null;
        }
        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setId(document.getId());
        documentDTO.setNomPdf(document.getNomPdf());
        documentDTO.setDateGenerationDocument(document.getDateGenerationDocument());
        documentDTO.setIdStage(document.getIdStage());

        return documentDTO;
    }

    public static Document toEntity(DocumentDTO documentDTO) {
        if (documentDTO == null) {
            return null;
        }
        Document document = new Document();

        document.setId(documentDTO.getId());
        document.setNomPdf(documentDTO.getNomPdf());
        document.setDateGenerationDocument(documentDTO.getDateGenerationDocument());
        document.setIdStage(documentDTO.getIdStage());

        return document;
    }
}

