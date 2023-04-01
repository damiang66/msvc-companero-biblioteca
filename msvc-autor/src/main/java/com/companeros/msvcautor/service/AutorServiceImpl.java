package com.companeros.msvcautor.service;

import com.companeros.msvcautor.entity.Autor;
import com.companeros.msvcautor.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AutorServiceImpl implements AutorService{
    @Autowired
    private AutorRepositorio repositorio;
    @Override
    public List<Autor> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Page<Autor> paginar(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    @Override
    public Optional<Autor> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return repositorio.save(autor);
    }

    @Override
    public void delete(Long id) {
    repositorio.deleteById(id);
    }
}
