package com.microservicio.cuentasMovimientos.cuentasMovimientos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RangoFechaDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFinal;
}
