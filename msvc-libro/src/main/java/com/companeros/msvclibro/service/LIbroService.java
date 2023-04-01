package com.companeros.msvclibro.service;

import com.companeros.msvclibro.entity.Autor;
import com.companeros.msvclibro.entity.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LIbroService {
    public List<Libro>findAll();
    public Page<Libro>paginar(Pageable pageable);
    public Optional<Libro>findByid(Long id);
    public Libro save (Libro libro);
    public void delte(Long id);
    public List<Libro> findByNombre(String termino);
    // para client feing
    public List<Autor>findAllAutor();
    public Optional<Autor>findByAutor(Long id);
}
