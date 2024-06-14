package com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "informacionPersonal", url = "http://localhost:8022")
public interface IInformacionClientesRest {

    @GetMapping("/clientes")
    public List<Clientes>  listar();
}
