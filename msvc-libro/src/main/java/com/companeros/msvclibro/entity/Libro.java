package com.companeros.msvclibro.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private Integer ejemplares;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Autor autor;

}
