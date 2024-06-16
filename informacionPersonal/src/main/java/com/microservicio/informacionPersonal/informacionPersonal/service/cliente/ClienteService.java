package com.microservicio.informacionPersonal.informacionPersonal.service.cliente;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.dto.RespuestaDTO;
import org.springframework.http.ResponseEntity;

public interface ClienteService {

    ResponseEntity<RespuestaDTO> listarClientes();
    ResponseEntity<ClientesDTO> clienteId(Long Id);
    ResponseEntity<RespuestaDTO> crearClientes(ClienteContenedorDTO clienteContenedorDTO);
    ResponseEntity<RespuestaDTO> actualizarClientes(Long id , ClienteContenedorDTO clienteContenedorDTO);

    ResponseEntity<RespuestaDTO> desabilitarClientes(Long id, EstadoDto estado);
}
