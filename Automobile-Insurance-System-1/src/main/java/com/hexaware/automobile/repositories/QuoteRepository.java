package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    Quote findByProposal_ProposalId(Integer proposal_id);
}
