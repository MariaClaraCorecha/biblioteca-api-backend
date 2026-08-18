package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.entity.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    Optional<Bibliotecario> findByEmail(String email);
    Optional<Bibliotecario> findByMatriculaFuncional(String matriculaFuncional);
}