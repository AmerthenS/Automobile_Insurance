package com.hexaware.automobile.controllers;

import com.hexaware.automobile.dtos.DocumentDTO;
import com.hexaware.automobile.entities.Document;
import com.hexaware.automobile.services.DocumentService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentService documentService;

    
    @PostMapping
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<Document> uploadDocument(@Valid @RequestBody DocumentDTO documentDTO) {
        logger.info("Uploading document for proposal ID {}", documentDTO.getProposalId());
        Document savedDocument = documentService.uploadDocument(documentDTO);
        return ResponseEntity.ok(savedDocument);
    }

    
    @GetMapping("/proposal/{proposalId}")
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<List<DocumentDTO>> getDocumentsByProposalId(@PathVariable Long proposalId) {
        logger.info("Fetching documents for proposal ID {}", proposalId);
        List<DocumentDTO> documents = documentService.getDocumentsByProposalId(proposalId);
        return ResponseEntity.ok(documents);
    }

    
    @PutMapping("/{id}/verify")
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<Document> verifyDocument(
            @PathVariable Long id,
            @RequestParam boolean verified,
            @RequestParam(required = false) String remarks) {
        
        logger.info("Verifying document ID {} - status: {}, remarks: {}", id, verified, remarks);
        Document updatedDocument = documentService.verifyDocument(id, verified, remarks);
        return ResponseEntity.ok(updatedDocument);
    }
}
