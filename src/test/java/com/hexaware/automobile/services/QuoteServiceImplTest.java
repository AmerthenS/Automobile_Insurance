package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.*;
import com.hexaware.automobile.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuoteServiceImplTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    public void testCreateReadUpdateQuote() {
        
        Proposal proposal = proposalRepository.findById(1).orElse(null);
        assertNotNull(proposal, "Proposal with ID 1 must exist for this test to pass");

       
        Quote quote = new Quote();
        quote.setProposal(proposal);
        quote.setPremiumAmount(new BigDecimal("2500.00"));
        quote.setSentAt(LocalDateTime.now());

        
        Quote savedQuote = quoteRepository.save(quote);
        assertNotNull(savedQuote);
        assertNotNull(savedQuote.getQuoteId(), "Quote ID should be auto-generated");

        
        Optional<Quote> retrieved = quoteRepository.findById(savedQuote.getQuoteId());
        assertTrue(retrieved.isPresent(), "Saved quote should be found in DB");
        assertEquals(proposal.getProposalId(), retrieved.get().getProposal().getProposalId());

        
        retrieved.get().setPremiumAmount(new BigDecimal("2700.00"));
        Quote updated = quoteRepository.save(retrieved.get());
        assertEquals(new BigDecimal("2700.00"), updated.getPremiumAmount(), "Premium amount should be updated");
    }
}
