package com.companeros.msvcautor.repositorio;

import com.companeros.msvcautor.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor,Long> {
}