package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.dto.LivroDTO;
import com.biblioteca.biblioteca_api.entity.Livro;
import com.biblioteca.biblioteca_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDTO> buscarTodos() {
        return livroRepository.findAll().stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public LivroDTO buscarPorId(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return new LivroDTO(livro);
    }

    public LivroDTO salvar(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        livro.setDisponivel(dto.getQuantidadeEstoque() > 0);

        livro = livroRepository.save(livro);
        return new LivroDTO(livro);
    }
}