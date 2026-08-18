package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.dto.BibliotecarioDTO;
import com.biblioteca.biblioteca_api.entity.Bibliotecario;
import com.biblioteca.biblioteca_api.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<BibliotecarioDTO> buscarTodos() {
        return bibliotecarioRepository.findAll().stream()
                .map(BibliotecarioDTO::new)
                .collect(Collectors.toList());
    }

    public BibliotecarioDTO buscarPorId(Long id) {
        Bibliotecario bibliotecario = bibliotecarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bibliotecário não encontrado"));
        return new BibliotecarioDTO(bibliotecario);
    }

    public BibliotecarioDTO salvar(Bibliotecario bibliotecario) {
        bibliotecario = bibliotecarioRepository.save(bibliotecario);
        return new BibliotecarioDTO(bibliotecario);
    }
}