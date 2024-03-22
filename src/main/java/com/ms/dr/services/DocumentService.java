package com.ms.dr.services;

import com.ms.dr.exception.ResourceNotFoundException;
import com.ms.dr.model.Document;
import com.ms.dr.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document uploadDocument(MultipartFile file, String caseNumber) throws IOException {
        Document document = new Document();
        document.setName(file.getOriginalFilename());
        document.setContentType(file.getContentType());
        document.setData(file.getBytes());
        document.setNumCase(caseNumber); // Corrected method call
        return documentRepository.save(document);
    }

    public ResponseEntity<Resource> downloadDocument(Long id) {
        Document document = documentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Document not found"));
        ByteArrayResource resource = new ByteArrayResource(document.getData());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(document.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getName() + "\"")
                .body(resource);
    }
}
