package com.microservicio.informacionPersonal.informacionPersonal.service.cliente;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.dto.RespuestaDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {

    Flux<ClientesDTO>  listarClientes();
    Mono<ClientesDTO> clienteId(Long Id);
    ResponseEntity<Flux<RespuestaDTO>> crearClientes(ClienteContenedorDTO clienteContenedorDTO);
    ResponseEntity<Flux<RespuestaDTO>> actualizarClientes(Long id , ClienteContenedorDTO clienteContenedorDTO);

    ResponseEntity<Flux<RespuestaDTO>> desabilitarClientes(Long id, EstadoDto estado);
}
