package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.dto.EmprestimoDTO;
import com.biblioteca.biblioteca_api.dto.EmprestimoRequestDTO;
import com.biblioteca.biblioteca_api.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> buscarTodos() {
        return ResponseEntity.ok(emprestimoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> realizarEmprestimo(@RequestBody EmprestimoRequestDTO dto) {
        EmprestimoDTO emprestimoSalvo = emprestimoService.realizarEmprestimo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
    }
}