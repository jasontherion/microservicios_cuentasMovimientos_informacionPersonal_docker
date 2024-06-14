package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.movimiento;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovimientoService {

    ResponseEntity<List<MovimientoDTO>> listarMovimientos();

    ResponseEntity<MovimientoDTO> consultarMovimientoId(Long id);

    ResponseEntity<String> crearMovimiento(MovimientoDTO movimientoDTO);

    ResponseEntity<String> actualizarMovimiento(Long id, MovimientoDTO movimientoDTO);

    ResponseEntity<String> eliminarMovimiento(Long id);
}
