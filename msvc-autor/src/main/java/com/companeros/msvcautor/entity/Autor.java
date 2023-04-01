package com.companeros.msvcautor.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @NotBlank()
    private  String nombre;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @PrePersist
    public void prePresit(){
        this.fecha= new Date();
    }

}
