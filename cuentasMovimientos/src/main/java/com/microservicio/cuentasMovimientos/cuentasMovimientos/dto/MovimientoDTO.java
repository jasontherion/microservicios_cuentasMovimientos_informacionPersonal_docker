package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoDTO {

    private Long movimentoId;

    private LocalDate fecha;

    private String tipoMovimiento;

    private Float valor;

    private Float saldo;

    private EntidadDTO entidad;

    private CuentaDTO cuenta;
}
