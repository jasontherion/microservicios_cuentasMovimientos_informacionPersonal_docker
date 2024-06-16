package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;

import lombok.*;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResporteDTO {

    private LocalDate fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private Float saldoInicial;
    private Boolean estado;
    private Float movimiento;
    private Float saldoDisponible;
}
