package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.reporte;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RangoFechaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import org.springframework.http.ResponseEntity;

public interface IReporteService {

    ResponseEntity<RespuestaDTO> reportes(RangoFechaDTO rangoFechaDTO, Long clienteId);
}
