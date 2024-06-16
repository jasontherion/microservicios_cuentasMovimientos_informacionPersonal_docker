package com.microservicio.cuentasMovimientos.cuentasMovimientos.controller;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaCreacionDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.service.cuenta.ICuentaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/cuentas")
public class CuentaController {


   private final ICuentaService service;

   @RequestMapping("/listar")
   public ResponseEntity<RespuestaDTO> listarCuentas() {
      return service.listarCuentas();
   }

   @RequestMapping("/crear")
   public ResponseEntity<RespuestaDTO> crearCuenta(@Valid  @RequestBody CuentaCreacionDTO creacionDTO) {
      return service.crearCuenta(creacionDTO);
   }

   @RequestMapping("/actualizar/{id}")
   public ResponseEntity<RespuestaDTO> actualizarCuenta(@Valid @PathVariable("id") Long id,  @RequestBody  CuentaDTO cuentaDTO) {
      return service.actualizarCuenta(id, cuentaDTO);
   }

   @RequestMapping("/eliminar/{id}")
   public ResponseEntity<RespuestaDTO> eliminarCuenta(@PathVariable("id") Long id) {
      return service.eliminarCuenta(id);
   }

   @RequestMapping("/buscar/{id}")
   public ResponseEntity<CuentaDTO>  buscarCuenta(@PathVariable("id") Long id) {
      return service.consultarCuentaId(id);
   }


}
