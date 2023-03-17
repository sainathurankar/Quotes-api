package com.quotes.quotes.controller;

import com.quotes.quotes.model.Quote;
import com.quotes.quotes.service.QuotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @GetMapping("/quotes")
    public Quote getQuotes() {
        log.info("Getting quotes");
        try {
            return quotesService.getQuote();
        } catch (Exception e) {
            log.error("Error getting quotes", e);
            throw e;
        } finally {
            log.info("Finished getting quotes");
        }
    }
}
