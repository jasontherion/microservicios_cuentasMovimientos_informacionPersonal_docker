package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.cuenta;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICuentaService {


    public List<Clientes> findAll();

    ResponseEntity<List<CuentaDTO>> listarCuentas();

    ResponseEntity<CuentaDTO> consultarCuentaId(Long id);

    ResponseEntity<String> crearCuenta(CuentaDTO cuentaDTO);

    ResponseEntity<String> actualizarCuenta(Long id, CuentaDTO cuentaDTO);

    ResponseEntity<String> eliminarCuenta(Long id);
}
