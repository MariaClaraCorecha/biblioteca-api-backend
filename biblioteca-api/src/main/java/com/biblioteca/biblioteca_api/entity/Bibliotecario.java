package com.biblioteca.biblioteca_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_bibliotecarios")
public class Bibliotecario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(name = "matricula_funcional", nullable = false, unique = true, length = 30)
    private String matriculaFuncional;

    public Bibliotecario() {
    }

    public Bibliotecario(Long id, String nome, String email, String senha, String matriculaFuncional) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matriculaFuncional = matriculaFuncional;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatriculaFuncional() {
        return matriculaFuncional;
    }

    public void setMatriculaFuncional(String matriculaFuncional) {
        this.matriculaFuncional = matriculaFuncional;
    }
}