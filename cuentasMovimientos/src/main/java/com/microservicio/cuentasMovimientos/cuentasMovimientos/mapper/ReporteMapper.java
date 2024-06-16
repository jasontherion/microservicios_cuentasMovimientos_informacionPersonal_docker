package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.ResporteDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReporteMapper {



    default List<ResporteDTO> cuentasToReporteDTO(List<Cuentas> cuentas) {
        return cuentas.stream()
                .flatMap(c -> c.getMovimientos().stream()
                        .map(m -> ResporteDTO.builder()
                                .fecha(m.getFecha())
                                .cliente(null) // Usamos clienteId aquí
                                .numeroCuenta(c.getNumeroCuenta())
                                .tipo(m.getCuentas().getTipo().toString())
                                .saldoInicial(c.getSaldoInicial())
                                .estado(c.getEstado())
                                .movimiento(m.getValor())
                                .saldoDisponible(m.getTipoMovimiento().toString().equals("RETIRO")? c.getSaldoInicial() - m.getValor(): m.getTipoMovimiento().toString().equals("DEPOSITO")? c.getSaldoInicial() + m.getValor(): 0) // calcular esto correctamente
                                .build()))
                .collect(Collectors.toList());
    }
}
