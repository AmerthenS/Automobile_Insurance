/*
 * DocumentRepository.java
 * 
 * Repository interface extending JpaRepository to provide CRUD operations
 * for Document entities. Includes a custom method to retrieve documents
 * associated with a specific proposalId.
 * 
 * Author: Amerthen
 * Date: 2025-06-02
 */

package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByProposalId(Long proposalId);
}
