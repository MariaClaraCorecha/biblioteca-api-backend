package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.dto.EmprestimoDTO;
import com.biblioteca.biblioteca_api.dto.EmprestimoRequestDTO;
import com.biblioteca.biblioteca_api.entity.Bibliotecario;
import com.biblioteca.biblioteca_api.entity.Cliente;
import com.biblioteca.biblioteca_api.entity.Emprestimo;
import com.biblioteca.biblioteca_api.entity.Livro;
import com.biblioteca.biblioteca_api.repository.BibliotecarioRepository;
import com.biblioteca.biblioteca_api.repository.ClienteRepository;
import com.biblioteca.biblioteca_api.repository.EmprestimoRepository;
import com.biblioteca.biblioteca_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<EmprestimoDTO> buscarTodos() {
        return emprestimoRepository.findAll().stream()
                .map(EmprestimoDTO::new)
                .collect(Collectors.toList());
    }

    public EmprestimoDTO realizarEmprestimo(EmprestimoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Livro livro = livroRepository.findById(dto.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Bibliotecario bibliotecario = bibliotecarioRepository.findById(dto.getBibliotecarioId())
                .orElseThrow(() -> new RuntimeException("Bibliotecário não encontrado"));

        if (livro.getQuantidadeEstoque() <= 0) {
            throw new RuntimeException("Livro indisponível no estoque");
        }

        // Atualiza estoque
        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() - 1);
        if (livro.getQuantidadeEstoque() == 0) {
            livro.setDisponivel(false);
        }
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.setLivro(livro);
        emprestimo.setBibliotecario(bibliotecario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucaoPrevista(LocalDate.now().plusDays(14)); // Devolução em 14 dias
        emprestimo.setStatus(Emprestimo.StatusEmprestimo.ATIVO);

        emprestimo = emprestimoRepository.save(emprestimo);
        return new EmprestimoDTO(emprestimo);
    }
}