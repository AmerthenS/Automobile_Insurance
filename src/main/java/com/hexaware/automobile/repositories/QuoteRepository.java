/*
 * QuoteRepository.java
 * 
 * Repository interface extending JpaRepository to manage Quote entities
 * with Long IDs. Provides methods to find a Quote by the associated proposal's ID,
 * either by the proposal ID or by the Proposal entity itself.
 * 
 * Author: Amerthen
 * Date: 2025-06-02
 */
package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Proposal;
import com.hexaware.automobile.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Optional<Quote> findByProposalId(Long proposalId); 
	Object findByProposalId(Proposal proposal);

}
