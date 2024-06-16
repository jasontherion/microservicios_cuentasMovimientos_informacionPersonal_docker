package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CuentaCreacionDTO {
    @NotEmpty(message = "El numeroCuenta no puede ser vacio")
    @NotNull(message = "El numeroCuenta no puede ser nulo")
    private String numeroCuenta;
    @NotEmpty(message = "El tipo no puede ser vacio")
    @NotNull(message = "El tipo no puede ser nulo")
    private String tipo;
    private Float saldoInicial;
    private Boolean estado;
    @NotNull(message = "El entidadId no puede ser vacio")
    private Long entidadId;
    @NotNull(message = "El clienteId no puede ser vacio")
    private Long clienteId;
}
