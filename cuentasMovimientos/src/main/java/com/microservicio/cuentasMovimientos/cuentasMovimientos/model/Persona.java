package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    private Long personaId;
    private String nombre;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String genero;

}
