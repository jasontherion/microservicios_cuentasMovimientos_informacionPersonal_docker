package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.entidad;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntidadService {

    ResponseEntity<List<EntidadDTO>> listarEntidades();

    ResponseEntity<EntidadDTO> consultarEntidadId(Long id);

    ResponseEntity<String> crearEntidad(EntidadDTO entidadDTO);

    ResponseEntity<String> actualizarEntidad(Long id, EntidadDTO entidadDTO);

    ResponseEntity<String> eliminarEntidad(Long id);


}
