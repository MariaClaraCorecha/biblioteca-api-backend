package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.dto.RentalDTO;
import com.biblioteca.biblioteca_api.entity.Book;
import com.biblioteca.biblioteca_api.entity.Customer;
import com.biblioteca.biblioteca_api.entity.Rental;
import com.biblioteca.biblioteca_api.repository.BookRepository;
import com.biblioteca.biblioteca_api.repository.CustomerRepository;
import com.biblioteca.biblioteca_api.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    public Rental create(RentalDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + dto.getCustomerId()));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + dto.getBookId()));

        Rental rental = Rental.builder()
                .customer(customer)
                .book(book)
                .rentalDate(LocalDate.now())
                .status("ACTIVE")
                .build();

        return rentalRepository.save(rental);
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Rental returnBook(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com o ID: " + id));

        rental.setReturnDate(LocalDate.now());
        rental.setStatus("RETURNED");

        return rentalRepository.save(rental);
    }
}