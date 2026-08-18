package com.biblioteca.biblioteca_api.dto;

public class EmprestimoRequestDTO {

    private Long clienteId;
    private Long livroId;
    private Long bibliotecarioId;

    public EmprestimoRequestDTO() {
    }

    public EmprestimoRequestDTO(Long clienteId, Long livroId, Long bibliotecarioId) {
        this.clienteId = clienteId;
        this.livroId = livroId;
        this.bibliotecarioId = bibliotecarioId;
    }

    // Getters e Setters

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getBibliotecarioId() {
        return bibliotecarioId;
    }

    public void setBibliotecarioId(Long bibliotecarioId) {
        this.bibliotecarioId = bibliotecarioId;
    }
}