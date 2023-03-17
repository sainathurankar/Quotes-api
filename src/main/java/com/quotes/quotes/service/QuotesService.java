package com.quotes.quotes.service;

import com.quotes.quotes.client.QuotesClient;
import com.quotes.quotes.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuotesService {

    @Autowired
    QuotesClient quotesClient;

    public Quote getQuote() {
        log.info("Getting quote from quotes service");
        try {
            return quotesClient.getQuote();
        } catch (Exception e) {
            log.error("Error getting quote from quotes service", e);
            throw e;
        } finally {
            log.info("Quote retrieved from quotes service");
        }
    }
}
