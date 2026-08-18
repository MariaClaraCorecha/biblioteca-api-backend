package com.biblioteca.biblioteca_api.dto;

import com.biblioteca.biblioteca_api.entity.Bibliotecario;

public class BibliotecarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String matriculaFuncional;

    public BibliotecarioDTO() {
    }

    public BibliotecarioDTO(Long id, String nome, String email, String matriculaFuncional) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matriculaFuncional = matriculaFuncional;
    }

    public BibliotecarioDTO(Bibliotecario bibliotecario) {
        this.id = bibliotecario.getId();
        this.nome = bibliotecario.getNome();
        this.email = bibliotecario.getEmail();
        this.matriculaFuncional = bibliotecario.getMatriculaFuncional();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMatriculaFuncional() { return matriculaFuncional; }
    public void setMatriculaFuncional(String matriculaFuncional) { this.matriculaFuncional = matriculaFuncional; }
}