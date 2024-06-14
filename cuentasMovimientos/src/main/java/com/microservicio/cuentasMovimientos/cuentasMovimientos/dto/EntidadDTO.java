package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
public class EntidadDTO {
    private Long entidadId;
    private String nombre;
    private List<CuentaDTO> cuentas;
    private List<Movimientos> movimientos;
}
