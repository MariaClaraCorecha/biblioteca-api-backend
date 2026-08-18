package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.dto.RentalDTO;
import com.biblioteca.biblioteca_api.entity.Rental;
import com.biblioteca.biblioteca_api.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public ResponseEntity<Rental> create(@Valid @RequestBody RentalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Rental>> findAll() {
        return ResponseEntity.ok(rentalService.findAll());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Rental> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.returnBook(id));
    }
}