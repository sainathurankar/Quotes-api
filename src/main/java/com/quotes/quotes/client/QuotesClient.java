package com.quotes.quotes.client;

import com.quotes.quotes.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class QuotesClient {

    @Value("${quotes.api.url}")
    private String url;

    public Quote getQuote() {
        log.info("Getting quote from {}", url);
        RestTemplate restTemplate = new RestTemplate();
        try {
            Quote quote = restTemplate.getForObject(url, Quote.class);
            log.info("Quote: {}", quote.getQuote());
            return quote;
        } catch (Exception e) {
            log.error("Error getting quote", e);
            return null;
        } finally {
            log.info("Quote retrieved ended");
        }
    }
}
