package com.microservicio.cuentasMovimientos.cuentasMovimientos.controller;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RangoFechaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.service.reporte.IReporteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/reportes")
public class ReportesController {

    private final IReporteService service;

    @GetMapping("/listar")
    public ResponseEntity<RespuestaDTO> reportes(@RequestParam LocalDate fechaInicial, @RequestParam LocalDate fechaFinal, @RequestParam Long clienteId) {
        RangoFechaDTO rangoFechaDTO = new RangoFechaDTO(fechaInicial, fechaFinal);
        return service.reportes(rangoFechaDTO,clienteId);
    };
}
