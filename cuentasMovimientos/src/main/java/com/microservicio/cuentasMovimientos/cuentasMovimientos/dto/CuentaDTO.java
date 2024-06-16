package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuentaDTO {

    private Long cuentaId;

    private String numeroCuenta;

    private String tipo;

    private Float saldoInicial;

    private Boolean estado;

    private EntidadDTO entidad;

    private List<MovimientoDTO> movimientos;

    private Clientes clientes;
}
