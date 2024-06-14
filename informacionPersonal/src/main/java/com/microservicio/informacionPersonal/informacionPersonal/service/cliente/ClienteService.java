package com.microservicio.informacionPersonal.informacionPersonal.service.cliente;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    ResponseEntity<List<ClientesDTO>> listarClientes();
    ResponseEntity<ClientesDTO> clienteId(Long Id);
    ResponseEntity<String> crearClientes(ClienteContenedorDTO clienteContenedorDTO);
    ResponseEntity<String> actualizarClientes(Long id , ClienteContenedorDTO clienteContenedorDTO);

    ResponseEntity<String> desabilitarClientes(Long id, EstadoDto estado);
}
