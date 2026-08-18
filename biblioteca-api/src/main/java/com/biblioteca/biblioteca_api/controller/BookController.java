package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.dto.BookDTO;
import com.biblioteca.biblioteca_api.entity.Book;
import com.biblioteca.biblioteca_api.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    /**
     * Cria um novo livro.
     *
     * @param dto o DTO contendo os dados do livro a ser criado
     * @return ResponseEntity com o livro criado e status HTTP 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(dto));
    }

    /**
     * Retorna todos os livros.
     *
     * @return ResponseEntity com a lista de livros e status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    /**
     * Retorna um livro pelo ID.
     *
     * @param id o ID do livro a ser retornado
     * @return ResponseEntity com o livro encontrado e status HTTP 200 (OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    /**
     * Atualiza um livro existente.
     *
     * @param id o ID do livro a ser atualizado
     * @param dto o DTO contendo os dados atualizados do livro
     * @return ResponseEntity com o livro atualizado e status HTTP 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookService.update(id, dto));
    }

    /**
     * Exclui um livro pelo ID.
     *
     * @param id o ID do livro a ser excluído
     * @return ResponseEntity sem conteúdo e status HTTP 204 (No Content)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}