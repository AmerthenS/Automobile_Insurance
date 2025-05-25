package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.Quote;

import java.util.List;

public interface QuoteService {
    Quote generateQuote(Quote quote);
    Quote getQuoteById(Integer quote_id);
    Quote getQuoteByProposalId(Integer proposal_id);
    List<Quote> getAllQuotes();
}
