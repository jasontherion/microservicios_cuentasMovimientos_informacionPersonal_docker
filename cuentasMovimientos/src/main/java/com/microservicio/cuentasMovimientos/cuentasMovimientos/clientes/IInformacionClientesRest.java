package com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "informacionPersonal", url = "http://localhost:8022")
public interface IInformacionClientesRest {

    @GetMapping("/clientes")
    RespuestaDTO listar();

    @GetMapping("/clientes/{id}")
    ResponseEntity<Clientes> detalle(@PathVariable Long id);
}
