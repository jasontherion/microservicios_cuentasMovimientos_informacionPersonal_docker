package com.microservicio.informacionPersonal.informacionPersonal.controller;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.dto.RespuestaDTO;
import com.microservicio.informacionPersonal.informacionPersonal.service.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
public class ClienteController {

    private final ClienteService service;


    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<ClientesDTO>>  listarClientes(){
        return new ResponseEntity<>(service.listarClientes(),HttpStatus.OK);
    }

    @RequestMapping(value="/{clienteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<ClientesDTO>>  clienteId(@PathVariable("clienteId") Long clienteId)  {
        return  new ResponseEntity<>(service.clienteId(clienteId), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Flux<RespuestaDTO>> crearClientes(@RequestBody ClienteContenedorDTO clienteContenedorDTO){
        return service.crearClientes(clienteContenedorDTO);
    }


    @PutMapping("/actualizar/{clienteId}")
    public ResponseEntity<Flux<RespuestaDTO>> actualizarClientes(@PathVariable("clienteId") Long clienteId ,@RequestBody ClienteContenedorDTO clienteContenedorDTO){
        return service.actualizarClientes(clienteId, clienteContenedorDTO);
    }

    @PatchMapping("/desavilitar/{clienteId}")
    public ResponseEntity<Flux<RespuestaDTO>>  desabilitarCliente(@PathVariable("clienteId") Long clienteId, @RequestBody EstadoDto estado)  {
        return service.desabilitarClientes(clienteId, estado);
    }


}
