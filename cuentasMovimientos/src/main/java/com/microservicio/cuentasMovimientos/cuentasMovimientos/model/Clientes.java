package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clientes {

    private Long clienteId;

    private String contrasenia;

    private Boolean estado;

    private Persona persona;


}
