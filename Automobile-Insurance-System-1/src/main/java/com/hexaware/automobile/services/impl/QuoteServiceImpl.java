package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entity.Quote;
import com.hexaware.automobile.repositories.QuoteRepository;
import com.hexaware.automobile.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepo;

    @Override
    public Quote generateQuote(Quote quote) {
        return quoteRepo.save(quote);
    }

    @Override
    public Quote getQuoteById(Integer quote_id) {
        return quoteRepo.findById(quote_id).orElse(null);
    }

    @Override
    public Quote getQuoteByProposalId(Integer proposal_id) {
        return quoteRepo.findByProposal_ProposalId(proposal_id);
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepo.findAll();
    }
}
