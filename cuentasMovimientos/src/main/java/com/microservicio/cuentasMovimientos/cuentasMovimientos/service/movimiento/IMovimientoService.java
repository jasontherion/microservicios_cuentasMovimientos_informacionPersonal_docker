package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.movimiento;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import org.springframework.http.ResponseEntity;

public interface IMovimientoService {

    ResponseEntity<RespuestaDTO> listarMovimientos();

    ResponseEntity<MovimientoDTO> consultarMovimientoId(Long id);

    ResponseEntity<RespuestaDTO> crearMovimiento(MovimientoDTO movimientoDTO);

    ResponseEntity<RespuestaDTO> actualizarMovimiento(Long id, MovimientoDTO movimientoDTO);

    ResponseEntity<RespuestaDTO> eliminarMovimiento(Long id);
}
