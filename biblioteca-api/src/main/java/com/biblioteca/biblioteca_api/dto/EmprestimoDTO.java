package com.biblioteca.biblioteca_api.dto;

import com.biblioteca.biblioteca_api.entity.Emprestimo;
import java.time.LocalDate;

public class EmprestimoDTO {

    private Long id;
    private ClienteDTO cliente;
    private LivroDTO livro;
    private BibliotecarioDTO bibliotecario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private String status;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(Long id, ClienteDTO cliente, LivroDTO livro, BibliotecarioDTO bibliotecario,
                         LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista,
                         LocalDate dataDevolucaoReal, String status) {
        this.id = id;
        this.cliente = cliente;
        this.livro = livro;
        this.bibliotecario = bibliotecario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = status;
    }

    // Construtor a partir da Entidade Emprestimo
    public EmprestimoDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.cliente = emprestimo.getCliente() != null ? new ClienteDTO(emprestimo.getCliente()) : null;
        this.livro = emprestimo.getLivro() != null ? new LivroDTO(emprestimo.getLivro()) : null;
        this.bibliotecario = emprestimo.getBibliotecario() != null ? new BibliotecarioDTO(emprestimo.getBibliotecario()) : null;
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
        this.dataDevolucaoPrevista = emprestimo.getDataDevolucaoPrevista();
        this.dataDevolucaoReal = emprestimo.getDataDevolucaoReal();
        this.status = emprestimo.getStatus() != null ? emprestimo.getStatus().name() : null;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public LivroDTO getLivro() {
        return livro;
    }

    public void setLivro(LivroDTO livro) {
        this.livro = livro;
    }

    public BibliotecarioDTO getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(BibliotecarioDTO bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}