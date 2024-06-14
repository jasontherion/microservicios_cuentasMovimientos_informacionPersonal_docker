package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TiposCuentasEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CuentaDTO {

    private Long cuentasId;

    private String numeroCuenta;

    private String tipo;

    private Float saldoInicial;

    private Boolean estado;

    private Entidades entidad;

    private List<MovimientoDTO> movimientos;
}
