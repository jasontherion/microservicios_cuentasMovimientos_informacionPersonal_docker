package com.microservicio.informacionPersonal.informacionPersonal.controller;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.service.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
public class ClienteController {

    private final ClienteService service;


    @GetMapping()
    public ResponseEntity<List<ClientesDTO>>  listarClientes(){
        return service.listarClientes();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClientesDTO>  clienteId(@PathVariable Long clienteId)  {
        return service.clienteId(clienteId);
    }

    @PostMapping()
    public ResponseEntity<String> crearClientes(@RequestBody ClienteContenedorDTO clienteContenedorDTO){
        return service.crearClientes(clienteContenedorDTO);
    }


    @PutMapping("/{clienteId}")
    public ResponseEntity<String> actualizarClientes(@PathVariable Long clienteId ,@RequestBody ClienteContenedorDTO clienteContenedorDTO){
        return service.actualizarClientes(clienteId, clienteContenedorDTO);
    }

    @PatchMapping("/{clienteId}")
    public ResponseEntity<String>  desabilitarCliente(@PathVariable Long clienteId, @RequestBody EstadoDto estado)  {
        return service.desabilitarClientes(clienteId, estado);
    }







}
