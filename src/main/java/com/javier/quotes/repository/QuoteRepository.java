package com.javier.quotes.repository;

import com.javier.quotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByCategory(String category);

}