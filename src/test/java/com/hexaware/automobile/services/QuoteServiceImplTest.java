package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Quote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuoteServiceImplTest {

    @Autowired
    private QuoteService quoteService;

    @Test
    void testGetQuoteByProposalId() {
        Quote quote = quoteService.getQuoteByProposalId(1);
        assertNotNull(quote);
    }
}
