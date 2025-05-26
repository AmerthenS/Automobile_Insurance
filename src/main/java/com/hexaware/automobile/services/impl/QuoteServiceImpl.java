package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Quote;
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
    public Quote getQuoteById(Integer id) {
        return quoteRepo.findById(id).orElse(null);
    }

    @Override
    public Quote getQuoteByProposalId(Integer proposalId) {
        return quoteRepo.findByProposalId(proposalId);
    }


    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepo.findAll();
    }
}
