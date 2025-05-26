package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    @Query("SELECT q FROM Quote q WHERE q.proposal.proposalId = :proposalId")
    Quote findByProposalId(@Param("proposalId") Integer proposalId);
}
