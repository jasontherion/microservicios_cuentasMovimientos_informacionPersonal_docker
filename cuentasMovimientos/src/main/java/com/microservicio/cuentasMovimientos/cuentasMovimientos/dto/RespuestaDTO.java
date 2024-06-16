package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class RespuestaDTO {

    private String mensage;
    private List<?> data;
}
