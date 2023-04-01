package com.companeros.msvclibro.client;

import com.companeros.msvclibro.entity.Autor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "msvc-autor")
public interface  AutorClient {
    @GetMapping
    List<Autor>todos();
    @GetMapping("/{id}")
    Optional<Autor> buscarUno(@PathVariable Long id);
}
