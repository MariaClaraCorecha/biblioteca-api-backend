package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.dto.BookDTO;
import com.biblioteca.biblioteca_api.entity.Book;
import com.biblioteca.biblioteca_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book create(BookDTO dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .salePrice(dto.getSalePrice())
                .rentalDailyRate(dto.getRentalDailyRate())
                .saleStock(dto.getSaleStock())
                .rentalStock(dto.getRentalStock())
                .build();
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
    }
}