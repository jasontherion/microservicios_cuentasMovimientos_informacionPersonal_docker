package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clientes {

    private Long clienteId;

    private String contrasenia;

    private Boolean estado;
}
