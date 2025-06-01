package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.DocumentDTO;
import com.hexaware.automobile.entities.Document;

import java.util.List;

public interface DocumentService {
    Document uploadDocument(DocumentDTO documentDTO);
    List<DocumentDTO> getDocumentsByProposalId(Long proposalId); // ← updated return type
    Document verifyDocument(Long id, boolean isVerified, String remarks);
}

