package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.entidad;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import org.springframework.http.ResponseEntity;

public interface IEntidadService {

    ResponseEntity<RespuestaDTO> listarEntidades();

    ResponseEntity<EntidadDTO> consultarEntidadId(Long id);

    ResponseEntity<RespuestaDTO>crearEntidad(EntidadDTO entidadDTO);

    ResponseEntity<RespuestaDTO> actualizarEntidad(Long id, EntidadDTO entidadDTO);

    ResponseEntity<RespuestaDTO> eliminarEntidad(Long id);


}
