package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.cuenta;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaCreacionDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import org.springframework.http.ResponseEntity;

public interface ICuentaService {



    ResponseEntity<RespuestaDTO> listarCuentas();

    ResponseEntity<CuentaDTO>  consultarCuentaId(Long id);

    ResponseEntity<RespuestaDTO> crearCuenta(CuentaCreacionDTO creacionDTO);

    ResponseEntity<RespuestaDTO> actualizarCuenta(Long id, CuentaDTO cuentaDTO);

    ResponseEntity<RespuestaDTO> eliminarCuenta(Long id);
}
