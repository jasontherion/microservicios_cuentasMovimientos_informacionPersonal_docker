package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TipoMovimientoEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class MovimientoDTO {

    private Long movimentoId;

    private LocalDate fecha;

    private String tipoMovimiento;

    private Float valor;

    private Float saldo;

    private Entidades entidad;

    private Cuentas cuentas;
}
