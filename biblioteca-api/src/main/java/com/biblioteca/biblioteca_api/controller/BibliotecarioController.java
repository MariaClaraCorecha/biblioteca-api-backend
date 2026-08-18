package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.dto.BibliotecarioDTO;
import com.biblioteca.biblioteca_api.entity.Bibliotecario;
import com.biblioteca.biblioteca_api.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @GetMapping
    public ResponseEntity<List<BibliotecarioDTO>> buscarTodos() {
        return ResponseEntity.ok(bibliotecarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecarioDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bibliotecarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<BibliotecarioDTO> salvar(@RequestBody Bibliotecario bibliotecario) {
        BibliotecarioDTO bibliotecarioSalvo = bibliotecarioService.salvar(bibliotecario);
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioSalvo);
    }
}