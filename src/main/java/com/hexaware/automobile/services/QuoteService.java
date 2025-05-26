package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Quote;

import java.util.List;

public interface QuoteService {
    Quote generateQuote(Quote quote);
    Quote getQuoteById(Integer id);
    Quote getQuoteByProposalId(Integer proposalId);
    List<Quote> getAllQuotes();
}
