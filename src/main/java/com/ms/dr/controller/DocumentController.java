package com.ms.dr.controller;

import com.ms.dr.exception.ResourceNotFoundException;
import com.ms.dr.model.Document;
import com.ms.dr.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("caseNumber") String caseNumber) throws IOException {
        documentService.uploadDocument(file, caseNumber);
        return "redirect:/"; // Redirect to home page or any other page after upload
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) {
        return documentService.downloadDocument(id);
    }

    // Additional CRUD operations can be implemented similarly
}
