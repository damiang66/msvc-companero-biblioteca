package com.companeros.msvclibro.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Autor {
    private Long id;
    private String nombre;
    private Date fecha;
}
