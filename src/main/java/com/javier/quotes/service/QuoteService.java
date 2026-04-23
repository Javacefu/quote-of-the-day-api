package com.javier.quotes.service;

import com.javier.quotes.model.Quote;
import com.javier.quotes.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }

    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found with id: " + id));
    }

    public List<Quote> getQuotesByCategory(String category) {
        return quoteRepository.findByCategory(category);
    }

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public Quote updateQuote(Long id, Quote quoteDetails) {
        Quote quote = getQuoteById(id);
        quote.setContent(quoteDetails.getContent());
        quote.setAuthor(quoteDetails.getAuthor());
        quote.setCategory(quoteDetails.getCategory());
        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        Quote quote = getQuoteById(id);
        quoteRepository.delete(quote);
    }

    public Quote getQuoteOfTheDay() {
        List<Quote> allQuotes = quoteRepository.findAll();
        if (allQuotes.isEmpty()) {
            throw new RuntimeException("No quotes available");
        }
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = dayOfYear % allQuotes.size();
        return allQuotes.get(index);
    }
}