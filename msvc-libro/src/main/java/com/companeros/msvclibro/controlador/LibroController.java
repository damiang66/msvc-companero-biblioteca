package com.companeros.msvclibro.controlador;

import com.companeros.msvclibro.entity.Autor;
import com.companeros.msvclibro.entity.Libro;
import com.companeros.msvclibro.service.LIbroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
public class LibroController {
    @Autowired
    private LIbroService service;

    /**
     * metodo para validar
     * @param result
     * @return
     */
    private ResponseEntity<?>validar(BindingResult result){
        Map<String, Object>errores = new HashMap<>();
        result.getFieldErrors().forEach(e->{
            errores.put(e.getField(),"el campo:  "+ e.getField()+ " " + e.getDefaultMessage());
        });
        return new ResponseEntity<>(errores, HttpStatus.NOT_FOUND);
    }

    /**
     * metodo para listar todo
     * @return
     */
    @GetMapping
    public ResponseEntity<?>todos(){
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * metodo para paginar
     * @param pagina
     * @return
     */
    @GetMapping("/paginar/{pagina}")
    public ResponseEntity<?>paginar (@PathVariable Integer pagina){
        Pageable pageable = Pageable.ofSize(pagina);
        return ResponseEntity.ok().body(service.paginar(pageable));
    }

    /**
     * metodo para buscar por nombre
     * @param termino
     * @return
     */
    @GetMapping("/buscar/{termino}")
    public ResponseEntity<?>buscarPorNombre(@PathVariable String termino){
        return ResponseEntity.ok().body(service.findByNombre(termino));
    }

    /**
     * listar autores desde libro
     * @return
     */
    @GetMapping("/autor")
    public ResponseEntity<?>listarAutores(){
        return ResponseEntity.ok().body(service.findAllAutor());
    }


    @GetMapping("/autor/{id}")
    public ResponseEntity<?>buscarAutor(@PathVariable Long id){
        Optional<Autor>r = service.findByAutor(id);
        if (r.isPresent()){
            return ResponseEntity.ok().body(r.get());
        }
       return ResponseEntity.notFound().build();
    }

    /**
     * metodo para buscar un libro por id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarUno(@PathVariable Long id){
        Optional<Libro> r= service.findByid(id);
        if (r.isPresent()){
            return ResponseEntity.ok().body(r.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * metodo para guardar
     * @param libro
     * @param result
     * @return
     */
    @PostMapping
    public ResponseEntity<?>crear(@Valid @RequestBody Libro libro,BindingResult result){
        if (result.hasErrors()){
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(libro));
    }

    /**
     * metodo para editar
     * @param libro
     * @param result
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?>editar(@Valid @RequestBody Libro libro, BindingResult result,@PathVariable Long id){
        if (result.hasErrors()){
            return validar(result);
        }

        Optional<Libro> respuesta = service.findByid(id);
        Map<String, Object> response = new HashMap<>();
        if (respuesta.isPresent()){
            Libro libroDb = respuesta.get();
            libroDb.setNombre(libro.getNombre());
            libroDb.setEjemplares(libro.getEjemplares());
            Optional<Autor>r = service.findByAutor(libro.getAutor().getId());
                if (r.isPresent()){
                    libroDb.setAutor(r.get());
                    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(libroDb));
                }
                response.put("error", "el autor no exite o no puede estar vacio");
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }


        return ResponseEntity.notFound().build();
    }

    /**
     * metodo para eliminar
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete (@PathVariable Long id){
        Optional<Libro> r = service.findByid(id);
        if (r.isPresent()){
            service.delte(id);
            return new ResponseEntity<>("Libro eliminado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("error al eliminar el libro",HttpStatus.NOT_FOUND);
    }

}
