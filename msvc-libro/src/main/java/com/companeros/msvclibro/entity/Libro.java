package com.companeros.msvclibro.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotNull
    private Integer ejemplares;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Long idAutor;
    @Transient
    private Autor autor;
    @PrePersist
    public void pre(){
        this.fecha= new Date();
    }
}
