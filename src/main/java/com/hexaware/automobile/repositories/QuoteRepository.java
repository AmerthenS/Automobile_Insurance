package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Proposal;
import com.hexaware.automobile.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Optional<Quote> findByProposalId(Long proposalId); 
	Object findByProposalId(Proposal proposal);

}
