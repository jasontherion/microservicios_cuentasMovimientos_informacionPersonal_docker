package com.microservicio.cuentasMovimientos.cuentasMovimientos.controller;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.service.entidad.IEntidadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entidades")
public class EntidadesController {

    private final IEntidadService service;

    @GetMapping("/listar")
    public ResponseEntity<RespuestaDTO> listarEntidades(){
        return service.listarEntidades();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EntidadDTO> listarTodasLasEntidades(@Validated @PathVariable("id") Long id){
        return service.consultarEntidadId(id);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<RespuestaDTO> eliminarEntidad(@Validated  @PathVariable("id") Long id){
        return service.eliminarEntidad(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO> crearEntidad(@Validated @RequestBody EntidadDTO entidadDTO){
        return service.crearEntidad(entidadDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RespuestaDTO> actualizarEntidad(@Validated @PathVariable("id") Long id, @RequestBody EntidadDTO entidadDTO){
        return service.actualizarEntidad(id, entidadDTO);
    }
}
