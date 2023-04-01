package com.companeros.msvclibro.repositorio;

import com.companeros.msvclibro.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LibroRepositorio extends JpaRepository<Libro,Long> {
    public List<Libro>findByNombreContainingIgnoreCase(String term);
}
