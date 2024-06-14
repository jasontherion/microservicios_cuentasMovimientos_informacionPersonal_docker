package com.microservicio.cuentasMovimientos.cuentasMovimientos.controller;



import com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes.IInformacionClientesRest;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.service.cuenta.ICuentaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@RestController
@RequestMapping("/cuentas")
public class CuentaController {


   private final ICuentaService service;

    @GetMapping
    public List<Clientes>  listar(){
        return service.findAll();
    }

}
