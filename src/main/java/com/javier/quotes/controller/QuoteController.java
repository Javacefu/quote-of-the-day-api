package com.javier.quotes.controller;

import com.javier.quotes.model.Quote;
import com.javier.quotes.service.QuoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    // Listar todas las frases
    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return ResponseEntity.ok(quoteService.getAllQuotes());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        return ResponseEntity.ok(quoteService.getQuoteById(id));
    }

    // Buscar por categoria
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Quote>> getQuotesBy(@PathVariable String category) {
        return ResponseEntity.ok(quoteService.getQuotesByCategory(category));
    }

    // Frase del día
    @GetMapping("/today")
    public ResponseEntity<Quote> getQuoteOfTheDay() {
        return ResponseEntity.ok(quoteService.getQuoteOfTheDay());
    }

    // Crear Frase
    @PostMapping
    public ResponseEntity<Quote> createQuote(@Valid @RequestBody Quote quote) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quoteService.createQuote(quote));
    }

    // Modificar frase
    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @Valid @RequestBody Quote quote) {
        return ResponseEntity.ok(quoteService.updateQuote(id, quote));
    }

    // Eliminar frase
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }
}
