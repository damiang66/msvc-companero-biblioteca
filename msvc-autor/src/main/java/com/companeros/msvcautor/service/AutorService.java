package com.companeros.msvcautor.service;

import com.companeros.msvcautor.entity.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    public List<Autor>findAll();
    Page<Autor>paginar(Pageable pageable);
    public Optional<Autor>findById(Long id);
    public Autor save (Autor autor);
    public void delete(Long id);
}
