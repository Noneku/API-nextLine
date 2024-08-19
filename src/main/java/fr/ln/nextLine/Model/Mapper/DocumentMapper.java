package fr.ln.nextLine.Model.Mapper;

import fr.ln.nextLine.Model.Dto.DocumentDTO;
import fr.ln.nextLine.Model.Dto.StageDTO;
import fr.ln.nextLine.Model.Entity.Document;
import fr.ln.nextLine.Model.Entity.Stage;

public class DocumentMapper {

    private DocumentMapper() {}

    public static DocumentDTO toDTO(Document document) {
        if (document == null) {
            return null;
        }

        StageDTO stageDTO = StageMapper.toDTO(document.getIdStage());

        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setId(document.getId());
        documentDTO.setNomPdf(document.getNomPdf());
        documentDTO.setDateGenerationDocument(document.getDateGenerationDocument());
        documentDTO.setIdStage(stageDTO);

        return documentDTO;
    }

    public static Document toEntity(DocumentDTO documentDTO) {
        if (documentDTO == null) {
            return null;
        }

        Stage stage = StageMapper.toEntity(documentDTO.getIdStage());

        Document document = new Document();

        document.setId(documentDTO.getId());
        document.setNomPdf(documentDTO.getNomPdf());
        document.setDateGenerationDocument(documentDTO.getDateGenerationDocument());
        document.setIdStage(stage);

        return document;
    }
}

