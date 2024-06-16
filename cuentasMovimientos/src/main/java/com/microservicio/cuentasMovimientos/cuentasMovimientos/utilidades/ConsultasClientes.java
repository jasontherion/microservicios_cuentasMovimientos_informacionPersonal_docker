package com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes.IInformacionClientesRest;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;


@AllArgsConstructor
@Builder
@Component
public class ConsultasClientes {


    private final IInformacionClientesRest clienteFeign;
    public  Clientes obtenerClientePorId(Long id) {
        try {
            ResponseEntity<Clientes> clientes = clienteFeign.detalle(id);
            if (clientes.getStatusCode() != HttpStatus.OK)
                throw new NoSuchElementException(String.format(ConstatesMesajes.CLIENTE_NO_EXISTE, id));
            Clientes cliente = clientes.getBody();
            return cliente;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
