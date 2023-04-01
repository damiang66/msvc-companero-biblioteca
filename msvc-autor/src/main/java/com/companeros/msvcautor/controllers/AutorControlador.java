package com.companeros.msvcautor.controllers;

import com.companeros.msvcautor.entity.Autor;
import com.companeros.msvcautor.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class AutorControlador {
    @Autowired
    private AutorService service;

    /**
     * metodo para validar
     *
     * @param result
     * @return
     */
    private ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(e -> {
            errores.put(e.getField(), "El campo: " + e.getField() + "" + e.getDefaultMessage());

        });
        return new ResponseEntity<>(errores, HttpStatus.FOUND);
    }

    /**
     * metodo para listar todos
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    /**
     * metodo para paginar
     *
     * @param page
     * @return
     */
    @GetMapping("/paginar/{page}")
    public ResponseEntity<?> paginar(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return ResponseEntity.ok().body(service.paginar(pageable));
    }

    /**
     * metoto para buscar un autor por id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorid(@PathVariable Long id) {
        Optional<Autor> r = service.findById(id);
        if (r.isPresent()) {
            return ResponseEntity.ok().body(r.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * metodo para guardar
     *
     * @param autor
     * @param result
     * @return
     */
    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody Autor autor, BindingResult result) {
        if (result.hasErrors()) {
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(autor));
    }

    /**
     * metodo para editar
     *
     * @param autor
     * @param result
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Autor autor, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Optional<Autor> r = service.findById(id);
        if (r.isPresent()) {
            Autor autorDb = r.get();
            autorDb.setNombre(autor.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(autorDb));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * metodo para validar
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Autor> r = service.findById(id);
        if (r.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
