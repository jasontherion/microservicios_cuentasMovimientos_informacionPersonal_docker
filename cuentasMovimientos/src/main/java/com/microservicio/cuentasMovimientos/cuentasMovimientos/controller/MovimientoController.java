package com.microservicio.cuentasMovimientos.cuentasMovimientos.controller;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.service.movimiento.IMovimientoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private IMovimientoService service;

    @GetMapping("/listar")
    public ResponseEntity<RespuestaDTO> listarMovimientos(){
        return service.listarMovimientos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MovimientoDTO> buscarMovimiento(@PathVariable("id") Long id){
        return service.consultarMovimientoId(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RespuestaDTO> actualizarMovimiento(@PathVariable("id") Long id, @RequestBody MovimientoDTO movimientoDTO){
        return service.actualizarMovimiento(id, movimientoDTO);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO> crearMovimiento(@RequestBody MovimientoDTO movimientoDTO){

        return service.crearMovimiento(movimientoDTO);

    }


}
