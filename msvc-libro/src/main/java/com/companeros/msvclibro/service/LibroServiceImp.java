package com.companeros.msvclibro.service;

import com.companeros.msvclibro.client.AutorClient;
import com.companeros.msvclibro.entity.Autor;
import com.companeros.msvclibro.entity.Libro;
import com.companeros.msvclibro.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImp implements LIbroService {
    @Autowired
    private LibroRepositorio repositorio;
    @Autowired
    private AutorClient client;

    @Override
    public List<Libro> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Page<Libro> paginar(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    @Override
    public Optional<Libro> findByid(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        Optional<Autor> r = client.buscarUno(libro.getAutor().getId());
        Autor autor = null;
        if (r.isPresent()){
            autor = r.get();
        }
        return repositorio.save(libro);
    }

    @Override
    public void delte(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Libro> findByNombre(String termino) {
        return  repositorio.findByNombreContainingIgnoreCase(termino);
    }

    @Override
    public List<Autor> findAllAutor() {
        return client.todos();
    }

    @Override
    public Optional<Autor> findByAutor(Long id) {
        return client.buscarUno(id);
    }
}
