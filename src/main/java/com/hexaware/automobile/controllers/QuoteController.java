package com.hexaware.automobile.controllers;

import com.hexaware.automobile.entities.Quote;
import com.hexaware.automobile.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    // Create
    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteRepository.save(quote);
    }

    // Read all
    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Quote getQuoteById(@PathVariable Integer id) {
        return quoteRepository.findById(id).orElse(null);
    }

    // Update
    @PutMapping("/{id}")
    public Quote updateQuote(@PathVariable Integer id, @RequestBody Quote updatedQuote) {
        return quoteRepository.findById(id).map(quote -> {
            quote.setProposal(updatedQuote.getProposal());
            quote.setPremiumAmount(updatedQuote.getPremiumAmount());
            quote.setSentAt(updatedQuote.getSentAt());
            quote.setPayment(updatedQuote.getPayment());
            return quoteRepository.save(quote);
        }).orElse(null);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Integer id) {
        quoteRepository.deleteById(id);
    }
}
