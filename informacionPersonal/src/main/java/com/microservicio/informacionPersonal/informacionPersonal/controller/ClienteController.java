package com.microservicio.informacionPersonal.informacionPersonal.controller;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.dto.RespuestaDTO;
import com.microservicio.informacionPersonal.informacionPersonal.service.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class ClienteController {

    private final ClienteService service;


    @GetMapping()
    public ResponseEntity<RespuestaDTO>  listarClientes(){
        return service.listarClientes();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClientesDTO>  clienteId(@PathVariable("clienteId") Long clienteId)  {
        return service.clienteId(clienteId);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO> crearClientes(@RequestBody ClienteContenedorDTO clienteContenedorDTO){
        return service.crearClientes(clienteContenedorDTO);
    }


    @PutMapping("/actualizar/{clienteId}")
    public ResponseEntity<RespuestaDTO> actualizarClientes(@PathVariable("clienteId") Long clienteId ,@RequestBody ClienteContenedorDTO clienteContenedorDTO){
        return service.actualizarClientes(clienteId, clienteContenedorDTO);
    }

    @PatchMapping("/desavilitar/{clienteId}")
    public ResponseEntity<RespuestaDTO>  desabilitarCliente(@PathVariable("clienteId") Long clienteId, @RequestBody EstadoDto estado)  {
        return service.desabilitarClientes(clienteId, estado);
    }


}
